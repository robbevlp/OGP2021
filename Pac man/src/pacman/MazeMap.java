package pacman;

import java.util.stream.IntStream;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 * 
 * @immutable
 */
public class MazeMap {
	/**
	 * @invar | width >= 1
	 * 
	 * @invar | height >= 1
	 * 
	 * @invar | passable != null
	 * @invar | passable.length == width * height
	 * @invar | IntStream.range(0, passable.length).allMatch(i -> passable[i] == false || passable[i] == true)
	 */
	private int width;
	private int height;
	private boolean[] passable;
	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * @basic
	 * @inspects | this
	 */
	public int getWidth() { return width; }
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @basic
	 * @inspects | this
	 */
	public int getHeight() { return height; }
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * 
	 * @throws | rowIndex < 0 || rowIndex > (this.getHeight() - 1)
	 * @throws | columnIndex < 0 || columnIndex > (this.getWidth() - 1)
	 * 
	 * @returns | result
	 * @post | result == false || result == true
	 */
	// passable = [(0,0),(1,0), ..., (ColumnIndex,0), (0,1), ..., (0, Rowindex), ..., (ColumnIndex,RowIndex)]
	public boolean isPassable(int rowIndex, int columnIndex) { 
		if(rowIndex < 0 || rowIndex > (this.getHeight() - 1)) {throw new IllegalStateException("rowIndex out of range."); }
		if(columnIndex < 0 || columnIndex > (this.getWidth() - 1)) {throw new IllegalStateException("columnIndex out of range."); }
		
		int index = rowIndex * width + columnIndex;
		return passable[index];
	}
	
	/**
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * 
	 * @throws | width < 0 
	 * @throws | height < 0
	 * @throws | passable == null
	 * @throws | passable.length != height * width
	 * @throws | IntStream.range(0, passable.length).allMatch(i -> passable[i] == false || passable[i] == true)
	 * 
	 * @return | result
	 * @post | this.getWidth() == width
	 * @post | this.getHeight() == height
	 * @post | IntStream.range(0, this.getHeight()).allMatch(rowIndex ->
	 * 		 |    	IntStream.range(0,this.getWidth()).allMatch(columnIndex ->
	 * 		 | 			passable[rowIndex * width + columnIndex] == this.isPassable(rowIndex, columnIndex)))
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if (width < 0) {throw new IllegalStateException("width must be positive."); }
		if (height < 0) {throw new IllegalStateException("height must be positive."); }
		if (passable == null || passable.length != height * width) {throw new IllegalStateException("Passable has wrong dimensions."); }
		if (IntStream.range(0, passable.length).anyMatch(i -> passable[i] != false && passable[i] != true)){throw new IllegalStateException("No elements of passable may be null."); }
		
		this.width = width;
		this.height = height;
		this.passable = passable;
	}

	public boolean equals(MazeMap other) {
		if (other.getWidth() != width || other.getHeight() != height) {return false;}
		for (int row = 0; row < height; row ++) {
			for (int column = 0; column < width; column++) {
				if(this.isPassable(row, column) != other.isPassable(row, column)) {return false;}
			}
		}
		
		return true;
	}
	
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
		if(rowIndex < 0 || rowIndex >= mazeMap.getHeight()) {throw new IllegalStateException("row is out of range."); }
		if(columnIndex < 0 || columnIndex >= mazeMap.getWidth()) {throw new IllegalStateException("column is out of range"); }
		boolean passable = mazeMap.isPassable(rowIndex, columnIndex);
		return new Square(rowIndex, columnIndex, passable, mazeMap);
	}	
}