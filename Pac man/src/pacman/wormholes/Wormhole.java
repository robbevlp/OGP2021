package pacman.wormholes;

public class Wormhole {
	
	/**
	 * @peerObjects
	 * @representationObjects
	 * 
	 * @invar | departureportal != null
	 * @invar | arrivalportal != null
	 */
	private DeparturePortal departureportal;
	private ArrivalPortal arrivalportal;
	
	/**
	 * @basic
	 * @peerObject
	 * @inspects | this
	 * @post | result != null
	 */
	public DeparturePortal getDeparturePortal() {return departureportal;}
	
	/**
	 * @invar | getDeparturePortalInternal() != null
	 * @invar | getDeparturePortalInternal().getWormholesInternal().contains(this)
	 * 
	 * @peerObject
	 */
	DeparturePortal getDeparturePortalInternal() {return departureportal;}
	
	/**
	 * @basic
	 * @peerObject
	 * @inspects | this
	 * @post | result != null
	 */
	public ArrivalPortal getArrivalPortal() {return arrivalportal;}
	
	/**
	 * @invar | getArrivalPortalInternal() != null
	 * @invar | getArrivalPortalInternal().getWormholesInternal().contains(this)
	 * 
	 * @peerObject
	 */
	ArrivalPortal getArrivalPortalInternal() {return arrivalportal;}
	
	/**
	 * Initializes this object to represent a Wormhole with a departure and an arrival portal.
	 * 
	 * @post | getDeparturePortal() == dPortal
	 * @post | getArrivalPortal() == aPortal
	 * @post | dPortal.getWormholes().contains(this) && 
	 *       | aPortal.getWormholes().contains(this)
	 */
	public Wormhole(DeparturePortal dPortal, ArrivalPortal aPortal) {
		this.departureportal = dPortal;
		this.arrivalportal = aPortal;
		
		dPortal.addWormhole(this);
		aPortal.addWormhole(this);
	}
	
	/**
	 * @throws | other == null
	 * 
	 * @mutates_properties | getDeparturePortal().getWormholes(), 
	 * 					   | getDeparturePortal(), other.getWormholes()
	 * 
	 * @post | other.equals(old(this.getDeparturePortal())) ||
	 * 		 | old(this.getDeparturePortal()).getWormholes().contains(this) == false
	 * 
	 * @post | other.getWormholes().contains(this)
	 * @post | this.getDeparturePortal() == other
	 * 	 
	 */
	public void setDeparturePortal(DeparturePortal other) {
		if(other == null)
				throw new IllegalArgumentException("Other portal cannot be null.");
		
		this.getDeparturePortalInternal().removeWormhole(this);
		departureportal = other;
		departureportal.addWormhole(this);
		
		
	}
	
	/**
	 * @throws | other == null
	 * 
	 * @mutates_properties | getArrivalPortal().getWormholes(),
	 * 					   | getArrivalPortal(), other.getWormholes()
	 * 
	 * @post | other.equals(old(this.getArrivalPortal())) ||
	 * 		 | old(this.getArrivalPortal()).getWormholes().contains(this) == false
	 * 
	 * @post | other.getWormholes().contains(this)
	 * @post | this.getArrivalPortal() == other
	 * 	 
	 */
	public void setArrivalPortal(ArrivalPortal other) {
		if(other == null)
				throw new IllegalArgumentException("Other portal cannot be null.");
		
		this.getArrivalPortalInternal().removeWormhole(this);
		arrivalportal = other;
		arrivalportal.addWormhole(this);		
	}
}
