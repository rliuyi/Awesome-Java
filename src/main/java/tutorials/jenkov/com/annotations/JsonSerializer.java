package tutorials.jenkov.com.annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonSerializer {
    public String serialize(Object object) throws IllegalArgumentException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        Map<String, String> jsonMap = new HashMap<String, String>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                jsonMap.put(getSerializedKey(field), (String) field.get(object));
            }
        }
        System.out.println(toJsonString(jsonMap));
        return toJsonString(jsonMap);
    }

    private static String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet().stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        JsonSerializer jsonSerializer = new JsonSerializer();
        Car car = new Car("Ford", "F150", "2018");
        jsonSerializer.serialize(car);
    }
}
