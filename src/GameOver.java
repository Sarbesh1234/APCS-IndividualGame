import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class GameOver extends BorderPane {

	private Game game;
	public GameOver(Game game) {
		this.game = game;
		Text t = new Text("GAME OVER");
		setCenter(t);
		Button b = new Button("Main Menu");
		setRight(b);
		b.setOnAction(e -> {
			//game.resetBorderPane();
			//Menu m = new Menu(game);
			//game.resetBorderPane();
			//game.getBorderPane().setCenter(m);
			//game.getScene().setRoot(m);
			Game.getStage().setScene(game.getMenuScene());
		});
	}
	

}
