package tutorials.jenkov.com.lambda;

public class MyClass {
    public static int doFind(String s1, String s2) {
        return s1.lastIndexOf(s2);
    }

    public int instanceDoFind(String s1, String s2) {
        return s1.indexOf(s2);
    }

    public MyClass() {
    }

    public MyClass(String s1, String s2) {
        System.out.println(String.format("%s, %s", s1, s2));
    }

    public static void main(String[] args) {
        // Normal lambda expression
        Finder finder = (s1, s2) -> {
            return MyClass.doFind(s1, s2);
        };
        System.out.println(finder.find("Hello", "l"));

        // Static method reference
        finder = MyClass::doFind;
        System.out.println(finder.find("Hello", "l"));

        // Parameter method reference
        finder = String::indexOf;
        System.out.println(finder.find("Hello", "l"));

        // Instance method reference
        finder = new MyClass()::instanceDoFind;
        System.out.println(finder.find("Hello", "e"));

        // Constructor reference
        MyClassFactory myClassFactory = MyClass::new;
        myClassFactory.create("Hello", "World");
    }
}
