import java.awt.*;

// Creating NinjaCat class by extending from Critters

public class NinjaCat extends Critter {

    // Creating a boolean to define if NinjaCat is infected or not

    private boolean infected;
    public NinjaCat(){
        infected=false;
    }

    // Setting color for NinjaCat, if it is infected it will be in CYAN, if it is not it will be in YELLOW

    public Color getColor() {
        if(infected){
            return Color.cyan;
        } else {
            return Color.yellow;
        }

    }
    private int moves = 0;

    // Setting the String for NinjaCat, if it is infected it will be in "NC", if it is not it will be in "nc"

    public String toString() {
        if(infected){
            return "NC";
        } else {
            return "nc";
        }

    }

// Overriding the string, color and move so that I can define it according the Ninja Cat's specification

    @Override
    public Action getMove(CritterInfo info) {

        moves++;
// Following WhiteTiger's movement
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL && info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }
}