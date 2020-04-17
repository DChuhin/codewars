package main.java.patterns;

public class Command {
    public static void main(String[] args) {
        Computer c = new Computer();
        // юзер дергает команды изменяя стейт компа но юзер не знает о компе и не зависит от его реализации
        // если ресивер захотим вдрун поставить не комп, то поменять нужно юудет только используемые команды
        // а не реализацию юзера
        User user = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));
        user.start();
        user.stop();
    }
}

interface ICommand {
    void execute();
}

class Computer {
    void start() {
    }

    void stop() {
    }

    void reset() {
    }
}

class User {
    ICommand start;
    ICommand stop;
    ICommand reset;

    public User(ICommand start, ICommand stop, ICommand reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void start() {
        start.execute();
    }

    public void stop() {
        stop.execute();
    }

    public void reset() {
        reset.execute();
    }
}

abstract class CompCmd implements ICommand {
    Computer computer;

    public CompCmd(Computer computer) {
        this.computer = computer;
    }
}

class StartCommand extends CompCmd {

    public StartCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand extends CompCmd {

    public StopCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand extends CompCmd {

    public ResetCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.reset();
    }
}