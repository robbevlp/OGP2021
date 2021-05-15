package pacman;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class Maze {
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] foodItems;
	private ArrivalPortal[] arrivalPortals;
	private DeparturePortal[] departurePortals;
	private Wormhole[] wormholes;
	
	
	public MazeMap getMap() { return map; }
	
	public ArrivalPortal[] getArrivalPortals() {
		return arrivalPortals.clone();
	}
	
	public DeparturePortal[] getDeparturePortals() {
		return departurePortals.clone();
	}
	
	public void addWormhole(Wormhole wormhole) {
		boolean Arrival = false;
		for (int i = 0; i < arrivalPortals.length; i++) {
			if (wormhole.getArrivalPortal().equals(arrivalPortals[i])){Arrival = true;}
		}
		
		boolean Departure = false;
		for (int j = 0; j < departurePortals.length; j++) {
			if(wormhole.getDeparturePortal().equals(departurePortals[j])) {Departure = true;}
		}
		
		if (Departure == true && Arrival == true) {
			Wormhole[] Holes = Arrays.copyOf(wormholes, wormholes.length + 1);
			Holes[wormholes.length] = wormhole;
			this.wormholes = Holes;
		}
	}
	
	public Wormhole[]	getWormholes() {
		return wormholes.clone();
	}
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return foodItems.clone(); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] newFoodItems, ArrivalPortal[] newArrivalPortals, DeparturePortal[] newDeparturePortals) {
		
		for(int j = 0 ; j <= newArrivalPortals.length - 2; j++) {
			if (newArrivalPortals[j].checkOrder(newArrivalPortals[j + 1]) == false)
				throw new IllegalArgumentException("newArrivalPortals[] must be sorted from from left to right and top to bottom.");
		}
		
		for(int i = 0 ; i <= newDeparturePortals.length - 2; i++) {
			if (newDeparturePortals[i].checkOrder(newDeparturePortals[i + 1]) == false)
				throw new IllegalArgumentException("newDeparturePortals[] must be sorted from from left to right and top to bottom.");
		}
		
		this.random = random;
		this.map = map;
		map.setMaze(this);
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = newFoodItems.clone();
		this.departurePortals = newDeparturePortals.clone();
		this.arrivalPortals = newArrivalPortals.clone();
	}
	
	public boolean isCompleted() {
		boolean completed = true;
		for(FoodItem item : foodItems) {
			if(item instanceof Dot) {completed = false;}
		}
		return completed;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
			
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	private void removeFoodItemAtIndex(int index) {
		if (foodItems[index] instanceof PowerPellet) {for (Ghost ghost : ghosts) {ghost.pacManAtePowerPellet(); }}
		FoodItem[] newFoodItems = new FoodItem[foodItems.length - 1];
		System.arraycopy(foodItems, 0, newFoodItems, 0, index);
		System.arraycopy(foodItems, index + 1, newFoodItems, index, newFoodItems.length - index);
		foodItems = newFoodItems;
	}
	
	private void removeDotAtSquare(Square square) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i].getSquare().equals(square)) {
				removeFoodItemAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			checkPacManDamage();
			
			for (DeparturePortal portal : departurePortals) {
				if (portal.getSquare().equals(newSquare)) {
					checkPacManDamage();
					int N = random.nextInt(portal.getWormholes().size());
					int i = 0;
					for (Wormhole wormhole: wormholes) {
						if (i == N) {newSquare = wormhole.getArrivalPortal().getSquare();}
						i++;
					}	
				}
			}
			
			pacMan.setSquare(newSquare);
			removeDotAtSquare(newSquare);
			checkPacManDamage();
		}
	}
	
}
