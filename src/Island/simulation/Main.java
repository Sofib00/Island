package Island.simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(5, 5); // размер карты 10x10
        simulation.run(); // запуск симуляции
    }
}