package game.graphics;

import game.entity.unit.Human;
import game.maps.tiles.Tile;

import java.util.Arrays;
import java.util.Random;

public class Screen {

    public final int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;

    public int xOffset, yOffset;

    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        Random random = new Random();
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xa = x + xp;
                if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if(xa < 0) xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void renderHuman(int xp, int yp, Sprite sprite) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < 32; y++) {
            int ya = y + yp;
            for (int x = 0; x < 32; x++) {
                int xa = x + xp;
                if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
                if(xa < 0) xa = 0;
                int col = sprite.pixels[x + y * 32];
                if(col != 0xFFFF00FF) pixels[xa + ya * width] = col;
            }
        }
    }

    public void setOffset (int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
