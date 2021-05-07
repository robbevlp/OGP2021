package pacman.wormholes;
import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * Elke instantie van deze klasse representeert een vertrekportaal in een wormhole-graaf.
 * @invar | getSquare() != null
 * @invar | getWormholes() != null
 * @invar | getWormholes().stream().allMatch(w -> w != null)  // && w.getDeparturePortal() == this)
 *
 */
public class DeparturePortal {
	
	/**
	 * @invar | square != null
	 */
	Square square;		// package-accessible (niet public)
	/**
	 *@invar | wormholes != null 
	 *@invar | wormholes.stream().allMatch(w -> w != null) // && w.departureportal() == this)
	 *
	 *@representationObject
	 *@peerObjects
	 */
	HashSet<Wormhole> wormholes = new HashSet<>();	
	
	
	/**
	 * @basic
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * @basic
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Wormhole> getWormholes() {
		return Set.copyOf(wormholes);
	}
	
	/**
	 * @throws | square.isPassable() == false
	 * @creates | this
	 * @post | getWormholes().isEmpty()
	 * @post | square != null 
	 */
	public DeparturePortal(Square square) {
		if (square.isPassable() == false) {
			throw new IllegalStateException("Square must be passable."); }
		this.square = square;
		
	}
	
	
//	/**
//	 * @throws IllegalArgumentException | wormhole == null
//	 * @mutates_porperties | getWormholes()
//	 * @post | getWormholes().stream().allMatch(w -> w != null)
//	 * 
//	 */
//	void addWormhole(Wormhole wormhole) {
//		if (wormhole == null) {
//			throw new IllegalArgumentException("wormhole is null");
//		}
//		wormholes.add(wormhole);
//		//TODO: bidirectionele associatie checken!
//	}
//	
	
//	/**
//	 * @throws IllegalArgumentException | square == null
//	 * @mutates_properties | getSquare()
//	 * @post | getSquare() == square
//	 */
//	public void setSquare(Square square) {
//		if (square == null) {
//			throw new IllegalArgumentException("square is null");
//		}
//		wormholes.remove(this);
//		this.square = square;
//				// TODO: bidirectionele associatie checken!
//	}
//	
	
	
}
