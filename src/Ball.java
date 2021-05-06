

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
		
		if(this.getIntersectingObjects(Brick.class).size() != 0) {
			Actor a = getIntersectingObjects(Brick.class).get(0);
			if(getX()>a.getX() && getX()<a.getX()+getWidth()) {
				dy = -dy;
			}else if(getY()>a.getY() && getY()<a.getY()+getHeight()) {
				dx = -dx;
			}else {
				dx = -dx;
				dy = -dy;
			}
			getWorld().remove(a);
		}
			
	}
	public void reduceScore() {
		if (getY()==0) {
			BallWorld y = (BallWorld)getWorld();
			Score x = y.getScore();
			y+=1000;
		}
	}
}
