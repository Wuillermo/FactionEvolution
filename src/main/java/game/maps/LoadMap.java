package game.maps;

import game.maps.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class LoadMap extends WorldMap {

    private Tile[] tiles;
    private int[] mapPixels;

    public LoadMap(String path) {
        super(path);
    }

    @Override
    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(LoadMap.class.getResource(path)));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new Tile[w * h];
            image.getRGB(0, 0, w, h, mapPixels, 0, w);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception: Could not load Map file!");
        }
    }

    @Override
    protected void generateMap() {

    }
}
