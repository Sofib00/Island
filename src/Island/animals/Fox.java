package Island.animals;

public class Fox extends Carnivore {
    @Override
    public void eat() {
        for (Animal animal : new java.util.ArrayList<>(currentCell.getAnimals())) {
            if (animal instanceof Herbivore && animal != this && !animal.isDead()) {
                animal.die();
                currentCell.removeAnimal(animal);
                System.out.println("Лиса съела " + animal.getType());
                resetHunger();
                return;
            }
        }
        System.out.println("Лиса никого не нашела для еды.");
        incrementHunger();
    }
    @Override
    public void move() {
        Utils.moveToRandomCell(this);
    }

    @Override
    public Animal  reproduce() {
        if (!isDead()) {
            Fox baby = new Fox();
            System.out.println("Лиса размножилась.");
            return baby;
        }
        return null;
    }

    @Override
    public String getType() {
        return "Лиса";
    }
}
