package Island.animals;

public class Wolf extends Carnivore {
    @Override
    public void eat() {
        for (Animal animal : new java.util.ArrayList<>(currentCell.getAnimals())) {
            if (animal instanceof Herbivore && animal != this && !animal.isDead()) {
                animal.die();
                currentCell.removeAnimal(animal);
                System.out.println("Волк съел " + animal.getType());
                resetHunger();
                return;
            }
        }
        System.out.println("Волк никого не нашел для еды.");
        incrementHunger();
    }
    @Override
    public void move() {
        Utils.moveToRandomCell(this);
    }

    @Override
    public Animal  reproduce() {
        if (!isDead()) {
            Wolf baby = new Wolf();
            System.out.println("Волк размножился.");
            return baby;
        }
        return null;
    }

    @Override
    public String getType() {
        return "Волк";
    }
}
