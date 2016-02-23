import java.util.Random;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The Class Brick.
 * 
 * <p>
 * 
 * This class simulates bricks on the board. Each has the same width and height,
 * and they all have a method for checking collision with ball object. It also
 * has a static method for generating a group containing all bricks to be shown
 * on board.
 * 
 * @author Daniel Aaron Salwerowicz STUDENTNUMMER : 530203
 * @version 1.0
 * @since 2015-03-27
 */
public class Brick extends Rectangle implements Finals {

	private BrickColour brickColour;

	/**
	 * Instantiates a new brick.
	 *
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param colour
	 *            the bricks colour
	 */
	public Brick(double x, double y, BrickColour colour) {

		super(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		setFill(Color.web(colour.toString()));
		setStroke(Color.BLACK);
		brickColour = colour;

	}

	/**
	 * Generate group bricks.
	 *
	 * @return the group containing bricks where 20 percent of bricks are
	 *         randomly deleted.
	 */
	public static Group generateBricks() {

		BrickColour colour = null;
		Group bricks = new Group();
		Random random = new Random();

		for (int i = 0; i < BRICKS_IN_ROW; i++) {

			switch (i) {
			case 0:
				colour = BrickColour.BLUE;
				break;
			case 3:
				colour = BrickColour.GREEN;
				break;
			case 6:
				colour = BrickColour.YELLOW;
				break;
			case 9:
				colour = BrickColour.RED;
				break;
			}

			for (int j = 0; j < BRICKS_IN_COLUMN; j++) {

				bricks.getChildren().add(
						new Brick(j * (BRICK_WIDTH) + BRICK_START_X, i
								* (BRICK_HEIGHT) + BRICK_START_Y, colour));

			}
		}

		for (int i = 0; i < (double) (BRICKS_IN_COLUMN * BRICKS_IN_ROW) / 100.0 * 20; i++) {

			bricks.getChildren().remove(
					random.nextInt(bricks.getChildren().size()));

		}

		return bricks;

	}

	/**
	 * Collision check it compares x-coordinates of both edges with balls center
	 * x-coordinate and the same for y. If one of them lies between edges then
	 * it chooses in which way ball should re-bounce, and it also calls the
	 * isDead method to determine whether the brick should dissapear or change
	 * colour.
	 *
	 * @param ball
	 *            the ball which is in contact with brick
	 * @return true, if ball was succesfully re-bounced and brick is to be
	 *         deleted.
	 */
	public boolean collision(Ball ball) {

		int x = (int) Math.floor(ball.getCenterX());
		int y = (int) Math.floor(ball.getCenterY());

		if (x >= getX() && x <= getX() + BRICK_WIDTH) {

			ball.reverseDy();
			return isDead();

		} else if (y >= getY() && y <= getY() + BRICK_HEIGHT) {

			ball.reverseDx();
			return isDead();

		}

		return false;
	}

	/**
	 * Checks value of brickColour variable, if BLUE change to GREEN, if GREEN
	 * change to YELLOW, if YELLOW change to RED if RED, return true to delete
	 * the brick.
	 *
	 * @return true, if brick is to be deleted.
	 */
	private boolean isDead() {

		switch (brickColour) {

		case BLUE:
			
			brickColour = BrickColour.GREEN;
			break;

		case GREEN:
			
			brickColour = BrickColour.YELLOW;
			break;

		case YELLOW:
			
			brickColour = BrickColour.RED;
			break;

		case RED:
			
			return true;

		}

		setFill(Color.web(brickColour.toString()));
		return false;
		
	}
}

enum BrickColour {
	
	BLUE("#0000FF"), GREEN("#008000"), RED("#FF0000"), YELLOW("#FFFF00");

	private String rgb;

	BrickColour(String rgb) {
		
		this.rgb = rgb;
		
	}

	public String toString() {
		
		return rgb;
		
	}
}