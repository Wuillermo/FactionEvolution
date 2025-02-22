package game.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite grass2 = new Sprite(16, 3, 0, SpriteSheet.tiles);
    public static Sprite grass3 = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite grass4 = new Sprite(16, 5, 0, SpriteSheet.tiles);
    public static Sprite grass5 = new Sprite(16, 6, 0, SpriteSheet.tiles);
    public static Sprite water = new Sprite(16, 7, 0, SpriteSheet.tiles);

    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

    public static Sprite human_forward = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite human_right = new Sprite(32, 1, 5, SpriteSheet.tiles);
    public static Sprite human_back = new Sprite(32, 2, 5, SpriteSheet.tiles);
    public static Sprite human_left = new Sprite(32, 3, 5, SpriteSheet.tiles);

    public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);

    public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

    public static Sprite player_back_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    public static Sprite player_back_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color) {
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            pixels[i] = color;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
