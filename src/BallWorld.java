import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class BallWorld extends World {
	public Score score;
	public static Game g;
	public Ball ball;
	public Paddle paddle;
	public Text2 txt;
	public BallWorld(Game g) {
		this.g = g;
		score = new Score();
		score.setNum(50);
		score.setX(50);
		score.setY(50);
		txt = new Text2("Level 1", 30);
		txt.setX(50);
		txt.setY(100);
		score.setScore(26);
		getChildren().add(score);
		getChildren().add(txt);
		
		ball = new Ball(5,5);
		Ball ball2 = new Ball(5,5);
		paddle = new Paddle();
		ball.setFitWidth(25);
		ball.setFitHeight(25);
		//int rand = (int) ((int) (Math.random() * getWidth())+ball.getWidth());
		//System.out.println(this.getWidth());
		//System.out.println(ball.getWidth());
		//System.out.println(rand);
		int r2 =  (int) (Math.random() * (g.returnSize()-ball.getWidth()));
		//System.out.println(g.returnSize());
		//System.out.println(ball.getWidth());
		//System.out.println(r2);
		ball.setX(r2);
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
		if(score.getScore() >= 50) {
			g.getBallWorld().stop();
			g.getLevel2().start();
			g.getBorderPane().setCenter(g.getLevel2());
			g.getLevel2().requestFocus();
		}
		if(score.getScore() <= 0) {
			g.getBallWorld().stop();
			g.getBorderPane().setCenter(g.getGameOver());
		}
	}
	public Score getScore() {
		return score;
	}
	
	
	
}
