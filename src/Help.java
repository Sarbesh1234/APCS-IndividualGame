import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Help {

	private BorderPane rootPane;
	private Game game;
	public Help(Game game) {
		this.game = game;
		rootPane = new BorderPane();
		Text t = new Text("\n\nHELP");
		t.setFont(new Font(30));
		BorderPane second = new BorderPane();
		Text t2 = new Text("☆Welcome to ball bounce game. \n\n☆This game consists of three levels. To win the game, you must beat each level"
				+ "in order. \n\n☆Each level will require a certain amount of points before moving on. To receive points, make sure to hit any incoming balls "
				+ "toward the ceiling. Any balls that hit the ground will lose you 2 points. \n\n☆If you point count goes lower to zero, then you lose, but don't worry you'll start with 25 points in the first level "
				+ "\n\n☆Each level will be harder than the last and new items will be added. Green circles will boost the speed of your bar, while red circles will decrease"
				+ "the speed of your bar. Golden balls have a chance of  automatically adding 5 points to your point counter.\n\n☆Good luck, and have fun!");
		double size = game.getScene().getHeight();
		t2.setWrappingWidth(size);
		second.setCenter(t);
		rootPane.setCenter(t2);
		rootPane.setTop(second);
	}
	
	public Pane getRootPane() {
		return rootPane;
	}

}
