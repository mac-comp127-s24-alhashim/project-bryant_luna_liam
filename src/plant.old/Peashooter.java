// package plant.old;

// import java.util.Timer;
// import java.util.TimerTask;

// import edu.macalester.graphics.CanvasWindow;
// import edu.macalester.graphics.GraphicsGroup;
// import edu.macalester.graphics.Image;
// import edu.macalester.graphics.Point;

// public class Peashooter implements Plant{

//     private static final String PEASHOOTER_SPRITE_PATH = "plants/PLANT_PLACEHOLDER.png";
//     public static final String PEASHOOTER_SEED_SPRITE_PATH = "game/SEEDPACKET_PEASHOOTER.png";
//     private static final int GRID_SIZE = 32;
//     private static final int SUN_COST = 100; 
//     private static final int RECHARGE_TIME = 7500;
//     private Timer rechargeTimer; 
//     private boolean readyToActivate = false;

//     private int health;
//     private GraphicsGroup peashooter;
//     private CanvasWindow canvas;


//     public Peashooter() {
//         this.health = 6; 
//         loadSprite();
//         startRechargeTimer();
//     }

//     public void loadSprite(){
//         Image peashooterSprite= new Image(PEASHOOTER_SPRITE_PATH);
//         peashooterSprite.setMaxHeight(GRID_SIZE);
//         peashooterSprite.setMaxWidth(GRID_SIZE);
//         peashooter = new GraphicsGroup();
//         peashooter.add(peashooterSprite);
//         canvas.add(peashooter);
//     }

//     public void drawPlant(String type, int health, Point position) {

//         double x = position.getX() * GRID_SIZE;
//         double y = position.getY() * GRID_SIZE;

//         peashooter.setPosition(x, y);

//         System.out.println("Drawing a Peashooter at position " + position);
//     }

//     public int getSunCost() { 
//         return SUN_COST;
//     }

//     private void startRechargeTimer() {
//         rechargeTimer= new Timer();
//         rechargeTimer.schedule(new TimerTask() {
//          public void run(){
//          }
//         }, RECHARGE_TIME);
//     }

//     private void stopRechargeTimer() {
//         if (rechargeTimer != null) {
//             rechargeTimer.cancel();
//         }
//     }

//     public void removePlant(){
//         canvas.remove(peashooter);
//         stopRechargeTimer();
//     }
    
//     public void action() {
//         if (readyToActivate) {
//             shootPea();
//             readyToActivate = false;
//         }}

//     private void shootPea() {
//         double centerX = peashooter.getPosition().getX() + GRID_SIZE / 2;
//         double centerY = peashooter.getPosition().getY() + GRID_SIZE / 2;
//         double initialVelocityX = 5; 
//         double initialVelocityY = 0; 
//         PeashooterPea pea = new PeashooterPea(centerX, centerY, initialVelocityX, initialVelocityY, canvas);
//         pea.addToCanvas(canvas);
//     }

// }
