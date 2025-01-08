package game.graphics;

import game.entity.Camera;
import game.entity.Entity;
import game.entity.unit.Human;
import game.input.Keyboard;
import game.maps.WorldMap;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Window extends Canvas {

    public static int width = 1000;
    public static int height = width / 16 * 9;
    public static int scale = 1;

    private JFrame frame;
    private Screen screen;
    private Keyboard keyboard;
    private WorldMap worldMap;
    private Camera camera;
    private Human human = new Human(0, 0);

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Window() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);

        this.frame = new JFrame();

        init();
    }

    private void init() {
        frame.setResizable(false);
        frame.setTitle("Faction Evolution");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        requestFocus();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        worldMap.render(camera.x, camera.y, screen);
        human.render(screen);

        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();

        bs.show();
    }

    public void updateFPS (int ups, int fps) {
        frame.setTitle("Factions Evolution | " + ups + " ups " + fps + " fps");
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
        addKeyListener(keyboard);
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
