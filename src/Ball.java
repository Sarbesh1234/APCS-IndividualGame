

import javafx.scene.image.Image;

public class Ball extends Actor{
	private int dx;
	private int dy;
	private boolean check;
	public Ball(int d, int b) {
		dx = d;
		dy = b;	
		setImage(new Image(getClass().getClassLoader().getResource("resources/ball2.png").toString()));

	}

	@Override
	public void act(long now) {
		move(dx,dy);
		/*if (getX() > getWorld().getWidth()-getWidth()||getX()<0 ) {
			dx = -dx;
		}else if(getY() > getWorld().getHeight()-getHeight()||getY()<0) {
			dy = -dy;
		}else if(this.getIntersectingObjects(Paddle.class) != null) {
			dy = -dy;
		}
		*/
		if (getX() > getWorld().getWidth()-getWidth()||getX()<0 ) {
			dx = -dx;
		}
		
		if(getY() > getWorld().getHeight()-getHeight()||getY()<0) {
			dy = -dy;
		}
		
		if(this.getIntersectingObjects(Paddle.class).size() !=0 && check == true) {
			dy = -dy;
			check = false;
		}
		if(this.getIntersectingObjects(Paddle.class).size() ==0) {
			check = true;
		}
		/*
		if (getY() > getWorld().getHeight()-getHeight()||getY()<0 ) {
			dy = -dy;
		}
		if(this.getIntersectingObjects(Paddle.class).size() != 0)  {
			dy = -dy;
		}*/
		
		
		
	}

}
