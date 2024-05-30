public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Position getUp(){
        return new Position(row-1 , col);
    }
    public Position getDown(){
        return new Position(row+1, col);
    }
    public Position getLeft(){
        return new Position(row, col-1);
    }
    public Position getRight(){
        return new Position(row, col+1);
    }
    public Position getDiagonalLeftUp(){
        return new Position(row -1, col -1);
    }
    public Position getDiagonalLeftDown(){
        return new Position(row +1, col -1);
    }
    public Position getDiagonalRightUp(){
        return new Position(row -1, col +1);
    }
    public Position getDiagonalRightDown(){
        return new Position(row +1, col +1);
    }

    public void setTo(Direction direction) {
        row += direction.getRowChange();
        col += direction.getColChange();
    }

    public void setUp() {
        setTo(Direction.Up);
    }

    public void setRight() {
        setTo(Direction.Right);
    }

    public void setDown() {
        setTo(Direction.Down);
    }

    public void setLeft() {
        setTo(Direction.Left);
    }
    public void setDiagonalLeftUp(){
        setTo(Direction.DiagonalLeftUp);
    }
    public void setDiagonalLeftDown(){
        setTo(Direction.DiagonalLeftDown);
    }
    public void setDiagonalRightUp() {
        setTo(Direction.DiagonalRightUp);
    }
    public void setDiagonalRightDown(){
        setTo(Direction.DiagonalRightDown);
    }
}
