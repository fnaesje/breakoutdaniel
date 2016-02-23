import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * The Class Ball.
 * 
 * <p>
 * 
 * This class extends Circle and it simulates a ball moving on screen, its main
 * job is to inform GameBoard how and where it should move.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public class Ball extends Circle implements Finals {

	private double dx = 1, dy = 1;

	/**
	 * Instantiates a new ball object.
	 */
	public Ball() {

		super(BALL_START_X, BALL_START_Y, BALL_RADIUS, Color.DEEPPINK);

	}

	/**
	 * Resets balls placement and move direction.
	 */
	public void resetState() {

		setCenterX(BALL_START_X);
		setCenterY(BALL_START_Y);
		dx = 1;
		dy = 1;

	}

	/**
	 * Sets the dx. Dx decides in which x direction ball will move.
	 *
	 * @param dx
	 *            the new dx
	 */
	public void setDx(double dx) {

		this.dx = dx;

	}

	/**
	 * Reverse dx.
	 */
	public void reverseDx() {

		dx *= -1;

	}

	/**
	 * Gets the dx.
	 *
	 * @return the dx
	 */
	public double getDx() {

		return dx;

	}

	/**
	 * Sets the dy. Dy decides in which y direction ball will move.
	 *
	 * @param dy
	 *            the new dy
	 */
	public void setDy(double dy) {

		this.dy = dy;

	}

	/**
	 * Reverse dy.
	 */
	public void reverseDy() {

		dy *= -1;

	}

	/**
	 * Gets the dy.
	 *
	 * @return the dy
	 */
	public double getDy() {

		return dy;

	}
}
