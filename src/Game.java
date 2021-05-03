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
		BallWorld world = new BallWorld();
		Ball ball = new Ball(5,5);
		ball.setFitWidth(100);
		ball.setFitHeight(100);
		world.add(ball);
		world.setPrefSize(300,500);
		world.start();
		rootNode.setCenter(world);
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.show();
		
		
	}

}
