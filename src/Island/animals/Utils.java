package Island.animals;

import Island.map.Cell;

public class Utils {
    public static void moveToRandomCell(Animal animal) {
        Cell currentCell = animal.getCurrentCell();
        int currentX = currentCell.getX();
        int currentY = currentCell.getY();

        int dx = (int)(Math.random() * 3) - 1;
        int dy = (int)(Math.random() * 3) - 1;

        int newX = Math.max(0, Math.min(currentX + dx, currentCell.getMap().getWidth() - 1));
        int newY = Math.max(0, Math.min(currentY + dy, currentCell.getMap().getHeight() - 1));

        Cell newCell = currentCell.getMap().getCell(newX, newY);

        currentCell.removeAnimal(animal);
        newCell.addAnimal(animal);
        animal.setCurrentCell(newCell);

        System.out.println(animal.getType() + " переместился в (" + newX + ", " + newY + ")");
    }
}