import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Win extends BorderPane {

	public Win() {
		Text t = new Text("GAME OVER");
		setCenter(t);
	}

}
