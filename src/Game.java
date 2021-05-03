import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {

	public Game() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ball");
		BorderPane rootNode = new BorderPane();
		BallWorld gu = new BallWorld();
		rootNode.setCenter(gu);
		Scene lsci = new Scene(rootNode);
		Ball bum = new Ball(1,1);
		gu.add(bum);
		start(stage);
	}

}
