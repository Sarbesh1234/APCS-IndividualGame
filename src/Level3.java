
public class Level3 extends Level2 {


	Ball ball3;
	public Level3() {
		super();
		ball.changeMove(7,7);
		ball2.changeMove(7, 7);
		ball3 = new Ball(7,7);
		ball3.setFitWidth(25);
		ball3.setFitHeight(25);
		ball3.setX(50);
		add(ball3);
		
	}
	
	public void act() {
		
	}

}
