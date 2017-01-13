package ZombieSim.zombies;

import cs2113.util.DotPanel;
import cs2113.util.Helper;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;


/*
 * You must add a way to represent humans.  When there is not a zombie apocalypse occurring, humans
 * should follow these simple rules:
 * 		if (1 in 10 chance):
 * 			turn to face a random direction (up/down/left/right)
 * 		Move in the current direction one space if not blocked by a wall
 *
 * We will add additional rules for dealing with sighting or running into zombies later.
 */

public class ZombieSim extends JFrame implements KeyListener, ActionListener, MouseListener {
	City world;

	private static final long serialVersionUID = -5176170979783243427L;

	/** The Dot Panel object you will draw to */
	protected static DotPanel dp;

	/* Define constants using static final variables */
	public static final int MAX_X = 200;
	public static final int MAX_Y = 200;
	private static final int DOT_SIZE = 3;
	private static final int NUM_HUMANS = 200;
	private static final int NUM_BUILDINGS = 80;



	/*
	 * This fills the frame with a "DotPanel", a type of drawing canvas that
	 * allows you to easily draw squares to the screen.
	 */
	public ZombieSim() {
		this.addKeyListener(this);
		this.setSize(MAX_X * DOT_SIZE, MAX_Y * DOT_SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Braaiinnnnnsss");

		/* Create and set the size of the panel */
		dp = new DotPanel(MAX_X, MAX_Y, DOT_SIZE);
		dp.addMouseListener(this);

		/* Add the panel to the frame */
		Container cPane = this.getContentPane();
		cPane.add(dp);

		/* Initialize the DotPanel canvas:
		 * You CANNOT draw to the panel BEFORE this code is called.
		 * You CANNOT add new widgets to the frame AFTER this is called.
		 */
		this.pack();
		dp.init();
		dp.clear();
		dp.setPenColor(Color.red);
		this.setVisible(true);

		/* Create our city */
		this.world = new City(MAX_X, MAX_Y, NUM_BUILDINGS, NUM_HUMANS);


		/* This is the Run Loop (aka "simulation loop" or "game loop")
		 * It will loop forever, first updating the state of the world
		 * (e.g., having humans take a single step) and then it will
		 * draw the newly updated simulation. Since we don't want
		 * the simulation to run too fast for us to see, it will sleep
		 * after repainting the screen. Currently it sleeps for
		 * 33 milliseconds, so the program will update at about 30 frames
		 * per second.
		 */
		while(true)
		{
			// Run update rules for world and everything in it
			world.update();
			// Draw to screen and then refresh
			world.draw();
			dp.repaintAndSleep(33);

		}
	}


	public static void main(String[] args) {
		/* Create a new GUI window  */
		new ZombieSim();



	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) {
			System.out.println("Spacebar was pressed. Regenerating city...");
			world.clearCity();

		}
		if(keyCode == KeyEvent.VK_M) {
			System.out.println("M was pressed. Spawning medic...");
			for (int i = 0; i < 1000; i++) {
				int a = Helper.nextInt(world.width);
				int b = Helper.nextInt(world.height);
				if (!world.walls[a][b]) {
					Medic m = new Medic(a, b, Helper.nextInt(3));
					world.medics.add(m);
					break;
				}
			}
		}
	}

	public void keyReleased(KeyEvent e){
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent mouseEvent) {
		System.out.println("Clicked at screen coordinate: " + mouseEvent.getX() / DOT_SIZE + ", " + mouseEvent.getY() / DOT_SIZE);
		Zombie z = new Zombie(mouseEvent.getX()/DOT_SIZE, mouseEvent.getY() / DOT_SIZE, Helper.nextInt(3));
		world.zombies.add(z);
	}

	public void mouseReleased(MouseEvent mouseEvent){

	}

	public void mouseEntered(MouseEvent mouseEvent) {

	}
	public void mouseExited(MouseEvent mouseEvent) {

	}
	public void mousePressed(MouseEvent mouseEvent) {

	}
	public void actionPerformed(ActionEvent actionEvent) {

	}




}
