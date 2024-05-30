import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PuzzleState {
    public static final int BOARD_SIZE = 3;
    public static final int BLOCK = 0;
    public static final int RED_SHOE = 1;
    public static final int BLUE_SHOE = 2;
    public static final int BLACK_SHOE = 3;

    private Position[] positions;

    public PuzzleState() {
        positions = new Position[]{
                new Position(0,0), //square
                new Position(2,0), //red
                new Position(1,1), //blue
                new Position(0,2)  //black
        };
    }

    public boolean isGoal(){
        //return positions[RED_SHOE].equals(positions[BLACK_SHOE]);
        return Objects.equals(positions[RED_SHOE], positions[BLUE_SHOE]);
    }

    public boolean isEmpty(Position position){
        /*return !Objects.equals(positions[BLACK_SHOE], position) &&
                !Objects.equals(positions[BLUE_SHOE], position) &&
                !Objects.equals(positions[RED_SHOE], position) &&
                !Objects.equals(positions[BLOCK], position);
        */

        for(Position p: positions){
            if(Objects.equals(position, p)){
                return false;
            }
        }

        return true;
    }
    public boolean canMoveUp(){
        /*return positions[BLOCK].getRow() > 0 && isEmpty(
                new Position(positions[BLOCK].getRow()-1,
                                positions[BLOCK].getCol())
        );*/
        return positions[BLOCK].getRow() > 0 && isEmpty(positions[BLOCK].getUp());
    }
    public boolean canMoveLeft(){
        return positions[BLOCK].getCol() > 0 && isEmpty(positions[BLOCK].getLeft());
    }
     public boolean canMoveRight(){
        if(positions[BLOCK].getCol() == BOARD_SIZE-1){
            return false;
        }

        Position right = positions[BLOCK].getRight();

        return isEmpty(right) || (Objects.equals(right, positions[BLACK_SHOE]) &&
                !Objects.equals(positions[BLOCK], positions[BLUE_SHOE]));
     }

     public boolean canMoveDown(){
        if(positions[BLOCK].getRow() == BOARD_SIZE-1){
            return false;
        }
        Position down = positions[BLOCK].getDown();
        if(isEmpty(down)){
            return true;
        }
        if(Objects.equals(down, positions[BLACK_SHOE])){
            return false; //feketébe nem lehet bemenni
        }
        //nem üres
         if(Objects.equals(positions[BLOCK], positions[BLACK_SHOE])){
             return false; // fekete patkoval nem lehet mozdulni
         }

         if(Objects.equals(positions[BLOCK], positions[RED_SHOE])
         && Objects.equals(down, positions[BLUE_SHOE])){
             return true; // pirosban vagyok ésk kék van alattam
         }
         return false;
     }
    public boolean canMove(Direction direction){
        return switch (direction){
            case Up -> canMoveUp();
            case Down -> canMoveDown();
            case Right -> canMoveRight();
            case Left -> canMoveLeft();
        };
    }
     public void movePieces(Direction direction, int... indices){
        for (int index:indices){
            positions[index] = positions[index].toDierction(direction);
        }
     }
     public void moveUp() {
         if (Objects.equals(positions[BLOCK], positions[BLACK_SHOE])) {
             movePieces(Direction.Up, BLACK_SHOE);
             if(Objects.equals(positions[BLOCK], positions[RED_SHOE])){
                 movePieces(Direction.Up,RED_SHOE);
             }
         }
         movePieces(Direction.Up,BLOCK);
     }
     public void moveRight(){
        for(int shoe: List.of(1,2,3)){
            if(Objects.equals(positions[BLOCK], positions[shoe])){
                movePieces(Direction.Right,shoe);
            }
        }
        movePieces(Direction.Right,BLOCK);
     }
    public void moveLeft(){
        for(int shoe: List.of(1,2,3)){
            if(Objects.equals(positions[BLOCK], positions[shoe])){
                movePieces(Direction.Left,shoe);
            }
        }
        movePieces(Direction.Left,BLOCK);
    }
    public void moveDown(){
        for(int shoe: List.of(1,2,3)){
            if(Objects.equals(positions[BLOCK], positions[shoe])){
                movePieces(Direction.Down,shoe);
            }
        }
        movePieces(Direction.Down,BLOCK);
    }

    public void move(Direction direction){
        switch (direction){
            case Up -> moveUp();
            case Right -> moveRight();
            case Down -> moveDown();
            case Left -> moveLeft();
        }
    }

    public Set<Direction> getLegalMoves(){
        var moves = EnumSet.noneOf(Direction.class);
        for(var direction: Direction.values()){
            if(canMove(direction)){
                moves.add(direction);
            }
        }
        return moves;
    }
}
