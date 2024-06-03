import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.util.Optional;
import java.util.stream.Stream;

public class GameController {

    @FXML

    private GridPane board;

    @FXML
    private TextField moveNumber;
    private ChessState state;
    @FXML
    public void initialize() {
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
    }
}
