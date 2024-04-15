package zombies;

import edu.macalester.graphics.*;

public class NormalZombie extends Zombie{
    private int health;
    private GraphicsGroup zombieSprite;
    private static final int GRID_SIZE = 32;
    private CanvasWindow canvas;


    public NormalZombie() {
        this.health = 6; 
        loadSprite();
    }

    private void loadSprite() {
        Image zombieImage= new Image("ZOMBIE_PLACEHOLDER.png");
        zombieImage.setMaxHeight(GRID_SIZE);
        zombieImage.setMaxWidth(GRID_SIZE);
        zombieSprite = new GraphicsGroup();
        zombieSprite.add(zombieImage);
        canvas.add(zombieSprite);
    }

    public void drawZombie(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        zombieSprite.setPosition(x, y);

        System.out.println("Drawing a Normal Zombie at position " + position);
    }

    public void attack() {
        System.out.println("Zombie takes a bite, dealing 1 damage to plant");
    }
}