public enum Direction {
    Up(-1,0),
    Down(1,0),
    Left(0,-1),
    Right(0,1),
    DiagonalLeftUp(-1,-1),
    DiagonalLeftDown(1,-1),
    DiagonalRightDown(1,1),
    DiagonalRightUp(-1,1);

    private final int rowChange;
    private final int colChange;

    Direction(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    public int getRowChange() {
        return rowChange;
    }

    public int getColChange() {
        return colChange;
    }
}
