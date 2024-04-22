import java.awt.*;

// Creating White Tiger class by extending from Critters

public class WhiteTiger extends Critter {

    // Creating a boolean to define if WhiteTiger is infected or not
    private boolean infected;
    public WhiteTiger(){
        infected=false;
    }
    public Color getColor(){
        return Color.WHITE;
    }
    private int moves = 0;



// Overriding the string, color and move so that I can define it according the WhiteTiger's specification

    @Override
    // defining string with if else statement, "tgr" if hasn't infected others, "TGR" if it has infected others
    public String toString(){
        if(infected==true){
            return "TGR";
        }
        else{
            return "tgr";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {

        moves++;

        if(info.getFront()==Neighbor.OTHER){
            infected=true;
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