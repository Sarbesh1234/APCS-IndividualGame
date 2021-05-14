import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Paddle extends Actor {
	
	private double temp;
	private boolean test;
	
	private double old = 0;
	private double new2;

	public Paddle() {
		setImage(new Image(getClass().getClassLoader().getResource("resources/paddle.png").toString()));
	}

	@Override
	public void act(long now) {
		
			if(getWorld().checkKey(KeyCode.LEFT)) {
				if(getX()>10) {
					this.setX(this.getX()-10);
				}
			}
			if(getWorld().checkKey(KeyCode.RIGHT)) {
				if(getX() + getWidth()<getWorld().getWidth()-10) {
					this.setX(this.getX() + 10);
				}
			}
			/*
			if(getWorld().checkKey(KeyCode.UP)) {
				if(getY()>10) {
					this.setY(this.getY() - 10);
				}
			}
			
			if(getWorld().checkKey(KeyCode.DOWN)) {
				if(getY()+getHeight()<getWorld().getHeight()-10) {
					this.setY(this.getY() + 10);
				}
			}*/
			
			old = new2;
			new2 = this.getX();
	}
	
	/*public int isPaddleMoving() {
		if(test == false) {
			temp = this.getX();
			test = true;
		}
		if(getX()>temp) {
			test = false;
			return 1;
		}else if(getX()<temp) {
			test = false;
			return -1;
		}else {
			return 0;
		}
		
		
	}*/
	
	
	public boolean paddleMoving() {
		if(new2!=old) {
			return true;
		}
		return false;
	}
	
	public boolean paddleMovingRight() {
		
		if(new2>old && paddleMoving()) {
			return true;
		}
		return false;
	}
	
	public boolean paddleMovingLeft() {
		if(new2<old && paddleMoving()) {
			return true;
		}
		return false;
	}

}
