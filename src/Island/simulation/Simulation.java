package Island.simulation;

import Island.map.IslandMap;
import Island.map.Cell;
import Island.animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    private final IslandMap map;
    private final List<Animal> animals = new ArrayList<>();
    private final Random random = new Random();

    public Simulation(int width, int height) {
        this.map = new IslandMap(width, height);
        initializeAnimals();
    }

    private void initializeAnimals() {
        // Хищники
        animals.add(new Fox());
        animals.add(new Bear());
        animals.add(new Wolf());

        // Травоядные
        animals.add(new Rabbit());
        animals.add(new Mouse());
        animals.add(new Duck());

        for (Animal animal : animals) {
            int x = random.nextInt(map.getWidth());
            int y = random.nextInt(map.getHeight());
            Cell cell = map.getCell(x, y);
            cell.addAnimal(animal);
            animal.setCurrentCell(cell);
        }
    }

    public void run() {
        for (int day = 1; day <= 10; day++) {
            System.out.println("\nДень " + day);

            for (Animal animal : new ArrayList<>(animals)) {
                if (!animal.isDead()) {
                    randomAction(animal);
                }
            }

            removeDeadAnimals();

            printAliveAnimals();

            if (animals.size() <= 1) {
                System.out.println("\n💀 Симуляция завершена: осталось не больше одного животного!");
                printSurvivors();
                break;
            }
        }
    }

    private void randomAction(Animal animal) {
        int action = random.nextInt(3);
        switch (action) {
            case 0:
                animal.move();
                break;
            case 1:
                animal.eat();
                break;
            case 2:
                Animal baby = animal.reproduce();
                if (baby != null) {
                    baby.setCurrentCell(animal.getCurrentCell());
                    animal.getCurrentCell().addAnimal(baby);
                }
                break;
        }
    }

    private void removeDeadAnimals() {
        animals.removeIf(Animal::isDead);
    }

    private void printAliveAnimals() {
        System.out.println("Живые животные:");
        for (Animal animal : animals) {
            if (!animal.isDead()) {
                System.out.println(animal.getType() + " находится в клетке (" + animal.getCurrentCell().getX() + ", " + animal.getCurrentCell().getY() + ")");
            }
        }
    }

    private void printSurvivors() {
        System.out.println("Выжившие:");
        for (Animal animal : animals) {
            System.out.println("🔹 " + animal.getType());
        }
    }
}