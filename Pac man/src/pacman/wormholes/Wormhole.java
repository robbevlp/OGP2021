package pacman.wormholes;

public class Wormhole {
	
	private DeparturePortal departureportal;
	private ArrivalPortal arrivalportal;
	
	
	public DeparturePortal getDeparturePortal() {
		return departureportal;
	}
	
	public ArrivalPortal getArrivalPortal() {
		return arrivalportal;
	}
	
	public Wormhole(DeparturePortal departureportal, ArrivalPortal arrivalportal) {
		
		this.departureportal = departureportal;
		this.arrivalportal = arrivalportal;
	}
	
	public void setDeparturePortal(DeparturePortal other) {
		// vorige portal moet deze wormhole uit zijn lijst verwijderen
		departureportal = other;
		departureportal.addWormhole(this);
	}
	
	public void setArrivalPortal(ArrivalPortal other) {
		// vorige portal moet deze wormhole uit zijn lijst verwijderen
		arrivalportal = other;
		arrivalportal.addWormhole(this);		
	}
}
