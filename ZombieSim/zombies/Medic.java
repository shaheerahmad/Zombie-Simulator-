package cs2113.zombies;
import java.util.*;
import cs2113.util.Helper;


/**
 * Created by shaheerahmad on 11/20/16.
 */
public class Medic {
    int xcoord;
    int ycoord;
    int direction;
    //ArrayList<Zombie> zombies = new ArrayList<Zombie>();
   // ArrayList<Human> zombies = new ArrayList<Human>();
    ArrayList<Zombie> tempH = new ArrayList<Zombie>();
    Zombie z;

    public Medic(int xcoord, int ycoord, int direction){
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.direction = direction;
    }

    public void heal(City c){
        for(int i = 0; i < c.zombies.size(); i++) {

            if (this.xcoord + 1 == c.zombies.get(i).xcoord && this.ycoord == c.zombies.get(i).ycoord) {
                Human h = new Human(c.zombies.get(i).xcoord, c.zombies.get(i).ycoord, Helper.nextInt(3));
                c.humans.add(h);
                tempH.add(c.zombies.get(i));
            }
            if (this.xcoord - 1 == c.zombies.get(i).xcoord && this.ycoord == c.zombies.get(i).ycoord) {
                Human h = new Human(c.zombies.get(i).xcoord, c.zombies.get(i).ycoord, Helper.nextInt(3));
                c.humans.add(h);
                tempH.add(c.zombies.get(i));
            }
            if (this.ycoord + 1 == c.zombies.get(i).ycoord && this.xcoord == c.zombies.get(i).xcoord) {
                Human h = new Human(c.zombies.get(i).xcoord, c.zombies.get(i).ycoord, Helper.nextInt(3));
                c.humans.add(h);
                tempH.add(c.zombies.get(i));
            }
            if (this.ycoord - 1 == c.zombies.get(i).ycoord && this.xcoord == c.zombies.get(i).xcoord) {
                Human h = new Human(c.zombies.get(i).xcoord, c.zombies.get(i).ycoord, Helper.nextInt(3));
                c.humans.add(h);
                tempH.add(c.zombies.get(i));
            }
            if (this.ycoord == c.zombies.get(i).ycoord && this.xcoord == c.zombies.get(i).xcoord){
                Human h = new Human(c.zombies.get(i).xcoord, c.zombies.get(i).ycoord, Helper.nextInt(3));
                c.humans.add(h);
                tempH.add(c.zombies.get(i));
            }
            for(Zombie z: tempH){
                c.zombies.remove(z);
            }

        }
    }

    public void move(boolean walls[][]) {
        if (Helper.nextInt(9) == 0) {
            if (Helper.nextInt(3) == 0) {
                //if out of bounds
                if (this.ycoord <= 0) {
                    this.ycoord++;
                    direction = 1;
                }

                if (this.ycoord - 1 <= 0 || walls[this.xcoord][this.ycoord - 1]) {
                    this.ycoord++;
                    direction = 1;
                }
                //move down
                else {
                    this.ycoord--;
                    direction = 0;
                }
            }

            if (Helper.nextInt(3) == 1) {
                if (this.ycoord >= 200) {
                    this.ycoord--;
                    direction = 0;
                }
                if(this.ycoord + 1 >= 200 || walls[this.xcoord][this.ycoord + 1]){
                    this.ycoord--;
                    direction = 0;
                }
                else {
                    this.ycoord++;
                    direction = 1;
                }
            }

            if (Helper.nextInt(3) == 2) {
                if (this.xcoord <= 0) {
                    this.xcoord++;
                    direction = 3;
                }
                if(this.xcoord - 1 <= 0 || walls[this.xcoord - 1][this.ycoord]){
                    this.xcoord++;
                    direction = 3;
                }
                else {
                    this.xcoord--;
                    direction = 2;
                }
            }

            if (Helper.nextInt(3) == 3) {
                if (this.xcoord >= 200) {
                    this.xcoord--;
                    direction = 2;
                }
                if (this.xcoord + 1 >= 200 || walls[this.xcoord + 1][this.ycoord] == true) {
                    this.xcoord--;
                    direction = 2;
                }
                else {
                    this.xcoord++;
                    direction = 3;
                }
            }

        }
        else{
            //keep moving in same direction
            if (direction == 0) {
                //if out of bounds
                if (this.ycoord <= 0) {
                    this.ycoord++;
                    direction = 1;
                }
                if(this.ycoord - 1 <= 0 || walls[this.xcoord][this.ycoord - 1]){
                    this.ycoord++;
                    direction = 1;
                }
                else {
                    this.ycoord--;
                    direction = 0;
                }
            }
            if (direction == 1) {
                if (this.ycoord >= 200) {
                    this.ycoord--;
                    direction = 0;
                }
                if(this.ycoord + 1 >= 200 || walls[this.xcoord][this.ycoord + 1]){
                    this.ycoord--;
                    direction = 0;
                }
                else{
                    this.ycoord++;
                    direction = 1;
                }
            }
            if (direction == 2) {
                if (this.xcoord <= 0) {
                    this.xcoord++;
                    direction = 3;
                }
                if (this.xcoord - 1 <= 0 || walls[this.xcoord - 1][this.ycoord]) {
                    this.xcoord++;
                    direction = 3;
                }
                else {
                    this.xcoord--;
                    direction = 2;
                }
            }
            if (direction == 3) {
                if (this.xcoord >= 200) {
                    this.xcoord--;
                    direction = 2;
                }
                if (this.xcoord + 1 >= 200 || walls[this.xcoord + 1][this.ycoord] == true) {
                    this.xcoord--;
                    direction = 2;
                }
                else {
                    this.xcoord++;
                    direction = 3;
                }
            }
        }
    }
}
