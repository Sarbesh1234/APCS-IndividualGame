import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Power2 extends Actor {
	private int dx;
	private int dy;
	private AudioClip explo;
	private Game g;
	public Power2(Game g,int dx,int dy) {
		this.g = g;
		this.dx = dx;
		this.dy = dy;
		setImage(new Image(getClass().getClassLoader().getResource("resources/red.png").toString()));
		explo = new AudioClip(getClass().getResource("resources/explo.mp3").toExternalForm());
	}

	@Override
	public void act(long now) {
		move(dx,dy);
		if(getOneIntersectingObject(Paddle.class) != null) {
			//Paddle a = (Paddle) getIntersectingObjects(Paddle.class).get(0);
			//a.setR(15);
			//a.setL(15);
			getWorld().remove(this);
			if(g.getMusic()) {
				explo.play();
			}
		}
	}

}