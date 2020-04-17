package main.java.patterns;

public class AbstractFactory {

    public static void main(String[] args) {
        //  в зависимости от контекста выбираем нужную фабрику
        DeviceFactory deviceFactory = new RuDeviceFactory();

    }

}

/**
 * есть абртактные изготавливаемые объекты
 */
interface Mouse {
    void click();

    void dblclick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface TouchPad {
    void track(int x, int y);
}


/**
 * есть группа реализаций сгруппированных по какому то признаку (юзаются в одном контексте)
 */
interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    TouchPad getTouchPad();
}

/**
 * конкретная фабрику группы объектов
 */
class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}

class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Клик");
    }

    @Override
    public void dblclick() {
        System.out.println("Дабл клик");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("Скролим на " + direction);
    }
}

class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.println("Печатаем");
    }

    @Override
    public void println() {
        System.out.println("Перенос строки");
    }
}

class RuTouchPad implements TouchPad {

    @Override
    public void track(int x, int y) {
        System.out.println("Гартаем на " + x + " " + y);
    }
}

