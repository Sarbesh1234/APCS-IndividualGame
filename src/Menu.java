import java.util.HashSet;

import javafx.animation.FadeTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.lang.*;

public class Menu extends BorderPane {

	private Game game;
	private HashSet<KeyCode> keys;
	//private Thread t;
	private Text t;
	public Menu(Game game) {
		this.game = game;
		keys = new HashSet<KeyCode>();
		t = new Text("CLICK ENTER TO PLAY");
		t.setFont(new Font(30));
		setCenter(t);
		
		
	}
	
	public void setSpecialText() {
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(3000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(5000);
		fade.setAutoReverse(true);
		t.setFill(Color.BLUE);
		t.setFill(Color.RED);
		fade.setNode(t);
		fade.play();
		try {
			Thread.sleep(10000);
		}catch(Exception e) {
			
		}
		fade.stop();
	}
	
	public void addKey(KeyCode k) {
		keys.add(k);
	}
	
	public void removeKey(KeyCode k) {
		keys.remove(k);
	}
	
	public boolean checkKey(KeyCode k) {
		for(KeyCode key: keys) {
			if(key.equals(k)) {
				return true;
			}
		}
		return false;
	}
	

}
