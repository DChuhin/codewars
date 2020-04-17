package main.java.patterns;

/**
 * Есть цепочка обработчиков месаги, каждый держит ссылку на следуцющий, если не может обработать сам, отдает следующему
 */
public class ChainOfResponsibility {

    //TODO клевый пример есть с банкоматом, какие купюры выдавать
    public static void main(String[] args) {
        ConsoleLogger console = new ConsoleLogger(Level.DEBUG);
        FileLogger file = new FileLogger(Level.INFO);
        SMSLogger sms = new SMSLogger(Level.ERROR);
        sms.setNext(file);
        file.setNext(console);
        sms.log("AAAAAAA", Level.ERROR);
        sms.log("все норм", Level.INFO);
        sms.log("я есть", Level.DEBUG);
        file.log("а меня нет", Level.DEBUG);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int WARN = 2;
    public static final int INFO = 3;
    public static final int DEBUG = 4;
}

interface Logger {
    void log(String message, int level);
}

abstract class AbstractChainLogger implements Logger {
    int prior;
    Logger next;

    public AbstractChainLogger(int prior) {
        this.prior = prior;
    }

    public void log(String message, int level) {
        if (level <= prior) {
            printPrefix(message);
        }
        if (next != null) {
            next.log(message, level);
        }
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    abstract void printPrefix(String message);
}

class SMSLogger extends AbstractChainLogger {

    public SMSLogger(int prior) {
        super(prior);
    }

    @Override
    void printPrefix(String message) {
        System.out.println("Send SMS " + message);
    }
}

class ConsoleLogger extends AbstractChainLogger {

    public ConsoleLogger(int prior) {
        super(prior);
    }

    @Override
    void printPrefix(String message) {
        System.out.println("Write to console " + message);
    }
}

class FileLogger extends AbstractChainLogger {

    public FileLogger(int prior) {
        super(prior);
    }

    @Override
    void printPrefix(String message) {
        System.out.println("Write to log file " + message);
    }
}
