import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Help {

	private BorderPane rootPane;
	private Game game;
	public Help(Game game) {
		this.game = game;
		Button b = new Button("Main Menu");
		b.setOnAction(e -> {
			//Menu m = new Menu(game);
			//game.getScene().setRoot(m);
			Game.getStage().setScene(game.getMenuScene());
		});
		rootPane = new BorderPane();
		Text t = new Text("\n\nHELP");
		t.setFont(new Font(30));
		BorderPane second = new BorderPane();
		Text t2 = new Text("☆\tWelcome to Ball Bounce game. \n\n☆\tThis game consists of three levels. To win the game, you must beat each level"
				+ " in order. \n\n☆\tEach level will require a certain amount of points before moving on. To receive points, make sure to hit any incoming balls "
				+ "toward the ceiling using the ARROW KEYS ONLY. Any balls that hit the ground will lose you 2 points. \n\n☆\tIf you point count goes lower to zero, then you lose, but don't worry you'll start with 25 points in the first level "
				+ "\n\n☆\tEach level will be harder than the last and new items will be added. Green circles will boost the speed of your bar, while red circles will decrease "
				+ "the speed of your bar. Golden balls have a chance of  automatically adding 5 points to your point counter.\n\n☆\tGood luck, and have fun!");
		//double size = game.getScene().getHeight();
		t2.setWrappingWidth(game.getSize());
		second.setCenter(t);
		BorderPane pane = new BorderPane();
		pane.setTop(b);
		pane.setCenter(t);
		rootPane.setCenter(t2);
		rootPane.setTop(pane);
	}
	
	public Pane getRootPane() {
		return rootPane;
	}

}
