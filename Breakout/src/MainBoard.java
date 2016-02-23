import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class MainBoard.
 * 
 * <p>
 * 
 * MainBoard extends BorderPane, it places GameBoard in centre and HBox with
 * buttons on top.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public class MainBoard extends BorderPane implements Finals {

	private Button btStart = new Button("Start");
	private Button btPause = new Button("Pause");
	private Button btLevel1 = new Button("Level 1");
	private Button btLevel2 = new Button("Level 2");
	private Button btLevel3 = new Button("Level 3");
	private StackPane stack = new StackPane();
	private HBox box = new HBox();
	private GameBoard board = new GameBoard(1);

	/**
	 * Instantiates a new main board. Each button has a distinct role, and it's
	 * name is quite self-explanatory.
	 */
	public MainBoard() {

		btStart.setOnAction(e -> {

			board.play();
			board.requestFocus();

		});

		btPause.setOnAction(e -> {

			board.pause();
			board.requestFocus();

		});

		btLevel1.setOnAction(e -> {

			GameBoard bored = new GameBoard(1);
			stack.getChildren().addAll(bored, bored.getMessage());
			board = bored;
			board.requestFocus();

		});

		btLevel2.setOnAction(e -> {

			GameBoard bored = new GameBoard(2);
			stack.getChildren().addAll(bored, bored.getMessage());
			board = bored;
			board.requestFocus();

		});

		btLevel3.setOnAction(e -> {

			GameBoard bored = new GameBoard(3);
			stack.getChildren().addAll(bored, bored.getMessage());
			board = bored;
			board.requestFocus();

		});

		stack.getChildren().addAll(board, board.getMessage());
		stack.setMaxSize(WIDTH, HEIGHT);

		box.getChildren()
				.addAll(btStart, btPause, btLevel1, btLevel2, btLevel3);
		box.setAlignment(Pos.TOP_CENTER);
		box.setBackground(new Background(new BackgroundFill(Color.BLACK, null,
				null)));

		setBackground(new Background(
				new BackgroundFill(Color.BLACK, null, null)));
		setCenter(stack);
		setTop(box);

		board.requestFocus();

	}
}
