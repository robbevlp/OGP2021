package pacman;
import java.util.ArrayList;

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
	 * @invar | passable == true || passable == false
	 */
	private int row;
	private int column;
	private boolean passable;
	private MazeMap mazemap; 
	
	
	/**
	 * Already covered with method: Square of()
	 */
	public Square(int row, int column, boolean passable, MazeMap mazeMap) {
		this.row = row;
		this.column = column;
		this.passable = passable;
		this.mazemap = mazeMap;
	}
	
	/**
	 * @inspects | this
	 * @basic
	 * @post | result != null
	 */
	public MazeMap getMazeMap() { return mazemap; }
	/**
	 * @inspects | this
	 * @basic
	 * @post | result >= 0
	 */
	public int getRowIndex() { return row; }
	/**
	 * @inspects | this
	 * @basic
	 * @post | result >= 0
	 */
	public int getColumnIndex() { return column; }
	/**
	 * @inspects | this
	 * @basic
	 * @post | result == true || result == false
	 */
	public boolean isPassable() { return passable; }
	
	/**
	 * @throws | rowIndex < 0 || rowIndex >= mazeMap.getHeight()
	 * @throws | columnIndex < 0 || columnIndex >= mazeMap.getWidth()
	 * 
	 * @inspects | mazeMap
	 * 	
	 * @return | result
	 * @post | result.getRowIndex() == rowIndex
	 * @post | result.getColumnIndex() == columnIndex
	 * @post | result.getMazeMap() == mazeMap
	 * @post | result.isPassable() == mazeMap.isPassable(rowIndex, columnIndex)
	 */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (columnIndex < 0 || columnIndex >= mazeMap.getWidth()) {throw new IllegalStateException("ColumnIndex out of range."); }
		if (rowIndex < 0 || rowIndex >= mazeMap.getHeight()) {throw new IllegalStateException("RowIndex out of range."); }
		
		boolean result = mazeMap.isPassable(rowIndex, columnIndex);
		return new Square(rowIndex, columnIndex, result, mazeMap);
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
			columnIndex = column;
			if (this.row == 0) {rowIndex = mazemap.getHeight() - 1; } else {rowIndex = row - 1; }
			break;
		case DOWN:
			columnIndex = column;
			if (this.row == mazemap.getHeight() - 1) {rowIndex = 0; } else {rowIndex = row + 1; }
			break;
		case RIGHT:
			rowIndex = row;
			if (this.column == mazemap.getWidth() - 1) {columnIndex = 0; } else {columnIndex = column + 1; }
			break;
		case LEFT:
			rowIndex = row;
			if (this.column == 0) {columnIndex = mazemap.getWidth() - 1; } else {columnIndex = column - 1; }
		}
		
		return of(mazemap, rowIndex, columnIndex);
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
	 * @throws | other == null
	 * 
	 * @inspects | this
	 * @inspects | other
	 * 
	 * @return | result
	 * @post | result == true || result == false
	 */
	public boolean equals(Square other) {
		if (other == null) {throw new IllegalStateException("The second square cannot be null."); }
		if(other.getRowIndex() != row) {return false; }
		if(other.getColumnIndex() != column) {return false; }
		if(other.isPassable() != passable){return false; }
		if(other.getMazeMap().equals(mazemap) == false) {return false; }
		
		return true;
	}
	
}
