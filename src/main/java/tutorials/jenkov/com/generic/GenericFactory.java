package tutorials.jenkov.com.generic;

public class GenericFactory<T> {
    Class<T> theClass = null;

    public GenericFactory(Class<T> theClass) {
        this.theClass = theClass;
    }

    public T createInstance() throws InstantiationException, IllegalAccessException {
        return this.theClass.newInstance();
    }
    
    public static <T> T getInstance(Class<T> theClass) throws InstantiationException, IllegalAccessException {
        return theClass.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        GenericFactory<String> genericFactory = new GenericFactory<String>(String.class);
        String str = genericFactory.createInstance();
        System.out.println(str);
    }

}
