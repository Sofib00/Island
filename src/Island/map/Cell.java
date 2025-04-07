package Island.map;

import Island.animals.Animal;
import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Animal> animals = new ArrayList<>();
    private final int x;
    private final int y;
    private final IslandMap map;

    public Cell(int x, int y, IslandMap map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setCurrentCell(this);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public IslandMap getMap() {
        return map;
    }
}
