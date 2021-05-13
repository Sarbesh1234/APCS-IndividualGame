import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class BallWorld extends World {
	public Score score;
	public BallWorld() {
		score = new Score();
		score.setX(50);
		score.setY(50);
		getChildren().add(score);
		
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
		add(brick);
		add(ball);
		add(paddle);
		this.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				paddle.setX(event.getX());	
			}
		});
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				addKey(event.getCode());
			}
		});
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				removeKey(event.getCode());
			}
		});
	}
	@Override
	public void act(long now) {
	}
	public Score getScore() {
		return score;
	}
}
