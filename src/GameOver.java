import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class GameOver extends BorderPane {

	public GameOver() {
		Text t = new Text("GAME OVER");
		setCenter(t);
	}

}
