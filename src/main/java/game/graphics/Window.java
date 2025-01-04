package game.graphics;

import game.input.Keyboard;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Window extends Canvas {

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    public int x = 0, y = 0;

    private JFrame frame;
    private Screen screen;
    private Keyboard keyboard;

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
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render(x, y);

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
}
