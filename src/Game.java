import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
		world.setPrefSize(300,500);
		Ball ball = new Ball(5,5);
		Paddle paddle = new Paddle();
		ball.setFitWidth(100);
		ball.setFitHeight(100);
		paddle.setFitWidth(100);
		paddle.setFitHeight(100);
		paddle.setX(world.getWidth()/2);
		paddle.setY(world.getHeight()/2);
		world.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				paddle.setX(event.getX());
				
			}
			
		});
		world.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				world.addKey(event.getCode());
			}
			
		});
		
		world.setOnKeyReleased(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				world.removeKey(event.getCode());
			}
			
		});
		world.add(ball);
		world.add(paddle);
		
		world.start();
		rootNode.setCenter(world);
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.show();
		world.requestFocus();
		
		
	}

}
