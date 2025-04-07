package Island.animals;

public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        System.out.println(getType() + " поел травы.");
    }
}
