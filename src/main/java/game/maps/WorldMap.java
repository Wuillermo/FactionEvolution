package game.maps;

import game.graphics.Screen;
import game.maps.Tiles.Tile;

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
        int x0 = xScroll >> 4; // >> 4 es lo mismo que / 16
        int x1 = (xScroll + screen.width) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height) >> 4;
    }

    public Tile getTile(int x, int y) {
        if (tiles[x + y * width] == 0) return Tile.grass;
        return null;
    }
}
