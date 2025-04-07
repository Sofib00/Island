package Island.animals;

public class Duck extends Herbivore{
    @Override
    public void move() {
        Utils.moveToRandomCell(this);
    }

    @Override
    public void eat() {
        System.out.println("Утка поела траву.");
        resetHunger();
    }

    @Override
    public Animal  reproduce() {
        if (!isDead()) {
            Duck baby = new Duck();
            System.out.println("Лиса размножилась.");
            return baby;
        }
        return null;
    }

    @Override
    public String getType() {
        return "Утка";
    }
}
