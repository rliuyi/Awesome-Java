package tutorials.jenkov.com.stream;

import java.util.ArrayList;
import java.util.List;

public class CollectionStream {

    private static String reduce() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("you");
        return list.stream().reduce((acc, item) -> {
            return acc + " " + item;
        }).get();
    }

    private static String reduceWithInitialAcc() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("you");
        return list.stream().reduce("InitialAcc", (acc, item) -> {
            return acc + " " + item;
        });
    }

    public static void main(String[] args) {
        System.out.println(reduce());
        System.out.println(reduceWithInitialAcc());
    }
}
