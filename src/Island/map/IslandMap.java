package Island.map;

public class IslandMap {
    private final Cell[][] cells;

    public IslandMap(int width, int height) {
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(x, y, this);
            }
        }
    }

    public Cell getCell(int x, int y) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            return cells[x][y];
        }
        return null;
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }
}