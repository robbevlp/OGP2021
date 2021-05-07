package pacman.wormholes;

public class Wormhole {
	
	DeparturePortal departureportal;
	ArrivalPortal arrivalportal;
	
	
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
		departureportal = other;
		departureportal.wormholes.add(this);	//TODO: bidirectionele associatie correct?
	}
	
	public void setArrivalPortal(ArrivalPortal other) {
		arrivalportal = other;
		arrivalportal.wormholes.add(this);		//TODO: idem
	}
}
