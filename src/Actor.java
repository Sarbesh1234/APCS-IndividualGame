import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public abstract class Actor extends javafx.scene.image.ImageView {

	public Actor() {
		
	}
	
	public abstract void act(long now);
	
	public double getHeight() {
		return getBoundsInParent().getHeight();
	}
	
	public double getWidth() {
		return getBoundsInParent().getWidth();
	}
	
	public World getWorld() {
		return (World) getParent();
	}
	
	public void move(double dx, double dy) {
		this.setX(getX()+dx);
		this.setY(getY()+dy);
	}
	
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
		ArrayList<A> arr = new ArrayList<A>();
		ObservableList<Node> nodesList = getWorld().getChildren();
		for(Node node: nodesList) {
			if(cls.isInstance(node) && this != node && node.getBoundsInParent().intersects(this.getBoundsInParent())){
				arr.add((A) node);
			}
		}
		return arr;
		
	}

	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
		ObservableList<Node> nodesList = getWorld().getChildren();
		for(Node node: nodesList) {
			if(cls.isInstance(node) && this != node && node.getBoundsInParent().intersects(this.getBoundsInParent())){
				return (A) node;
			}
		}
		return null;
	}
	

}
