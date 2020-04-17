package main.java.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Подписываем слушателей на обновления observable
 */
public class Observer {
    public static void main(String[] args) {
        SimpleWriter writer = new SimpleWriter();
        Reader reader1 = new SimpleReader();
        Reader reader2 = new Critic();
        writer.addReader(reader1);
        writer.addReader(reader2);
        writer.setMessage("JIOX");
    }
}

interface IWriter {
    void addReader(Reader reader);
    void removeReader(Reader reader);
    void notifyReaders();
}

class SimpleWriter implements IWriter {
    List<Reader> readers = new ArrayList<>();
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.notifyReaders();
    }

    @Override
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    @Override
    public void removeReader(Reader reader) {
        readers.add(reader);
    }

    @Override
    public void notifyReaders() {
        readers.forEach(reader -> reader.read(message));
    }
}

interface Reader {
    void read(String message);
}

class SimpleReader implements Reader {

    @Override
    public void read(String message) {
        System.out.println("Прочту " + message);
    }
}

class Critic implements Reader {

    @Override
    public void read(String message) {
        System.out.println("Напишу рецензию");
    }
}