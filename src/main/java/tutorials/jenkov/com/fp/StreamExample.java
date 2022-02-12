package tutorials.jenkov.com.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    private static List<String> list = new ArrayList<String>();
    static {
        list.add("hello world guys!");
        list.add("I am student.");
        list.add("what are you doing?");
    }

    private static long mapAndCount() {
        System.out.println("--- mapAndCount ---");
        Stream<String> stream = list.stream();
        return stream.map((element) -> {
            return element.toLowerCase();
        }).count();
    }

    private static void flatMap() {
        System.out.println("--- flatMap ---");
        Stream<String> stream = list.stream();
        stream.flatMap((element) -> {
            String[] split = element.split(" ");
            List<String> list = Arrays.asList(split);
            return list.stream();
        }).forEach((value) -> {
            System.out.println(value);
        });
    }

    private static void distinct() {
        System.out.println("--- distinct ---");
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");

        Stream<String> stream = list.stream();
        List<String> distinctStrings = stream.distinct().collect(Collectors.toList());

        System.out.println(distinctStrings);
    }

    private static void peek() {
        System.out.println("--- peek ---");
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        Stream<String> stream = list.stream();
        stream.peek((element) -> {
            System.out.println(element);
        }).forEach((element) -> {
            System.out.println(String.format("foreach: %s", element));
        });
    }

    private static void reduce() {
        System.out.println("--- reduce ---");
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        Optional<String> reduced = stream.reduce((value, combinedValue) -> {
            return combinedValue + " + " + value;
        });

        System.out.println(reduced.get());
    }

    public static void main(String[] args) {
        System.out.println(mapAndCount());
        flatMap();
        distinct();
        peek();
        reduce();
    }
}
