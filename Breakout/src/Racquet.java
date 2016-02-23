import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The Class Racquet.
 * 
 * <p>
 * 
 * This class simulates racquet, it's width is decided by the level, and it's
 * main function is to respond to ball collision.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public class Racquet extends Rectangle implements Finals {

	private int racquetWidth, halfWidth, level;

	/**
	 * Instantiates a new racquet, its width is decided by the level value
	 * provided.
	 *
	 * @param level
	 *            the level which decides racquet width
	 */
	public Racquet(int level) {

		this.level = level;
		racquetWidth = 65 / level + 20;
		halfWidth = racquetWidth / 2;

		setX(WIDTH / 2 - halfWidth);
		setY(RACQUET_START_Y);
		setWidth(racquetWidth);
		setHeight(RACQUET_HEIGHT);
		setFill(Color.BLUEVIOLET);

	}

	/**
	 * Resets racquet placement on board.
	 */
	public void resetState() {

		setX(WIDTH / 2 - halfWidth);
		setY(RACQUET_START_Y);

	}

	/**
	 * Collision, it bounces ball off racquet by first checking if ball moves
	 * downwards and bounces it only then, so the ball won't be stuck inside
	 * racquet. Then it calculates distance between racquets centre and balls
	 * centre in x-coordinates and divides this value by half. This means that
	 * ball will change its movement angle, but in order to keep it at a
	 * constant speed it subtracts dx value from 1 + level, and sets it as dy.
	 *
	 * @param ball
	 *            the ball that bounces from racquet
	 */
	public void collision(Ball ball) {

		if (ball.getDy() > 0) {

			double dx = (ball.getCenterX() - (getX() + halfWidth)) / halfWidth;
			double dy = (1 + level)
					- Math.abs(dx < 0.2 && dx > -0.2 ? 0.2 : dx);
			ball.setDx(dx < 0.2 && dx > - 0.2  ? dx < 0 ? -0.2 : 0.2 : dx);
			ball.setDy(-dy);

		}
	}

	/**
	 * Gets the half width.
	 *
	 * @return the half width
	 */
	public int getHalfWidth() {

		return halfWidth;

	}
}