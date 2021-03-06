package models;

/**
 * A gridmap for use in battleship. The user of this interface has control over
 * grid size and how grid space is managed.
 * 
 * @mathmodel an double array of positions of the dimensions of the grid.
 * @constraint all Ship objects placed on the grid must fit entirely within the
 *             defined dimensions.
 * @initially <br>
 *            constructor(): {@code ensures} all spaces of the grid are
 *            initialized as empty and unshot.
 * @author Group c421aa06
 */
public interface BattleGrid {

	/**
	 * Assigns positions in the grid to the specified Ship.
	 * 
	 * @requires 0 <= x <= 9 and 0 <= y <= 9
	 * @ensures A ship is set within the given position assuming no other ship
	 *          occupies those spaces.
	 * 
	 * @param ship
	 *            the Ship to place on the grid
	 * @param x
	 *            the x-coordinate of the position of the head of the Ship.
	 * @param y
	 *            the y-coordinate of the position of the head of the Ship.
	 * @param orient
	 *            the orientation of the Ship ({@code true} if oriented along
	 *            the x-axis, and {@code false} if along the y).
	 * 
	 */
	void setShipPos(Ship ship, int x, int y, boolean orient);

	/**
	 * Registers a shot at position x,y on the grid.
	 * 
	 * @requires 0 <= x <= 9 and 0 <= y <= 9
	 * 
	 * @param x
	 *            the x-coordinate of the position to shoot.
	 * @param y
	 *            the y-coordinate of the position to shoot.
	 * @return {@code HIT} if the shot hit a Ship, {@code SUNK} if it hit and
	 *         sunk a ship, and {@code MISS} otherwise.
	 */
	Ship.HitStatus shoot(int x, int y);

	/**
	 * Determines whether a grid position is viewable. A grid position is
	 * viewable if it has been shot.
	 * 
	 * @requires 0 <= x <= 9 and 0 <= y <= 9
	 * 
	 * @param x
	 *            the x-coordinate of the position to check for visibility.
	 * @param y
	 *            the y-coordinate of the position to check for visibility.
	 * @return {@code true} if the position is visible, and {@code false}
	 *         otherwise.
	 */
	boolean isViewable(int x, int y);

	/**
	 * Determines whether a grid position is associated with a Ship.
	 * 
	 * @requires 0 <= x <= 9 and 0 <= y <= 9
	 * 
	 * @param x
	 *            the x-coordinate of the position to check for a Ship.
	 * @param y
	 *            the y-coordinate of the position to check for a Ship.
	 * @return {@code true} if the position is associated with a Ship, and
	 *         {@code false} otherwise.
	 */
	boolean isShip(int x, int y);

	/**
	 * Retrieves the ShipType at the location x,y.
	 * 
	 * @requires isShip(x, y) is true.
	 * @param x
	 *            the x-coordinate of the space to check for the ShipType.
	 * @param y
	 *            the y-coordinate of the space to check for the ShipType.
	 * @return the ShipType of the ship located at the location x,y, or null if
	 *         no Ship is located at x,y.
	 */
	ShipType shipTypeAt(int x, int y);

	/**
	 * Checks for remaining, unsunk Ships on the grid.
	 * 
	 * @return true if there are unsunk Ships, or false if all Ships have been
	 *         sunk.
	 */
	boolean shipsRemaining();

	/**
	 * Checks to make sure that the specified coordinate is within the bounds of
	 * the board.
	 * 
	 * @param x
	 *            the x-coordinate of the position to check for a Ship.
	 * @param y
	 *            the y-coordinate of the position to check for a Ship.
	 * @return {@code true} if the position is within the grid space.
	 *         {@code false} if the position is outside the grid space.
	 */
	boolean boundsCheck(int x, int y);

	/**
	 * Returns the dimension of one side of the grid. Since the grid is square,
	 * both dimensions are equal.
	 * 
	 * @return the dimension of one side of the grid.
	 */
	int gridSize();

	/**
	 * Retrieves the Player associated with the BattleGrid.
	 * 
	 * @return the Player associated with the BattleGrid.
	 */
	Player getPlayer();

	/**
	 * This will set the player as either active or inactive when playing
	 * separate turns.
	 * 
	 * @ensures The player's state = state
	 * @param state
	 *            The state in which the player will assume, where {@code true}
	 *            = Active {@code false} = Inactive
	 */
	void setPlayerState(boolean state);

	/**
	 * Returns whether or not a player is active and taking their turn.
	 * 
	 * @return isActive {@code true} = Active {@code false} = Inactive
	 */
	boolean getPlayerState();
}
