package game.entity.unit;

import game.graphics.Screen;
import game.graphics.Sprite;

public class Human extends Unit {

    private Sprite sprite;
    private int anim = 0;
    private boolean walking;

    public Human () {
    }

    public Human (int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = Sprite.human_forward;
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;
        if(anim < 7500) anim++;
        else anim = 0;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        }else walking = false;
    }

    @Override
    public void render(Screen screen) {
        if(dir == 0) {
            sprite = Sprite.human_forward;
            if(walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_forward_1;
                }else {
                    sprite = Sprite.player_forward_2;
                }
            }
        }
        if(dir > 0 && dir < 4) {
            sprite = Sprite.human_right;
            if(walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_side_1;
                }else {
                    sprite = Sprite.player_side_2;
                }
            }
        }
        if(dir == 4) {
            sprite = Sprite.human_back;
            if(walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_back_1;
                }else {
                    sprite = Sprite.player_back_2;
                }
            }
        }
        if(dir > 4 && dir < 8) {
            sprite = Sprite.human_left;
            if(walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_side_1;
                }else {
                    sprite = Sprite.player_side_2;
                }
            }
        }
        screen.renderHuman(x, y, sprite);
    }
}
