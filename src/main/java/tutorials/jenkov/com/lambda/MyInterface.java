package tutorials.jenkov.com.lambda;

public interface MyInterface {
    void apply(String message);
    
    default void printToSystemOut(String text) {
        System.out.println(text);
    }
    
    static void contact(String text) {
        System.out.println(String.format("Hello %s", text));
    }
}
