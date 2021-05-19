
public class Level2 extends BallWorld {

	public static Game g2 = g;
	public Ball ball2;
	public Level2() {
		super(g2);
		ball.changeMove(6, 6);
		ball2 = new Ball(6,6);
		ball2.setFitWidth(25);
		ball2.setFitHeight(25);
		ball2.setX(70);
		add(ball2);
	}
	
	public void act(long now) {
		if(score.getScore() == 25) {
			g.getLevel2().stop();
			System.out.println("hello");
			g.getLevel3().start();
			g.getBorderPane().setCenter(g.getLevel3());
			g.getLevel3().requestFocus();
			
		}
	}
	
	

}
