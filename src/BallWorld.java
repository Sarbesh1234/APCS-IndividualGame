
public class BallWorld extends World {
	public Score score;
	public BallWorld() {
		this.score = score;
		score.setX(1);
		score.setY(1);
		getChildren().add(score);
	}
	@Override
	public void act(long now) {
	}
	public Score getScore() {
		return score;
	}
}
