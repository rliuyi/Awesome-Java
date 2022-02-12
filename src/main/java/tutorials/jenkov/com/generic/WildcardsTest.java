package tutorials.jenkov.com.generic;

import java.util.ArrayList;
import java.util.List;

class A {}

class B extends A {}

class C extends A {}


public class WildcardsTest {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        List<?> list1 = new ArrayList<A>();
        @SuppressWarnings("unused")
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<A>();
        list3.add(new A());
        list3.add(new B());
        list3.add(new C());
    }

}
