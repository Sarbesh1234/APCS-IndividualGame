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
	public Game() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("BallBounce");
		Menu menu = new Menu(this);
		BorderPane rootNode = new BorderPane();
		rootNode.setCenter(menu);
		scene = new Scene(rootNode,500,500);
		stage.setScene(scene);
		stage.show();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					BallWorld world = new BallWorld();
					world.start();
					rootNode.setCenter(world);
					stage.setScene(scene);
					stage.show();
					world.requestFocus();
				}
				
			}
		});
		
		
		
	}
	
	

}
