package game.entity;

import game.input.Keyboard;

public class Camera extends Entity {

    private Keyboard input;

    public Camera (Keyboard input) {
        this.input = input;
    }

    public Camera (int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    @Override
    public void update() {
        if(input.up) y--;
        if(input.down) y++;
        if(input.left) x--;
        if(input.right) x++;
    }
}
