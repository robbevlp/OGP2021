package pacman;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 */
public class MazeMap {
	private int width;
	private int height;
	private boolean[] passable;
	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 */
	public int getWidth() { return width; }
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 */
	public int getHeight() { return height; }
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 */
	
	// passable = [(0,0),(1,0), ..., (ColumnIndex,0), (0,1), ..., (0, Rowindex), ..., (ColumnIndex,RowIndex)]
	public boolean isPassable(int rowIndex, int columnIndex) { 
		int result = rowIndex * width + columnIndex;
		return passable[result];
	}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		this.width = width;
		this.height = height;
		this.passable = passable;
	}
}



public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
	boolean result = new Boolean(mazeMap.isPassable(rowIndex, columnIndex));
}
