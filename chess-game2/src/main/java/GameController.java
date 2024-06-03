import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.stream.Stream;

public class GameController {

    @FXML

    private GridPane board;

    @FXML
    private TextField moveNumber;
    private BooleanProperty gameOver = new SimpleBooleanProperty();
    private IntegerProperty numberMove = new SimpleIntegerProperty();

    private ImageView[] pieceViews;
    private ChessState state;
    private void resetGame() {
        state = new ChessState();
        numberMove.set(0);
        gameOver.set(state.isGoal());
    }


    private void loadImages() {
        pieceViews = Stream.of("bishop.png", "game.png", "king.png", "rook.png","w-bishop.png")
                .map(s -> "/images/" + s)
                .map(s -> {
                    var image = new Image(s);
                    return new ImageView(image);
                })
                .toArray(ImageView[]::new);
    }
}
