/**
 * The Interface Finals.
 * 
 * <p>
 * 
 * This interface contains values that are important for all classes in this
 * game. They can be changed and some of them affect others, their function is
 * quite self-explanatory.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public interface Finals {

	/** The Constant WIDTH. */
	public static final double WIDTH = 800.0;

	/** The Constant HEIGHT. */
	public static final double HEIGHT = 600.0;

	/** The Constant BOTTOM. */
	public static final double BOTTOM = HEIGHT - 30.0;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant BALL_RADIUS. */
	public static final double BALL_RADIUS = 6;

	/** The Constant BALL_START_X. */
	public static final double BALL_START_X = WIDTH / 4;

	/** The Constant BALL_START_Y. */
	public static final double BALL_START_Y = HEIGHT / 2 + HEIGHT / 8;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant BRICK_START_X. */
	public static final double BRICK_START_X = 50.0;

	/** The Constant BRICK_START_Y. */
	public static final double BRICK_START_Y = 50;

	/** The Constant BRICKS_IN_ROW. */
	public static final double BRICKS_IN_ROW = 10;

	/** The Constant BRICKS_IN_COLUMN. */
	public static final double BRICKS_IN_COLUMN = 15;

	/** The Constant BRICK_WIDTH. */
	public static final double BRICK_WIDTH = (WIDTH - (2 * BRICK_START_X))
			/ BRICKS_IN_COLUMN;

	/** The Constant BRICK_HEIGHT. */
	public static final double BRICK_HEIGHT = 20;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant BRICK_BOUND_X. */
	public static final double BRICK_BOUND_X = BRICK_START_X - 8;

	/** The Constant BRICK_BOUND_Y. */
	public static final double BRICK_BOUND_Y = BRICK_START_Y - 8;

	/** The Constant BRICK_BOUND_WIDTH. */
	public static final double BRICK_BOUND_WIDTH = BRICK_WIDTH * BRICKS_IN_COLUMN
			+ (BRICK_START_X - BRICK_BOUND_X) * 2;

	/** The Constant BRICK_BOUND_HEIGHT. */
	public static final double BRICK_BOUND_HEIGHT = BRICK_HEIGHT * BRICKS_IN_ROW
			+ 16;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant RACQUET_START_Y. */
	public static final double RACQUET_START_Y = BOTTOM;

	/** The Constant RACQUET_HEIGHT. */
	public static final double RACQUET_HEIGHT = 10;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant LIVE_TOKEN_RADIUS. */
	public static final double LIVE_TOKEN_RADIUS = 5;

	/** The Constant LIVE_TOKEN_START_X. */
	public static final double LIVE_TOKEN_START_X = LIVE_TOKEN_RADIUS + 2;

	/** The Constant LIVE_TOKEN_START_Y. */
	public static final double LIVE_TOKEN_START_Y = HEIGHT - LIVE_TOKEN_RADIUS + 2;

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant TIMER_SIZE. */
	public static final double TIMER_SIZE = 15;

	/** The Constant MESSAGE_SIZE. */
	public static final double MESSAGE_SIZE = 42;

	/** The Constant TEXT_X. */
	public static final double TEXT_X = WIDTH - 70;

	/** The Constant TEXT_Y. */
	public static final double TEXT_Y = HEIGHT - 5;

	/** The Constant TEXT_FONT. */
	public static final String TEXT_FONT = "Monospace";

	/** The Constant PAUSE. */
	public static final String PAUSE = "Game paused, press start to resume.";

	/** The Constant PLAY. */
	public static final String PLAY = "";

	/** The Constant DEFEAT. */
	public static final String DEFEAT = "You've lost.\nPlease try again.";

	/** The Constant VICTORY. */
	public static final String VICTORY = "You've won!!!\nYour time is: ";

}
