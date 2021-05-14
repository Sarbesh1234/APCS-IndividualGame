import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score extends Text {

	private int score;
	public Score() {
		score = 1;
		this.setFont(new Font(30));
		updateDisplay();
	}
	
	public void updateDisplay() {
		this.setText(Integer.toString(score));
	}
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
		updateDisplay();
	}
}
