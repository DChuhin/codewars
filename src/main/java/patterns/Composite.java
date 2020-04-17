package main.java.patterns;

import java.util.Arrays;

public class Composite {

}

/**
 * все упаковываем в 1 структуру (вложенную)
 */
interface File {
    void visit();
}

/**
 * элемент может быть файл
 */
class SingleFile implements File {

    @Override
    public void visit() {
        System.out.println("Visit file");
    }
}

/**
 * или папка
 */
class Folder implements File {

    File[] children;

    @Override
    public void visit() {
        System.out.println("Visit folder");
        Arrays.stream(children).forEach(File::visit);
    }
}