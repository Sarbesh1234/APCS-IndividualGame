import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Paddle extends Actor {
	
	private double temp;
	private boolean test;
	
	private double old = 0;
	private double new2;
	private int r;
	private int l;
	private AudioClip explo;

	public Paddle() {
		setImage(new Image(getClass().getClassLoader().getResource("resources/paddle.png").toString()));
		r = 10;
		l = 10;
		explo = new AudioClip(getClass().getResource("resources/explo.mp3").toExternalForm());
	}

	@Override
	public void act(long now) {
			
			
		
			
//			Media explo = new Media(getClass().getResource("resources/explo.mp3").toExternalForm());
//			MediaPlayer mediaPlayer = new MediaPlayer(explo);
			if(getWorld().checkKey(KeyCode.LEFT)) {
				if(getX()>10) {
					this.setX(this.getX()-l);
				}
			}
			if(getWorld().checkKey(KeyCode.RIGHT)) {
				if(getX() + getWidth()<getWorld().getWidth()-10) {
					this.setX(this.getX() + r);
				}
			}
			if(getOneIntersectingObject(Power.class)!=null) {
				Power p = getOneIntersectingObject(Power.class);
				r +=1;
				l +=1;
				explo.play();
			}
			if(getOneIntersectingObject(Power2.class)!=null) {
				//Power2 p = getOneIntersectingObject(Power2.class);
				r-=1;
				l-=1;
				explo.play();
			}
			if(getOneIntersectingObject(Power3.class)!=null) {
				Level3 w = (Level3)getWorld();
				w.getScore().setScore(w.getScore().getScore()+5);
				explo.play();
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
	public void setR(int x) {
		r = x;
	}
	public void setL(int y) {
		l = y;
	}

}
