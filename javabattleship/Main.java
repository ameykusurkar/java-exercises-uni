import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grid grid = makeInitialGrid();
        int count = 0;

        do {

            System.out.println('\n' + grid.toPlayerString() + '\n');

            String token = getInput(input, grid);

            Coordinate cell = Util.parseCoordinate(token);
            boolean hit = grid.wouldAttackSucceed(cell);
            grid.attackCell(cell);

            if (hit) {
                System.out.println("A direct hit!");
            }

            count++;

        } while (!grid.areAllSunk());

        System.out.println("You win!");
        System.out.println("You took " + count + " attempts!");
        System.out.println('\n' + grid.toPlayerString() + '\n');
    }

    private static String getInput(Scanner sc, Grid grid) {

        String token;

            do {

                System.out.println("Please enter cell to attack:");
                token = sc.next();

            } while (!isValidInput(token, grid));

        return token;
    }

    private static boolean isValidInput(String token, Grid grid) {
        if (token.length() != 2) return false;

        char letter = token.charAt(0);
        char number = token.charAt(1);

        if (!(65 <= letter && letter <= 90)) return false;
        if (!(48 <= number && number <= 57)) return false;

        return grid.isOnGrid(Util.parseCoordinate(token));
    }

    private static Grid makeInitialGrid() {
        Grid grid = new Grid();

        String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
        int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
        boolean[] isDowns = { false, true, true, false, false, true, false };

        for (int i = 0; i < coords.length; i++) {
            Coordinate c = Util.parseCoordinate(coords[i]);
            grid.placeShip(c, sizes[i], isDowns[i]);
        }

        return grid;
    }
}
