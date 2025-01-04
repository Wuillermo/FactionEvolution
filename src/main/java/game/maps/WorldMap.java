package game.maps;

import game.graphics.Screen;

public class WorldMap {

    protected int width, height;
    protected int[] tiles;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new int[width * height];
        generateMap();
    }

    public WorldMap(String path) {
        loadLevel(path);
    }

    protected void generateMap() {

    }

    private void loadLevel(String path) {

    }

    public void update() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {

    }
}
