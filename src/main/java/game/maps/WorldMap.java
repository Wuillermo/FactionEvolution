package game.maps;

import game.graphics.Screen;
import game.maps.tiles.Tile;

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
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4; // >> 4 es lo mismo que / 16
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == 0) return Tile.grass;
        if (tiles[x + y * width] == 1) return Tile.flower;
        if (tiles[x + y * width] == 2) return Tile.rock;
        return Tile.voidTile;
    }
}
