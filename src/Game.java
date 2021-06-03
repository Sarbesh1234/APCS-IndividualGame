import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Game extends Application {
	Scene scene;
	//Level2 lvl2;
	//Level3 lvl3;
	BallWorld world;
	BorderPane rootNode;
	GameOver g;
	Win w;
	Menu menu;
	private final int SIZE = 500;
	private Scene mainMenu;
	private Scene help;
	private Scene level1;
	private Scene level2;
	private Scene level3;
	private Scene gameover;
	private static Stage window;
	private BallWorld b;
	private Level2 lvl2;
	private Level3 lvl3;
	private boolean isMusic = true;
	private MediaPlayer mediaPlayer;
	public Game() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		/*window = stage;
		size = 500;
		//stage.setTitle("BallBounce");
		window.setTitle("BallBounce");
		menu = new Menu(this);
		g = new GameOver(this);
		w = new Win();
		rootNode = new BorderPane();
		rootNode.setCenter(menu);
		scene = new Scene(rootNode,size,size);
		mainMenu = new Scene(rootNode,size,size);
		//stage.setScene(scene);
		//stage.show();
		window.setScene(mainMenu);
		window.show();
		world = new BallWorld(this);
		lvl2 = new Level2();
		lvl3 = new Level3();
		/*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
		});*/
		window = stage;
		
		//creation of menu scene
		Menu m = new Menu(this);
		BorderPane menuLayout = new BorderPane();
		menuLayout.setCenter(m);
		mainMenu = new Scene(menuLayout,SIZE,SIZE);
		
		
		//creation of help scene
		Help h = new Help(this);
		BorderPane helpLayout = new BorderPane();
		helpLayout.setCenter(h.getRootPane());
		help = new Scene(helpLayout,SIZE,SIZE);
		
		//creation of gameover scene
		GameOver go = new GameOver(this);
		BorderPane gameOver = new BorderPane();
		gameOver.setCenter(go);
		gameover = new Scene(gameOver,SIZE,SIZE);
		
		//creation of level 1 scene
		b  = new BallWorld(this);
		BorderPane lvl1Layout = new BorderPane();
		lvl1Layout.setCenter(b);
		level1 = new Scene(lvl1Layout,SIZE,SIZE);
		
		//creation of level 2 scene
		lvl2  = new Level2();
		BorderPane lvl2Layout = new BorderPane();
		lvl2Layout.setCenter(lvl2);
		level2 = new Scene(lvl2Layout,SIZE,SIZE);
				
		//creation of level 3 scene
		lvl3  = new Level3();
		BorderPane lvl3Layout = new BorderPane();
		lvl3Layout.setCenter(lvl3);
		level3 = new Scene(lvl3Layout,SIZE,SIZE);
	
		window.setScene(mainMenu);
		window.show();
		
		
		music();
		
		
		
	}
	
	public void music() {
			int rand = (int) (Math.random()*5)+1;
			Media explo = new Media(getClass().getResource("resources/" + rand + ".mp3").toExternalForm());
			mediaPlayer = new MediaPlayer(explo);
			mediaPlayer.play();

	}
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	//accessing level classes to start and stop animation
	
	public BallWorld getlvl1() {
		return b;
	}
	
	public Level2 getlvl2() {
		return lvl2; 
	}
	
	public Level3 getlvl3() {
		return lvl3; 
	}
	
	
	//getters for scenes
	
	public Scene getHelpScene() {
		return help;
	}
	
	public Scene getLevel1Scene() {
		return level1;
	}
	
	public Scene getLevel2Scene() {
		return level2;
	}
	
	public Scene getLevel3Scene() {
		return level3;
	}
	
	public Scene getMenuScene() {
		return mainMenu;
	}
	
	public Scene getGameOverScene() {
		return gameover;
	}
	
	//setters for scenes
	
	public void setHelpScene(Scene s) {
		help = s;
	}
	
	public void setLevel1Scene(Scene s) {
		level1 = s;
	}
	
	public void setLevel2Scene(Scene s) {
		level2 = s;
	}
	
	public void setLevel3Scene(Scene s) {
		level3 = s;
	}
	
	
	public void setMenuScene(Scene s) {
		mainMenu = s;
	}
	
	public void getGameOverScene(Scene s) {
		gameover = s;
	}
	
	//accessing stage
	
	public static Stage getStage() {
		return window;
	}
	
	
	
	
	
	
	//
	
	
	
	public boolean getMusic() {
		return isMusic;
	}
	
	
	public void setMusic(boolean b) {
		isMusic = b;
	}
	
	
	public void resetBorderPane() {
		rootNode.getChildren().clear();
	}
	
	public Menu getMenu() {
		return menu;
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
	public int getSize() {
		return SIZE;
	}
	
	

}
