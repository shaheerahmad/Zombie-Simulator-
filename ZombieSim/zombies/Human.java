package cs2113.zombies;
import java.util.*;
import cs2113.util.Helper;

/**
 * Created by shaheerahmad on 11/10/16.
 */
public class Human {
    int xcoord;
    int ycoord;
    int direction;
    ArrayList<Human> humans = new ArrayList<Human>();

    public Human(int xcoord, int ycoord, int direction) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.direction = direction;
    }

    // MOVE FUNCTION
    public void move(boolean walls[][]) {

        if (Helper.nextInt(9) == 0) {
            if (Helper.nextInt(3) == 0) {
                //if out of bounds
                if (this.ycoord <= 0) {
                    this.ycoord++;
                    direction = 1;
                }

                if(this.ycoord - 1 <= 0 || walls[this.xcoord][this.ycoord - 1]){
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

                //move up
                else {
                    this.ycoord++;
                    direction = 1;
                }
            }
            if (Helper.nextInt(3) == 2) {
                //if out of bounds

                if (this.xcoord <= 0) {
                    this.xcoord++;
                    direction = 3;
                }

                if(this.xcoord - 1 <= 0 || walls[this.xcoord - 1][this.ycoord]){
                    this.xcoord++;
                    direction = 3;
                }

                //move left
                else {
                    this.xcoord--;
                    direction = 2;
                }
            }
            if (Helper.nextInt(3) == 3) {
                //if out of bounds

                if (this.xcoord >= 200) {
                    this.xcoord--;
                    direction = 2;
                }

                //move right
                //if wall is present
                if (this.xcoord + 1 >= 200 || walls[this.xcoord + 1][this.ycoord] == true) {
                    this.xcoord--;
                    direction = 2;
                }

                else {
                    this.xcoord++;
                    direction = 3;
                }
            }
        } else {
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

                    //moving up
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

                //move down
                else{
                    this.ycoord++;
                    direction = 1;
                }
            }
            if (direction == 2) {
                //if out of bounds

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
                //if out of bounds

                if (this.xcoord >= 200) {
                    this.xcoord--;
                    direction = 2;
                }

                //if wall is present
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


