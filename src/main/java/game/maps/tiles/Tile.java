package game.maps.tiles;

import game.graphics.Screen;
import game.graphics.Sprite;

public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile grass2 = new GrassTile(Sprite.grass2);
    public static Tile grass3 = new GrassTile(Sprite.grass3);
    public static Tile grass4 = new GrassTile(Sprite.grass4);
    public static Tile grass5 = new GrassTile(Sprite.grass5);
    public static Tile water = new GrassTile(Sprite.water);

    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
}
