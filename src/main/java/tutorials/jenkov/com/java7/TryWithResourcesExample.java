package tutorials.jenkov.com.java7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class TryWithResourcesExample {

    private static void printFile() throws FileNotFoundException, IOException {
        System.out.println(TryWithResourcesExample.class.getClassLoader());
        URL txtUrl = TryWithResourcesExample.class.getResource("content.txt");
        try (FileInputStream input = new FileInputStream(new File(txtUrl.getFile()))) {
            int data = input.read();
            while (-1 != data) {
                System.out.println((char) data);
                data = input.read();
            }
        }
    }

    private static void printFileWithBufferedStream() throws FileNotFoundException, IOException {
        System.out.println(TryWithResourcesExample.class.getClassLoader());
        URL txtUrl = TryWithResourcesExample.class.getResource("content.txt");
        try (FileInputStream input = new FileInputStream(new File(txtUrl.getFile()));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(input)) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = bufferedInputStream.read();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        printFile();
        printFileWithBufferedStream();
    }

}
