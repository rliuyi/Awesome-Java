package tutorials.jenkov.com.fp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CollectionsTest {
    private static void sort() {
        List<String> list = new ArrayList<String>();
        list.add("world");
        list.add("hello");
        list.add("you");

        Collections.sort(list, String::compareTo);

        System.out.println(list);
    }

    private static void sortReverse() {
        List<String> list = new ArrayList<String>();
        list.add("world");
        list.add("hello");
        list.add("you");

        Comparator<String> comparator = String::compareTo;
        comparator = comparator.reversed();

        Collections.sort(list, comparator);

        System.out.println(list);
    }
    
    private static void consumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");
    }

    public static void main(String[] args) {
        sort();
        sortReverse();
        consumer();
    }
}
