

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball extends Actor{
	private int dx;
	private int dy;
	private ImageView view;
	public Ball(int d, int b) {
		dx = d;
		dy = b;	
		setImage(new Image(getClass().getClassLoader().getResource("resources/ball.jpg").toString()));

	}

	@Override
	public void act(long now) {
		move(dx,dy);
		if (getX() > getWorld().getWidth()-getWidth()||getX()<0 ) {
			dx = -dx;
		}
		if (getY() > getWorld().getHeight()-getHeight()||getY()<0 ) {
			dy = -dy;
		}
	}

}
