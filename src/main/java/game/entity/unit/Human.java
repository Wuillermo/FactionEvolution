package game.entity.unit;

import game.graphics.Screen;
import game.graphics.Sprite;

public class Human extends Unit {

    public Human () {
    }

    public Human (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Screen screen) {
        screen.renderHuman(x, y, Sprite.human);
    }
}
