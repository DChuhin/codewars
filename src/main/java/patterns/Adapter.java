package main.java.patterns;

public class Adapter {

    public static void main(String[] args) {
        // подгоняем американскую вилку под европейскую обернув в адаптер
        AmericanFork adaptee = () -> System.out.println("connected to socket") ;
        EuFork target = new ToEuForkAdapter(adaptee);
        target.connectIntoEuSocket();
    }

}

interface EuFork {
    void connectIntoEuSocket();
}

interface AmericanFork {
    void connectIntoAmericatSocket();
}

class ToEuForkAdapter implements EuFork {
    private AmericanFork adaptee;

    @Override
    public void connectIntoEuSocket() {

    }

    public ToEuForkAdapter(AmericanFork adaptee) {
        this.adaptee = adaptee;
    }
}