package game.entity.unit;

import game.entity.Entity;
import game.graphics.Sprite;

public abstract class Unit extends Entity {

    protected Sprite sprite;
    protected boolean moving = false;
    protected int dir = -1;
    /*
    * dir:
    * 0 = up
    * 1 = up right
    * 2 = right
    * 3 = down right
    * 4 = down
    * 5 = down left
    * 6 = left
    * 7 = up left
    * */

    public void move(int xa, int ya) {
        if(xa > 0) {
            if(ya > 0) dir = 1;
            else if(ya == 0) dir = 2;
            else dir = 3;
        } else if(x < 0) {
            if(ya > 0) dir = 7;
            else if(ya == 0) dir = 6;
            else dir = 5;
        }else {
            if(ya > 0) dir = 1;
            else if(ya < 0) dir = 4;
        }
    }

    public void update() {
    }

    public void render() {

    }
}
