package game.entity;

import game.graphics.Screen;
import game.maps.WorldMap;

import java.util.Random;

public abstract class Entity {

    public int x, y;
    private boolean removed = false;
    protected WorldMap worldMap;
    protected  final Random random = new Random();

    public void update() {
    }

    public void render (Screen screen) {
    }

    public void remove() {
        // Remove from map
    }

    public boolean isRemoved() {
        return removed;
    }
}
