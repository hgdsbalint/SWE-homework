import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.util.Optional;
import java.util.stream.Stream;

public class GameController {

    /*@FXML

    private GridPane board;

    @FXML
    private TextField moveNumber;
    private ChessState state;
    @FXML
    public void initialize() {
        state = new ChessState();
        loadImages();
    }
    public void loadImages(){
    Image wBishopImage = new Image(getClass().getResourceAsStream("/images/w-bishop.png"));
    Image bBishopImage = new Image(getClass().getResourceAsStream("images/bishop.png"));
    Image wRookImage = new Image(getClass().getResourceAsStream("images/w-rook.png"));
    Image bRookImage = new Image(getClass().getResourceAsStream("/images/rook.png"));
    Image kingImage = new Image(getClass().getResourceAsStream("/images/king.png"));

    ImageView wBishop = new ImageView(wBishopImage);
    ImageView bBishop = new ImageView(bBishopImage);
    ImageView wRook = new ImageView(wRookImage);
    ImageView bRook = new ImageView(bRookImage);
    ImageView kingView = new ImageView(kingImage);

    board.add(kingView, 0, 0); // 0,0 helyen a király
    board.add(wBishop, 0, 1); // 0,1 helyen a fehér futó
    board.add(bBishop, 0, 2); // 0,2 helyen a fekete futó
    board.add(wRook, 1, 0); // 1,0 helyen a fehér bástya
    board.add(bRook, 1, 1); // 1,1 helyen a fekete bástya
    }*/

    @FXML
    private GridPane board;

    private ChessState chessState;

    private ImageView kingView;
    private ImageView wBishop;
    private ImageView bBishop;
    private ImageView wRook;
    private ImageView bRook;

    public void initialize() {
        chessState = new ChessState();
        initializeImageViews();
        showPiecesOnBoard();
    }

    private void initializeImageViews() {
        kingView = new ImageView(new Image("/images/king.png"));
        wBishop = new ImageView(new Image("/images/w_bishop.png"));
        bBishop = new ImageView(new Image("/images/b_bishop.png"));
        wRook = new ImageView(new Image("/images/w_rook.png"));
        bRook = new ImageView(new Image("/images/b_rook.png"));
    }

    private void showPiecesOnBoard() {
        board.add(kingView, chessState.positions[ChessState.KING].getCol(), chessState.positions[ChessState.KING].getRow());
        board.add(wBishop, chessState.positions[ChessState.BISHOP].getCol(), chessState.positions[ChessState.BISHOP].getRow());
        board.add(bBishop, chessState.positions[ChessState.BISHOP1].getCol(), chessState.positions[ChessState.BISHOP1].getRow());
        board.add(wRook, chessState.positions[ChessState.ROCK].getCol(), chessState.positions[ChessState.ROCK].getRow());
        board.add(bRook, chessState.positions[ChessState.ROCK1].getCol(), chessState.positions[ChessState.ROCK1].getRow());
    }

    @FXML
    private void movePiece(int row, int col, Direction direction) {
        // Implementáld a bábú mozgatását
        int piece = 0; // Határozd meg a bábút, amelyiket mozgatni szeretnéd
        if (chessState.canMove(piece, direction)) {
            chessState.move(piece, direction);
            showPiecesOnBoard();
        }
    }
    private ImageView getImageViewAtPosition(Position position) {
        for (ImageView imageView : new ImageView[]{kingView, wBishop, bBishop, wRook, bRook}) {
            if (board.getColumnIndex(imageView) == position.getCol() && board.getRowIndex(imageView) == position.getRow()) {
                return imageView;
            }
        }
        return null;
    }

    private ImageView getImageViewForPiece(int piece) {
        switch (piece) {
            case ChessState.KING:
                return kingView;
            case ChessState.BISHOP:
                return wBishop;
            case ChessState.BISHOP1:
                return bBishop;
            case ChessState.ROCK:
                return wRook;
            case ChessState.ROCK1:
                return bRook;
            default:
                return null;
        }
    }
}
