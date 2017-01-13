package cs2113.zombies;
import java.util.*;
import cs2113.util.Helper;

/**
 * Created by shaheerahmad on 11/18/16.
 */
public class Zombie {
    int xcoord;
    int ycoord;
    int direction;
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Human> humans = new ArrayList<Human>();
    ArrayList<Human> tempH = new ArrayList<Human>();
    Human h;


    public Zombie(int xcoord, int ycoord, int direction){
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.direction = direction;
    }

    public void infect(City c){
       // System.out.println(c.humans.size());
       // System.out.println(c.zombies.size());
        for(int i = 0; i < c.humans.size(); i++) {

            if (this.xcoord + 1 == c.humans.get(i).xcoord && this.ycoord == c.humans.get(i).ycoord) {
                Zombie z = new Zombie(c.humans.get(i).xcoord, c.humans.get(i).ycoord, Helper.nextInt(3));
                c.zombies.add(z);
                tempH.add(c.humans.get(i));
            }
            if (this.xcoord - 1 == c.humans.get(i).xcoord && this.ycoord == c.humans.get(i).ycoord) {
                Zombie z = new Zombie(c.humans.get(i).xcoord, c.humans.get(i).ycoord, Helper.nextInt(3));
                c.zombies.add(z);
                tempH.add(c.humans.get(i));
            }
            if (this.ycoord + 1 == c.humans.get(i).ycoord && this.xcoord == c.humans.get(i).xcoord) {
                Zombie z = new Zombie(c.humans.get(i).xcoord, c.humans.get(i).ycoord, Helper.nextInt(3));
                c.zombies.add(z);
                tempH.add(c.humans.get(i));
            }
            if (this.ycoord - 1 == c.humans.get(i).ycoord && this.xcoord == c.humans.get(i).xcoord) {
                Zombie z = new Zombie(c.humans.get(i).xcoord, c.humans.get(i).ycoord, Helper.nextInt(3));
                c.zombies.add(z);
                tempH.add(c.humans.get(i));
            }
            if (this.ycoord == c.humans.get(i).ycoord && this.xcoord == c.humans.get(i).xcoord){
                Zombie z = new Zombie(c.humans.get(i).xcoord, c.humans.get(i).ycoord, Helper.nextInt(3));
                c.zombies.add(z);
                tempH.add(c.humans.get(i));
            }
            for(Human h: tempH){
                c.humans.remove(h);
            }
            //tempH.clear();
        }

    }

    public void move(boolean walls[][]) {
        if (Helper.nextInt(4) == 0) {
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
