package main.java.patterns;

public class Facade {

    public static void main(String[] args) {
        CupOfTea cupOfTea = TeaFacade.makeMeTea(TeaFacade.TeaType.BLACK, 2);
    }
}

/**
 * управление сложной системой простым способом
 */
class TeaFacade {
    enum TeaType { BLACK, GREEN, RED }

    static CupOfTea makeMeTea(TeaType teaType, int sugar) {
        Water water = WaterBaloon.getWater();
        Kettle kettle = new Kettle();
        kettle.makeHotWater(water);
        CupOfTea cup = new CupOfTea();
        cup.putTea(teaType);
        cup.putWater(water);
        for (int i = 0; i < sugar; i++) {
            cup.addSugar();
        }
        return cup;
    }
}

class Kettle {
    void makeHotWater(Water water) {
        water.temp = 100;
    }
}

class WaterBaloon {
    static Water getWater() {
        return new Water();
    }
}

class Water {
    int temp = 20;
}

class CupOfTea {
    Water water;
    TeaFacade.TeaType tea;
    int sugar;

    void putTea(TeaFacade.TeaType tea) { this.tea = tea; }

    void putWater(Water water) {
        this.water = water;
    }

    void addSugar(){
        sugar++;
    }

}
