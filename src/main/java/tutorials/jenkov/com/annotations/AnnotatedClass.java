package tutorials.jenkov.com.annotations;

@CustomAnnotation(name = "your annotation")
public class AnnotatedClass {
    public static void main(String[] args) {
        CustomAnnotation annotation = AnnotatedClass.class.getAnnotation(CustomAnnotation.class);
        System.out.println(String.format("The value of element 'name' for CustomAnnotation is %s.", annotation.name()));
    }
}
