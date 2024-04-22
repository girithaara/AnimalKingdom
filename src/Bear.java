import java.awt.*;

// Creating Bear class by extending from Critters
public class Bear extends Critter {

    private Color bearColor;
    private int moves = 0;

    // Setting colors for the Bear according to type of Bear
    public Bear(Boolean polar) {
        if(polar) {
            bearColor = Color.WHITE;
        } else {
            bearColor = Color.BLACK;
        }
    }

// Overriding the string, color and move

    @Override
    public String toString() {
        if (moves % 2 == 0) {
            return "\\";
        } else {
            return "/";
        }
    }

    @Override
    public Color getColor() {
        return bearColor;
    }

    @Override
    public Action getMove(CritterInfo info) {

        moves++;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return super.getMove(info);
        }

    }
}