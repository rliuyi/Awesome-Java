package tutorials.jenkov.com.lambda;

public class MyLambdaExpression {

    private static String str1 = "String 1";
    private String str2 = "String 2";

    private void doIt() {
        final String localVar = "local str";
        MyInterface myInterface = (message) -> {
            System.out.println(String.format("Lambda: %s, %s, %s, %s", MyLambdaExpression.str1, this.str2, localVar, message));
        };
        myInterface.apply("lambda str");
        myInterface.printToSystemOut("default method");
        MyInterface.contact("static method");
    }

    public static void main(String[] args) {
        MyLambdaExpression myLambdaExpression = new MyLambdaExpression();
        myLambdaExpression.doIt();
        str1 = "String Change 1";
        myLambdaExpression.str2 = "String Change 2";
        myLambdaExpression.doIt();
    }
}
