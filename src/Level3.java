
public class Level3 extends Level2 {


	Ball ball3;
	public Level3() {
		ball.changeMove(7,7);
		ball2.changeMove(7, 7);
		ball3 = new Ball(7,7);
		ball3.setFitWidth(25);
		ball3.setFitHeight(25);
		int r2 =  (int) ((Math.random() * (g.returnSize()-ball.getWidth())) + ball.getWidth());
		ball3.setX(r2);
		add(ball3);
		
	}
	

	@Override
	public void act(long now) {
		if(score.getScore() == 25) {
			g.getLevel3().stop();
			g.getBorderPane().setCenter(g.getGameOver());
		}
		if(score.getScore() == 0) {
			g.getLevel3().stop();
			g.getBorderPane().setCenter(g.getGameOver());
		}
	}

}
