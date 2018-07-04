public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = Piece.WATER;
            }
        }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        assert isOnGrid(c) : "Off grid";
        Coordinate currC = c;
        boolean possible = true;

        for (int i = 0; i < size; i++) {
             
            if (!isOnGrid(c) || grid[c.getRow()][c.getColumn()] != Piece.WATER) {
                possible = false;
                break;
            }

            if (isDown) {
                currC = new Coordinate(currC.getRow()+1, currC.getColumn());
            } else {
                currC = new Coordinate(currC.getRow(), currC.getColumn()+1);
            }
        }
        return possible;
    }

    public boolean isOnGrid(Coordinate c) {
        // Returns True if the c is on the grid
        return 0 <= c.getRow() && c.getRow() < HEIGHT &&
            0 <= c.getColumn() && c.getColumn() < WIDTH;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        assert canPlace(c, size, isDown) : "Cannot place ship";

        int curRow = c.getRow();
        int curColumn = c.getColumn();

        for (int i = 0; i < size; i++) {

            grid[curRow][curColumn] = Piece.SHIP;

            if (isDown) curRow++;
            else curColumn++;
        }
    }

    public boolean wouldAttackSucceed(Coordinate c) {
        assert isOnGrid(c) : "Not on grid";

        return grid[c.getRow()][c.getColumn()] == Piece.SHIP;
    }

    public void attackCell(Coordinate c) {
        
        if (wouldAttackSucceed(c)) {
            grid[c.getRow()][c.getColumn()] = Piece.DAMAGED_SHIP;
        } else if (grid[c.getRow()][c.getColumn()] == Piece.WATER) {
            grid[c.getRow()][c.getColumn()] = Piece.MISS;
        }
    }

    public boolean areAllSunk() {

        boolean allSunk = true;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == Piece.SHIP) {
                    allSunk = false;
                    break;
                }
            }
        }
        return allSunk;
    }

    public String toPlayerString() {
        Piece[][] copyGrid = Util.deepClone(grid);
        Util.hideShips(copyGrid);
        return renderGrid(copyGrid);
    }

    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
