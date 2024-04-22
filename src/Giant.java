import java.awt.*;

// Creating Giant class by extending from Critters
public class Giant extends Critter {

    // Setting colors, string and the moves for Giant
    private Color giantColor;
    private String[] giantMessage = {"fee", "fie", "foe", "fum"};
    private int moves = 0, message = 0;

    // Defining the color for Giant

    public Giant() {
        giantColor = Color.GRAY;
    }

// Overriding the string, color and move so that I can define it according the Giant's specification

    @Override
    public String toString() {

        if(moves == 6) {
            moves = 0;

            if(message == 3) {
                message = 0;
            } else {
                message ++;
            }
        }

        return giantMessage[message];

    }

    @Override
    public Color getColor() {
        return giantColor;
    }

    @Override
    public Action getMove(CritterInfo info) {

        moves++;

        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }

    }
}