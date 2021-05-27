import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Text2 extends Text {

	private String text;
	private int fontsize;
	public Text2(String text, int fontsize) {
		this.text = text;
		this.fontsize = fontsize;
		displayText();
	}
	public void displayText() {
		this.setFont(new Font(fontsize));
		this.setText(text);
	}
	

}
