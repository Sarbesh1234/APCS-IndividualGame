import java.util.HashSet;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.lang.*;

public class Menu extends BorderPane {

	private Game game;
	private HashSet<KeyCode> keys;
	private Button b;
	//private Thread t;
	private Text t;
	private Help help;
	public Menu(Game game) {
		this.game = game;
		keys = new HashSet<KeyCode>();
		t = new Text("CLICK ENTER TO PLAY");
		t.setFont(new Font(30));
		setCenter(t);
		Button b = new Button("Help");
		CheckBox b2 = new CheckBox("Music");
		b2.setSelected(true);
		b2.setOnAction(event -> {
		    if (b2.isSelected()) {
		        game.getMediaPlayer().play();
		        game.setMusic(true);
		    }else {
		    	game.getMediaPlayer().pause();
		    	game.setMusic(false);
		    }
		});
		
		
		b.setOnAction(e -> {
			/*help = new Help(game);
			game.resetBorderPane();
			game.getBorderPane().setCenter(help.getRootPane());
			//getScene().setRoot(help.getRootPane());
			 * 
			 */
			Game.getStage().setScene(game.getHelpScene());
			
		});
		
		HBox box = new HBox();
		box.getChildren().addAll(b,b2);
		setTop(box);
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(1000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(5000);
		fade.setAutoReverse(true);
		t.setFill(Color.RED);
		fade.setNode(t);
		fade.play();
		
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					/*
					//BallWorld world = game.getBallWorld();
					BallWorld world = new BallWorld(game);
					world.start();
					game.getScene().setRoot(world);
					//world.start();
					//game.getBorderPane().setCenter(world);
					//stage.setScene(scene);
					//stage.show();
					//world.requestFocus();
					System.out.println("hit space");
					*/
					
					//creation of level 1 scene
					/*BallWorld b  = new BallWorld(game);
					BorderPane lvl1Layout = new BorderPane();
					lvl1Layout.setCenter(b);
					Scene s = new Scene(lvl1Layout,game.getSize(),game.getSize());
					game.setLevel1Scene(s);
					b.score.setScore(26);*/
//					
//					//creation of level 2 scene
//					Level2 lvl2  = new Level2();
//					BorderPane lvl2Layout = new BorderPane();
//					lvl2Layout.setCenter(lvl2);
//					Scene s2 = new Scene(lvl2Layout,game.getSize(),game.getSize());
//					game.setLevel1Scene(s2);
//							
//					//creation of level 3 scene
//					Level3 lvl3  = new Level3();
//					BorderPane lvl3Layout = new BorderPane();
//					lvl3Layout.setCenter(lvl3);
//					Scene s3 = new Scene(lvl3Layout,game.getSize(),game.getSize());
//					game.setLevel1Scene(s3);
//					
					game.getlvl1().getScore().setScore(26);
					game.getlvl2().getScore().setScore(51);
					game.getlvl3().getScore().setScore(101);
					Game.getStage().setScene(game.getLevel1Scene());
					game.getlvl1().requestFocus();
					game.getlvl1().start();
					
					//System.out.println("hello");
					
				}
				
			}
		});
		
		
	}
	/*
	public void setSpecialText() {
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(3000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(5000);
		fade.setAutoReverse(true);
		t.setFill(Color.RED);
		fade.setNode(t);
		fade.play();
		//fade circle
		try {
			Thread.sleep(10000);
		}catch(Exception e) {
			
		}
		fade.stop();
	}*/
	
	public void addKey(KeyCode k) {
		keys.add(k);
	}
	
	public void removeKey(KeyCode k) {
		keys.remove(k);
	}
	
	public boolean checkKey(KeyCode k) {
		for(KeyCode key: keys) {
			if(key.equals(k)) {
				return true;
			}
		}
		return false;
	}
	private class ButtonHandler implements EventHandler<ActionEvent> {

		
		public void handle(ActionEvent event) {
			if(event.getSource() == b) {
				
			}
			
		}
		
	}
	

}
