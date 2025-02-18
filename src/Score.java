import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score extends Text {

	private int score;
	private int num;
	public void setNum(int num) {
		this.num = num;
	}
	public Score() {
		score = 26;
		this.setFont(new Font(30));
		updateDisplay();
	}
	
	public void updateDisplay() {
		this.setText(Integer.toString(score) + "/" + num);
	}
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
		updateDisplay();
	}
}
