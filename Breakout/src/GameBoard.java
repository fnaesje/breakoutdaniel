import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * The Class GameBoard.
 * 
 * <p>
 * 
 * GameBoard contains every object that is used in game, except buttons. This
 * class have the main logic code that runs the application.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public class GameBoard extends Pane implements Finals {

	private int lives;
	private long totalSecs;
	private Text timer;
	private Text message;
	private Ball ball;
	private Group bricks;
	private Group liveTokens;
	private Racquet racquet;
	private Timeline timeline;
	private Timeline timerline;
	private Rectangle bricksBound;

	/**
	 * Instantiates a new game board, it places every component on board and
	 * then it instantiates timelines that run the application.
	 *
	 * @param level
	 *            the level
	 */
	public GameBoard(int level) {

		ball = new Ball();
		bricks = new Group();
		liveTokens = new Group();
		racquet = new Racquet(level);
		bricks = Brick.generateBricks();
		bricksBound = new Rectangle(BRICK_BOUND_X, BRICK_BOUND_Y,
				BRICK_BOUND_WIDTH, BRICK_BOUND_HEIGHT);
		// Uncomment to check it bricksBound rectangle is placed correctly.
		// bricksBound.setStroke(Color.WHITE);
		// getChildren().add(bricksBound);
		timer = new Text(TEXT_X, TEXT_Y, "00:00:00");
		timer.setFont(new Font(TEXT_FONT, TIMER_SIZE));
		timer.setStroke(Color.RED);
		message = new Text();
		message.setFont(new Font(TEXT_FONT, MESSAGE_SIZE));
		message.setTextAlignment(TextAlignment.CENTER);
		message.setStroke(Color.ANTIQUEWHITE);

		lives = 6 / level;

		for (int i = 1; i <= lives; i++) {

			liveTokens.getChildren().add(
					new Circle(LIVE_TOKEN_START_X * i * 2, LIVE_TOKEN_START_Y,
							LIVE_TOKEN_RADIUS, Color.DEEPPINK));

		}

		setBackground(new Background(
				new BackgroundFill(Color.BLACK, null, null)));

		getChildren().addAll(timer, liveTokens, bricks, racquet, ball);

		timeline = new Timeline(new KeyFrame(Duration.millis(5), e -> move()));
		timerline = new Timeline(new KeyFrame(Duration.seconds(1),
				e -> updateTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timerline.setCycleCount(Timeline.INDEFINITE);
		
		
		setOnMouseMoved(e -> {

			if (timeline.getStatus() == Status.RUNNING) {

				if (e.getSceneX() > racquet.getHalfWidth()
						&& e.getSceneX() < WIDTH - racquet.getHalfWidth()) {

					racquet.setX(e.getSceneX() - racquet.getHalfWidth());

				}
			}
		});

	}

	/**
	 * Updates timer by adding one second to totalSecs.
	 */
	public void updateTimer() {

		totalSecs++;

		long hours = totalSecs / 3600;
		long minutes = (totalSecs % 3600) / 60;
		long seconds = totalSecs % 60;
		timer.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));

	}

	/**
	 * Plays timeline.
	 */
	public void play() {

		message.setText(PLAY);
		timeline.play();
		timerline.play();

	}

	/**
	 * Pauses timeline.
	 */
	public void pause() {

		message.setText(PAUSE);
		timeline.pause();
		timerline.pause();

	}

	/**
	 * Move everything on board, first it calls the moveBall method, then it
	 * changes racquets x-coordinate to mouses x-coordinate. Lastly it checks if
	 * player has either won or lost this game, and if so it stops the game and
	 * changes message accordingly.
	 */
	public void move() {

		moveBall();
		

		if (liveTokens.getChildren().size() == 0) {

			pause();
			message.setText(DEFEAT);

		}

		if (bricks.getChildren().size() == 0) {

			pause();
			message.setText(VICTORY + timer.getText());

		}
	}

	/**
	 * Move ball. First it checks whether ball has hit sides, top or bottom
	 * edges and bounces it off accordingly by either changing dx or dy, or when
	 * it hits bottom it resets and stops the game as well as subtracting on
	 * live from the live pool. Then it checks if ball intersects racuqet and
	 * then calls racquets collision method. Then it checks if ball intersects
	 * with brickBounds rectangle and if so it goes over every ball in bricks
	 * group, checks for collision, calls the collision method if ball collides
	 * with a brick and then it deletes it if collision returns true. At last it
	 * sets new coordinates for balls centre.
	 */
	public void moveBall() {

		if (ball.getCenterX() < BALL_RADIUS
				|| ball.getCenterX() > WIDTH - BALL_RADIUS) {

			ball.reverseDx();

		} else if (ball.getCenterY() < BALL_RADIUS) {

			ball.reverseDy();

		} else if (ball.getCenterY() > HEIGHT - BALL_RADIUS) {

			pause();
			ball.resetState();
			racquet.resetState();
			lives--;
			liveTokens.getChildren()
					.remove(liveTokens.getChildren().size() - 1);

		} else if (ball.intersects(racquet.getBoundsInLocal())) {

			racquet.collision(ball);

		} else if (ball.intersects(bricksBound.getBoundsInLocal())) {

			for (Node b : bricks.getChildren()) {

				if (ball.intersects(b.getBoundsInLocal())) {

					Brick brick = (Brick) b;

					if (brick.collision(ball)) {

						bricks.getChildren().remove(b);

					}

					break;
				}
			}
		}

		ball.setCenterX(ball.getCenterX() + ball.getDx());
		ball.setCenterY(ball.getCenterY() + ball.getDy());

	}

	/**
	 * Gets the message to be displayed, informing user of gamestate.
	 *
	 * @return the message
	 */
	public Text getMessage() {

		return message;

	}
}
