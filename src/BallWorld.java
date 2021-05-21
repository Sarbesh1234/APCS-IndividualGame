import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class BallWorld extends World {
	public Score score;
	public static Game g;
	public Ball ball;
	public Paddle paddle;
	public BallWorld(Game g) {
		this.g = g;
		score = new Score();
		score.setX(50);
		score.setY(50);
		getChildren().add(score);
		
		ball = new Ball(5,5);
		Ball ball2 = new Ball(5,5);
		paddle = new Paddle();
		ball.setFitWidth(25);
		ball.setFitHeight(25);
		ball2.setFitWidth(25);
		ball2.setFitHeight(25);
		ball2.setY(30);
		//paddle.setFitWidth(20);
		//paddle.setFitHeight(20);
		paddle.setX(250);
		paddle.setY(250);
		Brick brick = new Brick();
		brick.setFitWidth(100);
		brick.setFitHeight(100);
		brick.setX(200);
		brick.setY(200);
		//add(brick);
		add(ball);
		//add(ball2);
		add(paddle);
		/*this.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(paddle.getX() + paddle.getWidth()<getWidth() || paddle.getX()>0) {
					paddle.setX(event.getX());
				}
			}
		});*/
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
		if(score.getScore() == 5) {
			g.getBallWorld().stop();
			g.getLevel2().start();
			g.getBorderPane().setCenter(g.getLevel2());
			g.getLevel2().requestFocus();
		}
	}
	public Score getScore() {
		return score;
	}
	
	
	
}
