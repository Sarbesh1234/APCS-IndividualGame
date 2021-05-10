
public class BallWorld extends World {
	public Score score;
	public BallWorld() {
		score = new Score();
		score.setX(50);
		score.setY(50);
		getChildren().add(score);
	}
	@Override
	public void act(long now) {
	}
	public Score getScore() {
		return score;
	}
}
