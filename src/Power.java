import javafx.scene.image.Image;

public class Power extends Actor {
	private int dx;
	private int dy;
	public Power(int dx,int dy) {
		this.dx = dx;
		this.dy = dy;
		setImage(new Image(getClass().getClassLoader().getResource("resources/red.png").toString()));
	}

	@Override
	public void act(long now) {
		move(dx,dy);
		if(getOneIntersectingObject(Paddle.class) != null) {
			Paddle a = (Paddle) getIntersectingObjects(Paddle.class).get(0);
			a.setR(15);
			a.setL(15);
			getWorld().remove(this);
		}
	}

}
