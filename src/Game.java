import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Game extends Application {
	Scene scene;
	Level2 lvl2;
	Level3 lvl3;
	BallWorld world;
	BorderPane rootNode;
	GameOver g;
	Win w;
	private int size;
	public Game() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		size = 500;
		stage.setTitle("BallBounce");
		Menu menu = new Menu(this);
		g = new GameOver();
		w = new Win();
		rootNode = new BorderPane();
		rootNode.setCenter(menu);
		scene = new Scene(rootNode,size,size);
		stage.setScene(scene);
		stage.show();
		world = new BallWorld(this);
		lvl2 = new Level2();
		lvl3 = new Level3();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					world.start();
					rootNode.setCenter(world);
					//stage.setScene(scene);
					//stage.show();
					world.requestFocus();
				}
				
			}
		});
		
		
		
	}
	
	public Scene getScene() {
		return scene;	
	}
	
	public GameOver getGameOver() {
		return g;
	}
	
	public Level2 getLevel2() {
		return lvl2;
	}
	
	public Level3 getLevel3() {
		return lvl3;
	}
	
	public Win getWinScreen() {
		return w;
	}
	public BorderPane getBorderPane() {
		return rootNode;
	}
	
	public BallWorld getBallWorld() {
		return world;
	}
	public int returnSize() {
		return size;
	}
	
	

}
