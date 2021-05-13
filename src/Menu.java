import java.util.HashSet;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Menu extends BorderPane {

	private Game game;
	private HashSet<KeyCode> keys;
	
	public Menu(Game game) {
		this.game = game;
		keys = new HashSet<KeyCode>();
		Text t = new Text("CLICK ENTER TO PLAY");
		setCenter(t);
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
