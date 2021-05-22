
public class Level2 extends BallWorld {

	public static Game g2 = g;
	public Ball ball2;
	public Level2() {
		super(g2);
		ball.changeMove(6, 6);
		ball2 = new Ball(6,6);
		ball2.setFitWidth(25);
		ball2.setFitHeight(25);
		int r2 =  (int) ((int) (Math.random() * g.returnSize()-getWidth()) + getWidth());
		ball2.setX(r2);
		add(ball2);
		
	}
	
	public void act(long now) {
		if(score.getScore() == 10) {
			g.getLevel2().stop();
			System.out.println("hello");
			g.getLevel3().start();
			g.getBorderPane().setCenter(g.getLevel3());
			g.getLevel3().requestFocus();
			
		}
		int r2 =  (int) ((int) (Math.random() * ball.getWorld().getWidth()-getWidth()) + getWidth());
		int r = (int) (Math.random() * 299) + 1;
		if(r == 5) {
			Power p1 = new Power(0,5);
			p1.setX(r2);
			p1.setFitWidth(25);
			p1.setFitHeight(25);
			add(p1);
		}
		
	}
	
	

}
