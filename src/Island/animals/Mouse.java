package Island.animals;

public class Mouse extends Herbivore{
    @Override
    public void move() {
        Utils.moveToRandomCell(this);
    }

    @Override
    public void eat() {
        System.out.println("Мышь поела траву.");
        resetHunger();
    }

    @Override
    public Animal  reproduce() {
        if (!isDead()) {
            Mouse baby = new Mouse();
            System.out.println("Мышь размножилась.");
            return baby;
        }
        return null;
    }

    @Override
    public String getType() {
        return "Мышь";
    }
}
