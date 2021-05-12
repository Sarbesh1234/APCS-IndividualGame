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
		Ball ball = new Ball(5,5);
		Paddle paddle = new Paddle();
		ball.setFitWidth(25);
		ball.setFitHeight(25);
		//paddle.setFitWidth(20);
		//paddle.setFitHeight(20);
		paddle.setX(250);
		paddle.setY(250);
		Brick brick = new Brick();
		brick.setFitWidth(100);
		brick.setFitHeight(100);
		brick.setX(200);
		brick.setY(200);
		rootNode.setOnMouseMoved(new EventHandler<MouseEvent>() {
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
		world.add(brick);
		world.add(ball);
		world.add(paddle);
		world.start();
		rootNode.setCenter(world);
		Scene scene = new Scene(rootNode,500,500);
		stage.setScene(scene);
		stage.show();
		world.requestFocus();
		
		
	}

}
