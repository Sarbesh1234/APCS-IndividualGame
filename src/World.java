import java.util.ArrayList;
import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public abstract class World extends Pane {

	private AnimationTimer timer;
	private HashSet<KeyCode> keys;
	
	public World() {
		keys = new HashSet<KeyCode>();
		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				act(now);
				ObservableList<Node> nodes = getChildren();
				/*for(Node n: nodes) {
					((Actor) n).act(now);
				}*/
				for(int i=0;i<nodes.size();i++) {
					((Actor) nodes.get(i)).act(now);
				}
				
			}
			
		};
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
	public abstract void act(long now);
	
	public void start() {
		timer.start();
		
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void add(Actor actor) {
		getChildren().add(actor);
	}
	
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}
	
	public <A extends Actor> java.util.List<A> getObjects(java.lang.Class<A> cls) {
		ArrayList<A> arr = new ArrayList<A>();
		ObservableList<Node> nodesList = getChildren();
		for(Node n: nodesList) {
			if(cls.isInstance(n)) {
				arr.add(cls.cast(n));
			}
		}
		return arr;
	}

}
