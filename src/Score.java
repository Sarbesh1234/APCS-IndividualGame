import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score extends Text {

	private int score;
	public Score() {
		score = 11;
		this.setFont(new Font(30));
		updateDisplay();
	}
	
	public void updateDisplay() {
		this.setText(Integer.toString(score) + "/25");
	}
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
		updateDisplay();
	}
}
