package Island.animals;

public abstract class Carnivore extends Animal {
    @Override
    public void eat() {
        System.out.println(getType() + " поел мясо.");
        // Хищники могут кушать других животных, но не себя
    }
}
