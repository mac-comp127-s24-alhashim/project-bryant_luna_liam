package plant;

import java.util.Timer;
import java.util.TimerTask;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class PotatoMine implements Plant {

    private static final String POTATOMINE_SPRITE_PATH = "plants/POTATOMINE.png";
    private static final String POTATOMINE_BURIED_SPRITE_PATH = "plants/POTATOMINE_BURIED.png";
    public static final String POTATOMINE_SEED_SPRITE_PATH = "game/SEEDPACKET_POTATOMINE.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 25;
    private static final int RECHARGE_TIME = 15000;  

    private int health;
    private GraphicsGroup potatoMine;
    private CanvasWindow canvas;
    private boolean potatoMineBuried = true;
    private boolean readyToActivate= false;
    private Timer rechargeTimer;


    public PotatoMine() {
        this.health = 1000; 
        loadSprite();
        startRechargeTimer();
    }

    public void loadSprite(){
        Image PotatoMineSprite = new Image(potatoMineBuried?POTATOMINE_BURIED_SPRITE_PATH: POTATOMINE_SPRITE_PATH);
        PotatoMineSprite.setMaxHeight(GRID_SIZE);
        PotatoMineSprite.setMaxWidth(GRID_SIZE);
        potatoMine = new GraphicsGroup();
        potatoMine.add(PotatoMineSprite);
        canvas.add(potatoMine);
    }

    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        // Set the position of the sprite on the canvas
        potatoMine.setPosition(x, y);
       
        System.out.println("Drawing a Potato Mine at position " + position);
    }

       private void startRechargeTimer() {
       rechargeTimer= new Timer();
       rechargeTimer.schedule(new TimerTask() {
        public void run(){
            readyToActivate= true;
        }
       }, RECHARGE_TIME);
    }

    
    private void stopRechargeTimer() {
        if (rechargeTimer != null) {
            rechargeTimer.cancel();
        }
    }


    public void removePlant(){
        canvas.remove(potatoMine);
        stopRechargeTimer();;
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    public void explode(int damage){
        System.out.println("Potato Mine explodes, dealing"+ damage+ "damage to zombies");
        health-=damage;
        if (health<=0) {
            removePlant();
        }
    }
    public void action(){
        if (readyToActivate) {
            explode(300);
        }else{
            System.out.println("Potato Mine is not ready to active");
        }
    }
    
}
