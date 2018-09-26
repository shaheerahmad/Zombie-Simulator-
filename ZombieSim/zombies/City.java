package ZombieSim.zombies;
import java.util.*;

import ZombieSim.util.Helper;

import java.awt.Color;


public class City {

	/** walls is a 2D array with an entry for each space in the city.
	 *  If walls[x][y] is true, that means there is a wall in the space.
	 *  else the space is free. Humans should never go into spaces that
	 *  have a wall.
	 */
	public boolean walls[][];
	public int width, height;

	/*public boolean getWalls(){
		return walls;
	}*/
	ArrayList<Human> humans = new ArrayList<Human>();
	ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	ArrayList<Medic> medics = new ArrayList<Medic>();

	/**
	 * Create a new City and fill it with buildings and people.
	 * @param w width of city
	 * @param h height of city
	 * @param numB number of buildings
	 * @param numP number of people
	 */
	public City(int w, int h, int numB, int numP) {
		width = w;
		height = h;
		walls = new boolean[w][h];

		randomBuildings(numB);
		populate(numP);
		Zpopulate();
		Mpopulate();
	}


	/**
	 * Generates numPeople random people distributed throughout the city.
	 * People must not be placed inside walls!
	 *
	 * @param numPeople the number of people to generate
	 */
	private void populate(int numPeople)
	{
		// Generate numPeople new humans randomly placed around the city.

		for(int i = 0; i <= numPeople; i++){

			int a = Helper.nextInt(width);
			int b = Helper.nextInt(height);
			if (walls[a][b] == true){
				continue;
			}
			else {
				Human h = new Human(a, b, Helper.nextInt(3));
				humans.add(h);

			}
		}
	}
	private void Zpopulate(){
		//generate a zombie, randomly placed in the city
		for(int i = 0; i < 1000; i++){
			int a = Helper.nextInt(width);
			int b = Helper.nextInt(height);
			if(!walls[a][b]){
				Zombie z = new Zombie(a, b, Helper.nextInt(3));
				zombies.add(z);
				break;
			}
		}

	}

	private void Mpopulate(){
		//generate a few medics in the map to cure zombies
		int c = 0;
		for(int i = 0; i < 1000; i++){
			int a = Helper.nextInt(width);
			int b = Helper.nextInt(height);

			if(!walls[a][b]){
				Medic m = new Medic(a, b, Helper.nextInt(3));
				medics.add(m);
				c++;
				if(c > 3)
					break;
			}
		}

	}


	/**
	 * Generates a random set of numB buildings.
	 *
	 * @param numB the number of buildings to generate
	 */
	private void randomBuildings(int numB) {
		/* Create buildings of a reasonable size for this map */
		int bldgMaxSize = width/6;
		int bldgMinSize = width/50;

		/* Produce a bunch of random rectangles and fill in the walls array */
		for(int i=0; i < numB; i++) {
			int tx, ty, tw, th;
			tx = Helper.nextInt(width);
			ty = Helper.nextInt(height);
			tw = Helper.nextInt(bldgMaxSize) + bldgMinSize;
			th = Helper.nextInt(bldgMaxSize) + bldgMinSize;

			for(int r = ty; r < ty + th; r++) {
				if(r >= height)
					continue;
				for(int c = tx; c < tx + tw; c++) {
					if(c >= width)
						break;
					walls[c][r] = true;
				}
			}
		}
	}

	/**
	 * Updates the state of the city for a time step.
	 */
	public void update() {
		// Move humans, zombies, etc
		for(int i = 0; i < humans.size(); i++){
			humans.get(i).move(walls);
		}
		for(int j = 0; j < zombies.size(); j++){
			zombies.get(j).move(walls);
			zombies.get(j).infect(this);

		}
		for(int w = 0; w < medics.size(); w++){
			medics.get(w).move(walls);
			medics.get(w).heal(this);
		}


	}



	/**
	 * Draw the buildings and all humans.
	 */
	public void draw(){
		/* Clear the screen */
		ZombieSim.dp.clear(Color.black);
//		System.out.println(humans.get(0).xcoord + ""+humans.get(0).xcoord);
		drawWalls();
		update();
//		System.out.println(humans.get(0).xcoord + ""+humans.get(0).xcoord);
		ZombieSim.dp.setPenColor(Color.YELLOW);
		for(Human h: humans){
			ZombieSim.dp.drawDot(h.xcoord, h.ycoord);
		}
		ZombieSim.dp.setPenColor(Color.RED);
		for(Zombie z: zombies){
			ZombieSim.dp.drawDot(z.xcoord, z.ycoord);
		}
		ZombieSim.dp.setPenColor(Color.CYAN);
		for(Medic m: medics){
			ZombieSim.dp.drawDot(m.xcoord, m.ycoord);
		}





	}

	/**
	 * Draw the buildings.
	 * First set the color for drawing, then draw a dot at each space
	 * where there is a wall.
	 */
	private void drawWalls() {
		ZombieSim.dp.setPenColor(Color.DARK_GRAY);
		for(int r = 0; r < height; r++)
		{
			for(int c = 0; c < width; c++)
			{
				if(walls[c][r])
				{
					ZombieSim.dp.drawDot(c, r);
				}
			}
		}
	}

	public void clearCity(){
		/* Clear the screen */
		boolean clearWalls[][] = new boolean[width][height];
		ZombieSim.dp.clear(Color.black);
		walls = clearWalls;
		randomBuildings(80);
		humans.clear();
		populate(200);
		zombies.clear();
		Zpopulate();
		medics.clear();
		Mpopulate();
	}

}

