

import javafx.scene.image.Image;

public class Ball extends Actor{
	private int dx;
	private int dy;
	private boolean check;
	private boolean test;
	private boolean flag;
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
		
		if(getY() > getWorld().getHeight()-getHeight()) {
			dy = -dy;
			BallWorld w = (BallWorld)getWorld();
			w.getScore().setScore(w.getScore().getScore()-1000);
		}
		if (getY()<0) {
			dy = -dy;
		}
		/*
		if(this.getIntersectingObjects(Paddle.class).size() !=0 && check == true) {
			dy = -dy;
			check = false;
		}
		if(this.getIntersectingObjects(Paddle.class).size() ==0) {
			check = true;
		}*/
		
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
			BallWorld w = (BallWorld)getWorld();
			w.getScore().setScore(w.getScore().getScore()+100);
		}
		/*
		if(this.getIntersectingObjects(Paddle.class).size()!=0) {
			Actor a = getIntersectingObjects(Paddle.class).get(0);
			if(test == false) {
				System.out.println(((Paddle) a).isPaddleMoving());
				if(((Paddle) a).isPaddleMoving() == 0) {
					if(getX()>=a.getX() || getX()<=a.getX()+a.getWidth()) {
						dy = -dy;
					}
				}else if(((Paddle) a).isPaddleMoving() == 1 || ((Paddle) a).isPaddleMoving() == -1) {
					if(getX()>a.getX() + a.getWidth()/3 && getX()<a.getX() + a.getWidth() - a.getWidth()/3) {
						dy = -dy;
					}
				}
				test = true;
			}
		}
		if(this.getIntersectingObjects(Paddle.class).size()==0) {
			test = false;
		}
		*/
		if(this.getOneIntersectingObject(Paddle.class) != null && flag == false) {
			flag = true;
			if(getOneIntersectingObject(Paddle.class) != null && paddleBounds(getOneIntersectingObject(Paddle.class)) && getOneIntersectingObject(Paddle.class).paddleMoving() == false) {
				dy = -dy;
			}
			else if(getOneIntersectingObject(Paddle.class) != null && paddleMiddle(getOneIntersectingObject(Paddle.class)) && getOneIntersectingObject(Paddle.class).paddleMoving() == true) {
				dy = -dy;
			}else if(getOneIntersectingObject(Paddle.class) != null && paddleLeft(getOneIntersectingObject(Paddle.class)) && getOneIntersectingObject(Paddle.class).paddleMovingLeft() == true) {
				dy = -dy;
				dx = -1;
			}else if(getOneIntersectingObject(Paddle.class) != null && paddleRight(getOneIntersectingObject(Paddle.class)) && getOneIntersectingObject(Paddle.class).paddleMovingRight() == true) {
				dy = -dy;
				dx =1;
			}else if(getOneIntersectingObject(Paddle.class) != null && paddleLeftEdge(getOneIntersectingObject(Paddle.class))) {
				dx = -1;
				dy = -dy;
			}else if(getOneIntersectingObject(Paddle.class) != null && paddleRightEdge(getOneIntersectingObject(Paddle.class))) {
				dx = 1;
				dy = -dy;
			}else {
				dy = -dy;
			}
		}
		
		if(this.getOneIntersectingObject(Paddle.class) == null) {
			flag = false;
		}
	
	
	}
	
	public boolean paddleBounds(Paddle p) {
		//Actor a = getOneIntersectingObject(Paddle.class);
		if(this.getOneIntersectingObject(Paddle.class).equals(p)) {
			if(getX() + getWidth()/2>=p.getX() && getX()+getWidth()/2<=p.getX()+getWidth()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean paddleMiddle(Paddle p) {
		//Actor a = getOneIntersectingObject(Paddle.class);
		if(this.getOneIntersectingObject(Paddle.class).equals(p)) {
			if(getX()+getWidth()/2>=p.getX() + p.getWidth()/3 && getX()+getWidth()/2</*p.getX() + p.getWidth() - p.getWidth()/3*/ p.getX()+(2*(p.getWidth()/3))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean paddleLeft(Paddle p) {
		//Actor a = getOneIntersectingObject(Paddle.class);
		if(this.getOneIntersectingObject(Paddle.class).equals(p)) {
			if(getX()+getWidth()/2>=p.getX() && getX()+getWidth()/2<=p.getX()+p.getWidth()/3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean paddleRight(Paddle p) {
		//Actor a = getOneIntersectingObject(Paddle.class);
		if(this.getOneIntersectingObject(Paddle.class).equals(p)) {
			if(getX()+getWidth()/2>=p.getX()+(p.getWidth()/3)*2 && p.getX()+getWidth()/2<=p.getX()+p.getWidth()/3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean paddleLeftEdge(Paddle p) {
		//Actor a = getOneIntersectingObject(Paddle.class);
		if(this.getOneIntersectingObject(Paddle.class).equals(p)) {
			if(getX()+getWidth() <= p.getX()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean paddleRightEdge(Paddle p) {
		//Actor a = getOneIntersectingObject(Paddle.class);
		if(this.getOneIntersectingObject(Paddle.class).equals(p)) {
			if(getX() >= p.getX()+p.getWidth()) {
				return true;
			}
		}
		return false;
	}
}
