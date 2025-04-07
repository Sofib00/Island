package Island.animals;

public class Rabbit extends Herbivore {
    @Override
    public void move() {
        Utils.moveToRandomCell(this);
    }

    @Override
    public void eat() {
        System.out.println("Кролик поел траву.");
        resetHunger();
    }

    @Override
    public Animal  reproduce() {
        if (!isDead()) {
            Rabbit baby = new Rabbit();
            System.out.println("Кролик размножился.");
            return baby;
        }
        return null;
    }

    @Override
    public String getType() {
        return "Кролик";
    }
}
