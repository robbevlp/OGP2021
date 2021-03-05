package pacman;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 *
 * @immutable
 */
 public class Square {
	/**
	 * Omdat integers en booleans immutable zijn, moeten we geen kopie weggeven bij de getters, ondanks @immutable.
	 * @invar | 0 <= row
	 * @invar | 0 <= column
	 * @invar | new Boolean(passable) != null
	 */
	private int row;
	private int column;
	private boolean passable;
	private static MazeMap mazemap;
	
	
	/**
	 * Already covered with method: Square of()
	 */
	private Square(int row, int column, boolean passable, MazeMap mazeMap) {
		this.row = row;
		this.column = column;
		this.passable = passable;
		this.mazemap = mazeMap;
	}
	
	/**
	 * @inspects | this
	 * @basic
	 */
	public MazeMap getMazeMap() { return mazemap; }
	/**
	 * @inspects | this
	 * @basic
	 */
	public int getRowIndex() { return row; }
	/**
	 * @inspects | this
	 * @basic
	 */
	public int getColumnIndex() { return column; }
	/**
	 * @inspects | this
	 * @basic
	 */
	public boolean isPassable() { return passable; }
	
	/**
	 * @pre | rowIndex <= (mazeMap.getHeight() - 1) && rowIndex <= 0
	 * @pre | columnIndex <= (mazeMap.getWidth() - 1) && columnIndex <= 0
	 * 
	 * @inspects | mazeMap
	 * 
	 * @return | result
	 * @post | result.getRowIndex() == rowIndex
	 * @post | result.getColumnIndex() == columnIndex
	 * @post | result.getMazeMap() == mazeMap
	 * @post | new Boolean(result.isPassable()) == new Boolean(mazeMap.isPassable(rowIndex, columnIndex))
	 * 
	 */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		boolean result = new Boolean(mazeMap.isPassable(rowIndex, columnIndex));
		return new Square(rowIndex, columnIndex, result, mazemap);
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		int rowIndex = 0;
		int columnIndex = 0;
		
		switch(direction) {
		case UP:
			rowIndex = row;
			if (this.row == 0) {rowIndex = mazemap.getHeight() - 1; } else {rowIndex = row - 1; }
			break;
		case DOWN:
			columnIndex = column;
			if (this.row == mazemap.getHeight() - 1) {rowIndex = 0; } else {rowIndex = row + 1; }
			break;
		case RIGHT:
			columnIndex = column;
			if (this.column == mazemap.getWidth() - 1) {columnIndex = 0; } else {columnIndex = column + 1; }
			break;
		case LEFT:
			rowIndex = row;
			if (this.column == 0) {columnIndex = mazemap.getWidth() - 1; } else {columnIndex = row - 1; }
		}
		
		return this.of(mazemap, rowIndex, columnIndex);
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		return this.getNeighbor(direction).isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		ArrayList<Direction> List = new ArrayList<Direction>();
		
		ArrayList<Direction> directions = new ArrayList<Direction>();
		directions.add(Direction.UP); directions.add(Direction.RIGHT); directions.add(Direction.DOWN); directions.add(Direction.LEFT);
		
		for(Direction direction:directions) {
			if(direction != excludedDirection) {
				if(this.canMove(direction)) {List.add(direction); }
			}
		}
		
		Direction[] array = new Direction[List.size()];
		int i = 0;
		for(Direction direction:List) {
			array[i] = direction;
			i ++;
		}
		
		return array;
		
	}
	
	/**
	 * @pre | other != null
	 * @inspects | this
	 * @inspects | other
	 * 
	 * @return | result
	 * @post | result == true || result == false
	 */
	public boolean equals(Square other) {
		if (other.getRowIndex() != row || other.getColumnIndex() != column || other.isPassable() != passable || other.getMazeMap() != mazemap) {return false; } else {return true; }
		
		
	}
	
}
