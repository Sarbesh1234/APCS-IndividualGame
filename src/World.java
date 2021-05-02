import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class World extends Pane {

	private AnimationTimer timer;
	
	public World() {
		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				act(now);
				ObservableList<Node> nodes = getChildren();
				for(Node n: nodes) {
					((Actor) n).act(now);
				}
				
			}
			
		};
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
