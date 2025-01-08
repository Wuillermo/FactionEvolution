package game.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMap extends WorldMap{

    private static final Random random = new Random();

    public RandomMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected void generateMap() {
        /*for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = random.nextInt(4);
            }
        }*/

        // Fill top border
        for (int x = 0; x < width; x++) {
            tiles[x] = 0;
        }

        // Fill bottom border
        for (int x = 0; x < width; x++) {
            tiles[(height - 1) * width + x] = 0;
        }

        // Fill left and right borders
        for (int y = 0; y < height; y++) {
            tiles[y * width] = 0;             // Left border
            tiles[y * width + (width - 1)] = 0; // Right border
        }

        int numContinents = 7;
        int sizeContinent = 125;

        for (int i = 0; i < numContinents; i++) {
            // Start with a random position inside the map (excluding borders)
            int x = random.nextInt(width - 2) + 1;
            int y = random.nextInt(height - 2) + 1;

            // A set of tiles that form the current continent
            List<int[]> continentTiles = new ArrayList<>();
            continentTiles.add(new int[]{x, y});
            tiles[x + y * width] = 1; // Mark the seed tile as part of the continent

            // Expand the continent until it reaches the desired size
            while (continentTiles.size() < sizeContinent) {
                // Choose a random tile from the current continent
                int[] currentTile = continentTiles.get(random.nextInt(continentTiles.size()));
                int cx = currentTile[0];
                int cy = currentTile[1];

                // Try to add a new adjacent tile
                int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Down, Right, Up, Left
                int[] direction = directions[random.nextInt(directions.length)];

                int nx = cx + direction[0];
                int ny = cy + direction[1];

                // Check if the new tile is valid
                if (nx > 0 && nx < width - 1 && ny > 0 && ny < height - 1 && tiles[nx + ny * width] == 0) {
                    tiles[nx + ny * width] = 1; // Mark the tile as part of the continent
                    continentTiles.add(new int[]{nx, ny}); // Add to the continent
                }
            }
        }
    }
}
