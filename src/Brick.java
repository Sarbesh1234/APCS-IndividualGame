import javafx.scene.image.Image;

public class Brick extends Actor {

	public Brick() {
		setImage(new Image(getClass().getClassLoader().getResource("resources/brick.png").toString()));
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
