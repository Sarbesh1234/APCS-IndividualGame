
public class Level2 extends BallWorld {

	public static Game g;
	public Level2() {
		super(g);
		Ball ball = new Ball(5,5);
		ball.setFitWidth(25);
		ball.setFitHeight(25);
		ball.setY(30);
		add(ball);
	}
	
	public void act(long now) {
		
	}
	
	

}
