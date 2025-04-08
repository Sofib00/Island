package Island.animals;

import Island.map.Cell;

public abstract class Animal {
    protected boolean dead = false;
    protected Cell currentCell;
    protected int daysWithoutFood = 0;

    public void incrementHunger() {
        daysWithoutFood++;
        if (daysWithoutFood >= 2) {
            die();
            System.out.println(getType() + " умер от голода.");
        }
    }

    public void resetHunger() {
        daysWithoutFood = 0;
    }

    public abstract void move();
    public abstract void eat();
    public abstract Animal reproduce();
    public abstract String getType();

    public boolean isDead() {
        return dead;
    }

    public void die() {
        dead = true;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
    }
}