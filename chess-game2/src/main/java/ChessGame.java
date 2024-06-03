import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        ChessState state = new ChessState();
        Scanner scanner = new Scanner(System.in);
        while (!state.isGoal()) {
            state.printBoard();
            System.out.println("Enter the piece (0 = King, 1 = Bishop1, 2 = Bishop2, 3 = Rock1, 4 = Rock2):");
            int piece = scanner.nextInt();
            System.out.println("Enter the direction (Up, Down, Left, Right, DiagonalLeftUp, DiagonalRightUp, DiagonalLeftDown, DiagonalRightDown):");
            String directionInput = scanner.next();
            try{
                Direction direction = Direction.valueOf(directionInput);
                if (state.canMove(piece, direction)) {
                    state.move(piece, direction);
                    System.out.println("Move successful!");
                } else {
                    System.out.println("Invalid move! try again.");
                }
            }catch (IllegalArgumentException e){
               System.out.println("Invalid direction! Try again");
            }

        }
        System.out.println("You win!");
    }
}

