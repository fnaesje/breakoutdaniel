import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Class App.
 * 
 * <p>
 * 
 * This class creates a MainBoard object and displays it in a window.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public class App extends Application implements Finals {

	private MainBoard board = new MainBoard();
	private Scene scene = new Scene(board, WIDTH, HEIGHT + 35);

	/**
	 * Override of start method in Application class, it's main job is to
	 * display a MainBoard object.
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Breakout");
		primaryStage.show();

	}

	/**
	 * The main method, used to run JavaFX app in a JDE.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		launch(args);

	}
}
