package plant;

import java.util.Timer;
import java.util.TimerTask;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Wallnut implements Plant{

    private static final String WALLNUT_SPRITE_PATH = "\\plants\\PLANT_PLACEHOLDER.png";
    public static final String WALLNUT_SEED_SPRITE_PATH = "\\game\\SEEDPACKET_WALLNUT.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 50;
    private static final int RECHARGE_TIME = 30000;  

    private int health;
    private GraphicsGroup wallnut;
    private CanvasWindow canvas;
    private Timer rechargeTimer;

    public Wallnut() {
        this.health = 54; 
        loadSprite();
        startRechargeTimer();
    }

    public void loadSprite(){
        Image wallnutSprite = new Image(WALLNUT_SPRITE_PATH);
        wallnutSprite.setMaxHeight(GRID_SIZE);
        wallnutSprite.setMaxWidth(GRID_SIZE);
        wallnut = new GraphicsGroup();
        wallnut.add(wallnutSprite);
        canvas.add(wallnut);
    }
    
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        wallnut.setPosition(x, y);
        
        System.out.println("Drawing a Wallnut at position " + position);
    }
    
    public void removePlant(){
        canvas.remove(wallnut);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    @Override
    public void action() {
        int damage=10;
        health-= damage;
        if (health<=0) {
            removePlant();
        }
    }
    private void startRechargeTimer(){
        rechargeTimer= new Timer();
        rechargeTimer.schedule(new TimerTask() {
            public void run(){
                health=54;
            }
        }, RECHARGE_TIME);
    }
}
    

