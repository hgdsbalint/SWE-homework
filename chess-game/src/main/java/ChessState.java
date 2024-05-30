import java.util.Arrays;
import java.util.Objects;

public class ChessState {
    public static final int BOARD_ROW = 2;
    public static final int BOARD_COL = 3;
    public static final int KING = 0;
    public static final int BISHOP = 1;
    public static final int BISHOP1 = 2;
    public static final int ROCK = 3;
    public static final int ROCK1 = 4;
    private Position positions[];

    public ChessState(){
        positions = new Position[]{
                new Position(0, 0), //King position
                new Position(0, 1), //Bishop position
                new Position(0, 2), //Bishop1 position
                new Position(1, 0), //Rock position
                new Position(1, 1) //Rock1 position
        };
    }

    public boolean isGoal(){
        //Checking that the pieces is in the winning positions
        if(positions[KING].equals(new Position(1,2))
                && positions[BISHOP].equals(new Position(0,1))
                && positions[BISHOP1].equals(new Position(0,0))
                && ( positions[ROCK].equals(new Position(1,0))
                || positions[ROCK].equals(new Position(1,1)))
                && (positions[ROCK1].equals(new Position(1,1))
                || positions[ROCK1].equals(new Position(1,0)))){
            return true;
        }
        return false;
    }

    public boolean isEmpty(Position position){
        for(Position p:positions){
           if(Objects.equals(p,positions)){
               return false;
           }
        }
        return true;
    }
    public boolean canMove(Direction direction) {
        return switch (direction) {
            case Up -> canMoveUp();
            case Right -> canMoveRight();
            case Down -> canMoveDown();
            case Left -> canMoveLeft();
            case DiagonalLeftDown -> canMoveDiagonalLeftDown();
            case DiagonalLeftUp -> canMoveDiagonalLeftUp();
            case DiagonalRightUp -> canMoveDiagonalRightUp();
            case DiagonalRightDown -> canMoveDiagonalRightDown();
        };
    }
    public boolean canMoveUp(){
        if(positions[KING].getRow() > 0 && isEmpty(positions[KING].getUp())){
            return true;
        }
        else if(positions[ROCK].getRow() > 0 && isEmpty(positions[ROCK].getUp())){
            return true;
        }
        else if(positions[ROCK1].getRow() > 0 && isEmpty(positions[ROCK1].getUp())){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean canMoveRight(){
        if(positions[KING].getCol() > BOARD_COL-1 && isEmpty(positions[KING].getRight())){
            return true;
        }
        else if(positions[ROCK].getCol() > BOARD_COL-1 && isEmpty(positions[ROCK].getRight())){
            return true;
        }
        else if(positions[ROCK1].getCol() > BOARD_COL-1 && isEmpty(positions[ROCK1].getRight())){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean canMoveDown(){
       if(positions[KING].getRow() > BOARD_ROW-1 && isEmpty(positions[KING].getDown())){
           return true;
       }
       else if(positions[ROCK].getRow() > BOARD_ROW-1 && isEmpty(positions[ROCK].getDown())){
           return true;
       }
       else if(positions[ROCK1].getRow() > BOARD_ROW-1 && isEmpty(positions[ROCK1].getDown())){
           return true;
       }
       else{
           return false;
       }
   }
    public boolean canMoveLeft(){
        if(positions[KING].getCol() > 0 && isEmpty(positions[KING].getLeft())){
            return true;
        }
        else if(positions[ROCK].getCol() > 0 && isEmpty(positions[ROCK].getLeft())){
            return true;
        }
        else if(positions[ROCK1].getCol() > 0 && isEmpty(positions[ROCK1].getLeft())){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean canMoveDiagonalLeftDown(){
        if(positions[BISHOP].getRow() > BOARD_ROW-1
                && positions[BISHOP].getCol() > 0
                && isEmpty(positions[BISHOP].getDiagonalLeftDown())){
            return true;
        }
        else if(positions[BISHOP1].getRow() > BOARD_ROW-1
                && positions[BISHOP1].getCol() > 0
                && isEmpty(positions[BISHOP1].getDiagonalLeftDown())){
            return true;
        }
        return false;
    }
    public boolean canMoveDiagonalLeftUp(){
        if(positions[BISHOP].getRow() > 0
                && positions[BISHOP].getCol() > 0
                && isEmpty(positions[BISHOP].getDiagonalLeftUp())){
            return true;
        }
        else if(positions[BISHOP1].getRow() > 0
                && positions[BISHOP1].getCol() > 0
                && isEmpty(positions[BISHOP1].getDiagonalLeftUp())){
            return true;
        }
        return false;
    }
    public boolean canMoveDiagonalRightUp(){
        if(positions[BISHOP].getRow() > 0
                && positions[BISHOP].getCol() > BOARD_COL-1
                && isEmpty(positions[BISHOP].getDiagonalRightUp())){
            return true;
        }
        else if(positions[BISHOP1].getRow() > 0
                && positions[BISHOP1].getCol() > BOARD_COL-1
                && isEmpty(positions[BISHOP1].getDiagonalRightUp())){
            return true;
        }
        return false;
    }
    public boolean canMoveDiagonalRightDown(){
        if(positions[BISHOP].getRow() > BOARD_ROW-1
                && positions[BISHOP].getCol() > BOARD_COL-1
                && isEmpty(positions[BISHOP].getDiagonalRightDown())){
            return true;
        }
        else if(positions[BISHOP1].getRow() > BOARD_ROW-1
                && positions[BISHOP1].getCol() > BOARD_COL -1
                && isEmpty(positions[BISHOP1].getDiagonalRightDown())){
            return true;
        }
        return false;
    }

    public void move(Direction direction) {
        switch (direction) {
            case Up -> moveUp();
            case Right -> moveRight();
            case Down -> moveDown();
            case Left -> moveLeft();
            case DiagonalLeftDown -> moveDiagonalLeftDown();
            case DiagonalLeftUp -> moveDiagonalLeftUp();
            case DiagonalRightUp -> moveDiagonalRightUp();
            case DiagonalRightDown -> moveDiagonalRightDown();
        };
    }
    private void moveUp(){
        positions[KING].setUp();
    }
    private void moveRight(){
        positions[KING].setRight();
    }
    private void moveDown(){
        positions[KING].setDown();
    }
    private void moveLeft(){
        positions[KING].setLeft();
    }
    private void moveDiagonalLeftDown(){
        positions[KING].setDiagonalLeftDown();
    }
    private void moveDiagonalLeftUp(){
        positions[KING].getDiagonalLeftUp();
    }
    private void moveDiagonalRightUp(){
        positions[KING].getDiagonalRightUp();
    }
    private void moveDiagonalRightDown(){
        positions[KING].getDiagonalRightDown();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessState that = (ChessState) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(positions);
    }

    @Override
    public String toString() {
        var sj = new StringBuilder();
        for (var position : positions) {
            sj.append(position.toString());
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        var state = new ChessState();
        System.out.println(state);
    }
}
