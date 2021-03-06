package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * Elke instantie van deze klasse representeert een aankomst portaal in een wormhole-graaf.
 */
public class ArrivalPortal {
	
	/**
	 * @peerObject
	 * @representationObject
	 * 
	 * @invar | square != null
	 * @invar | square.isPassable() == true
	 */
	private Square square;
	
	/**
	 * @peerObjects
	 * 
	 * @invar | wormholes != null
	 * @invar | wormholes.isEmpty() || wormholes.stream().allMatch(w -> w != null)
	 */
	private HashSet<Wormhole> wormholes = new HashSet<>();
	
	/**
	 * This method returns the square of this portal.
	 * 
	 * @peerObject
	 * @inspects | this
	 * 
	 * @post | result != null
	 * @post | result.isPassable() == true
	 */
	public Square getSquare() {return square;}
	
	/**
	 * @invar | getWormholesInternal().isEmpty() ||
	 * 		  | getWormholesInternal().stream().allMatch(w -> w != null && w.getArrivalPortalInternal() == this)
	 * 
	 * @peerObjects
	 * @inspects | this
	 */
	Set<Wormhole> getWormholesInternal(){return Set.copyOf(wormholes);}
	
	/**
	 * Returns a set of Wormholes connected to this portal.
	 * 
	 * @peerObjects
	 * 
	 * @creates | result
	 * 
	 * @post | result != null
	 * @post | result.isEmpty() || result.stream().allMatch(w -> w != null) 
	 */
	public Set<Wormhole> getWormholes() {
		return Set.copyOf(wormholes);
	}
	
	/**
	 * Initializes this object to represent an arrival portal with a single passable square.
	 * 
	 * @throws | square == null
	 * @throws | square.isPassable() == false
	 * 
	 * @post | getWormholes().isEmpty()
	 * @post | getSquare() != null 
	 * @post | square.isPassable() == true
	 */
	public ArrivalPortal(Square square) {
		if (square == null)
			throw new IllegalArgumentException("Square must no be null.");
		if (square.isPassable() == false) 
			throw new IllegalArgumentException("Square must be passable.");
		this.square = square;
	}
	
	/**
	 * This method adds one given wormhole to the list of wormholes of this portal.
	 * 
	 * @inspects | this
	 * 
	 * @throws | wormhole == null
	 * 
	 * @mutates_porperties | getWormholes()
	 * 
	 * @post | getWormholes().contains(wormhole)
	 */
	void addWormhole(Wormhole wormhole) {
		if (wormhole == null) {
			throw new IllegalArgumentException("wormhole is null.");}
		this.wormholes.add(wormhole); 
	}
	
	/**
	 * This method removes one given wormhole from the list of wormholes of this portal.
	 * 
	 * @inspects | this
	 * 
	 * @throws | wormhole == null
	 * @throws | getWormholesInternal().contains(wormhole) == false
	 * 
	 * @mutates_properties | getWormholes()
	 * 
	 * @post | getWormholesInternal().contains(wormhole) == false
	 */
	void removeWormhole(Wormhole wormhole) {
		if (wormhole == null) 
			throw new IllegalArgumentException("Wormhole cannot be null.");
		if (wormholes.contains(wormhole) == false)
			throw new IllegalArgumentException("Wormhole must be connected to this portal.");
		wormholes.remove(wormhole);
	}

	/**
	 * @throws | portal == null
	 * 
	 * if the square from the other ArrivalPortal is more to the top or to the left on the same row returns false.
	 * if the square from the other portal is more to the bottom or on the same row but more to the right returns true.
	 * 
	 * @inspects | this, portal
	 */
	public boolean checkOrder(ArrivalPortal portal) {
		if (portal == null)
			throw new IllegalArgumentException("Portal cannot be null.");
		
		boolean order = false;
		
		int row0 = this.getSquare().getRowIndex();
		int column0 = this.getSquare().getColumnIndex();
		
		int row1 = portal.getSquare().getRowIndex();
		int column1 = portal.getSquare().getColumnIndex();
		
		if (row1 - row0 > 0 || row1 - row0 == 0 && column1 - column0 > 0) 
			order = true;
		
		return order;
	}
	
}
