package tutorials.jenkov.com.fp;

import java.util.function.Function;

public class FunctionComposition {
    private static void composeFunction() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add = (value) -> value + 3;
        
        Function<Integer, Integer> composedFunc = multiply.compose(add);
        Integer intValue = composedFunc.apply(3);
        System.out.println(intValue);
        
        Function<Integer, Integer> andThenFunc = multiply.andThen(add);
        intValue = andThenFunc.apply(3);
        System.out.println(intValue);
    }
    
    public static void main(String[] args) {
        composeFunction();
    }
}
