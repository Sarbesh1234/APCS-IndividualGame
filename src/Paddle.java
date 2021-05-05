import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Paddle extends Actor {

	public Paddle() {
		setImage(new Image(getClass().getClassLoader().getResource("resources/paddle.png").toString()));
	}

	@Override
	public void act(long now) {
		if(getWorld().checkKey(KeyCode.LEFT)) {
			this.setX(this.getX() - 10);
		}
		if(getWorld().checkKey(KeyCode.RIGHT)) {
			this.setX(this.getX() + 10);
		}
	}

}
