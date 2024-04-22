import java.awt.*;
import java.util.Random;

// Creating Tiger class by extending from Critters

public class Tiger extends Critter {

    // Setting colors for Tiger

    private Color tigerColor;
    private Color[] colorArray = {Color.RED, Color.GREEN, Color.BLUE};
    private Random randomColorNum = new Random();
    private int moves = 0;


    // Setting the initial color for Tiger and it will be picked from the colorArray created above

    public Tiger() {
        tigerColor = colorArray[randomColorNum.nextInt(3)];
    }

// Overriding the string, color and move so that I can define it according the Tiger's specification

    @Override
    public String toString() {
        return "TGR";
    }

    @Override
    public Color getColor() {

        if(moves > 3) {
            tigerColor = colorArray[randomColorNum.nextInt(3)];
            moves = 0;
        }

        return tigerColor;
    }

    @Override
    public Action getMove(CritterInfo info) {

        moves++;

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