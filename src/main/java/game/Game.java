package game;

import game.entity.Camera;
import game.entity.unit.Human;
import game.graphics.Window;
import game.input.Keyboard;
import game.maps.RandomMap;
import game.maps.WorldMap;

import java.util.logging.Level;

public class Game implements Runnable{

    private Thread gameThread;
    private Window window;
    private Keyboard keyboard;
    private WorldMap worldMap;
    private Camera camera;
    private Human human;

    private boolean running = false;

    public Game () {
        this.window = new Window();
        this.keyboard = new Keyboard();
        this.worldMap = new RandomMap(64, 64);
        this.camera = new Camera(keyboard);
        this.human = new Human(1, 1);

        window.setKeyboard(keyboard);
        window.setWorldMap(worldMap);
        window.setCamera(camera);
    }

    public synchronized void start() {
        running = true;
        gameThread = new Thread(this, "GameThread");
        gameThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            gameThread.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1_000_000_000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                window.updateFPS(updates, frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void update() {
        keyboard.update();
        camera.update();
        human.update();
    }

    public void render() {
        window.render();
    }
}
