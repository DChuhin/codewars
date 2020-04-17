package main.java.patterns;

/**
 * Сохраняем состояние в объекте, который отдаем на сохранение опекуну (здесь это файл сохранки)
 * потом взяв у опекуна состояние, возвращаем исходный объект в сохраненное состояние
 */
public class Memento {
    public static void main(String[] args) {
        Game game = new Game();
        game.set(1, 300000);

        SaveFile file = new SaveFile();
        file.setSave(game.save());
        game.set(0, 0);
        game.load(file.getSave());
    }
}


class Game {
    int level;
    int ms;
    void set(int level, int ms) {
        this.level = level;
        this.ms = ms;
    }
    void load(Save save) {
        this.level = save.getLevel();
        this.ms = save.getMs();
    }
    Save save() {
        return new Save(level, ms);
    }
}

class Save {
    int level;
    int ms;

    public Save(int level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public int getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}

class SaveFile {
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}