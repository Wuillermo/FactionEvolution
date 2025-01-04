package game.maps;

import java.util.Random;

public class RandomMap extends WorldMap{

    private final Random random;

    public RandomMap(int width, int height) {
        super(width, height);
        this.random = new Random();
    }

    @Override
    protected void generateMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = random.nextInt(4);
            }
        }
    }
}
