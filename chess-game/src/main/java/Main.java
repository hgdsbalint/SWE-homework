import java.util.Scanner;

public class Main extends ChessState{
    public static void main(String[] args) {
        ChessState chessState = new ChessState();
        Scanner scanner = new Scanner(System.in);
        String piece;
        String direction;
        while(true){
            piece = scanner.next();
            direction = scanner.next();
            if(chessState.canMove(direction, piece));
        }
    }
}
