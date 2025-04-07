package Island.animals;

public class Bear extends Carnivore{
    @Override
    public void eat() {
        for (Animal animal : new java.util.ArrayList<>(currentCell.getAnimals())) {
            if (animal instanceof Herbivore && animal != this && !animal.isDead()) {
                animal.die();
                currentCell.removeAnimal(animal);
                System.out.println("Медведь съел " + animal.getType());
                resetHunger();
                return;
            }
        }
        System.out.println("Медведь никого не нашел для еды.");
        incrementHunger();
    }
    @Override
    public void move() {
        Utils.moveToRandomCell(this);
    }

    @Override
    public Animal  reproduce() {
        if (!isDead()) {
            Bear baby = new Bear();
            System.out.println("Медведь размножился.");
            return baby;
        }
        return null;
    }

    @Override
    public String getType() {
        return "Медведь";
    }
}
