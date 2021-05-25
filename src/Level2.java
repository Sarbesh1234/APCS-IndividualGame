
public class Level2 extends BallWorld {

	public static Game g2 = g;
	public Ball ball2;
	public Level2() {
		super(g2);
		ball.changeMove(6, 6);
		ball2 = new Ball(6,6);
		ball2.setFitWidth(25);
		ball2.setFitHeight(25);
		int r2 =  (int) ((Math.random() * (g.returnSize()-ball.getWidth()*2)) + ball.getWidth()*2);
		ball2.setX(r2);
		add(ball2);
		
	}
	
	public void act(long now) {
		if(score.getScore() == 15) {
			g.getLevel2().stop();
			System.out.println("hello");
			g.getLevel3().start();
			g.getBorderPane().setCenter(g.getLevel3());
			g.getLevel3().requestFocus();
			
		}
		if(score.getScore() <= 0) {
			g.getLevel2().stop();
			g.getBorderPane().setCenter(g.getGameOver());
		}
		int r2 =  (int) ((int) (Math.random() * ball.getWorld().getWidth()-getWidth()) + getWidth());
		int r = (int) (Math.random() * 299) + 1;
		if(r == 5) {
			Power p1 = new Power(0,5);
			p1.setX(r2);
			p1.setFitWidth(25);
			p1.setFitHeight(25);
			add(p1);
			System.out.println("gu");
		}
		int r3 = (int) (Math.random() * 199) + 1;
		if(r3 == 5) {
			Power2 p2 = new Power2(0,5);
			p2.setX(r2);
			p2.setFitWidth(25);
			p2.setFitHeight(25);
			add(p2);
			System.out.println("ga");
		}
		
	}
	
	

}
