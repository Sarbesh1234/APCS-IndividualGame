
public class Level3 extends Level2 {


	Ball ball3;
	public Level3() {
		ball.changeMove(7,7);
		ball2.changeMove(7, 7);
		ball3 = new Ball(7,7);
		ball3.setFitWidth(25);
		ball3.setFitHeight(25);
		int r2 =  (int) ((Math.random() * (g.returnSize()-ball.getWidth()*2)) + ball.getWidth()*2);
		ball3.setX(r2);
		add(ball3);
		
	}
	

	@Override
	public void act(long now) {
		if(score.getScore() == 25) {
			g.getLevel3().stop();
			g.getBorderPane().setCenter(g.getGameOver());
		}
		if(score.getScore() <= 0) {
			g.getLevel3().stop();
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
		}
		int r4 = (int) (Math.random() * 199) + 1; //generates number from 1 to 200
		
		if(r4==10) {
			Power3 gold = new Power3(0,5);
			gold.setFitWidth(25);
			gold.setFitHeight(25);
			gold.setX(r2);
			add(gold);
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
