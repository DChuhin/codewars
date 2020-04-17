package main.java.patterns;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FactoryMethod {

    public static void main(String[] args){
        // меняя фабрику тут меняем используемую реализацию мапы везде
        MapFactory factory = new TreeMapFactory(); //new HashMapFactory();
        Map<String, Object> map = factory.getMap();
    }
}

interface MapFactory {
    <K, V> Map<K, V> getMap();
}

class HashMapFactory implements MapFactory {
    @Override
    public <K, V> Map<K, V> getMap() {
        return new HashMap<>();
    }
}

class TreeMapFactory implements MapFactory {
    @Override
    public <K, V> Map<K, V> getMap() {
        return new TreeMap<>(Comparator.comparing(K::toString));
    }
}
