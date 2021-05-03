import java.io.IOException;

import javafx.scene.image.Image;

public class Ball extends Actor{
	private int dx;
	private int dy;
	public Ball(int d, int b) {
		dx = d;
		dy = b;
		String path = null;
		try {
			path = getClass().getClassLoader().getResources("resources/ball.jpg").toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image img = new Image(path);
	}

	@Override
	public void act(long now) {
		move(dx,dy);
		if (dx > getWidth()||dx<0 ) {
			dx = -dx;
		}
		if (dy > getHeight()||dy<0 ) {
			dy = -dy;
		}
	}

}
