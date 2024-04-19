// package plant.old;
// import java.awt.Color;
    
// import edu.macalester.graphics.CanvasWindow;
// import edu.macalester.graphics.Ellipse;
// import edu.macalester.graphics.GraphicsGroup;
// import edu.macalester.graphics.Image;
// import zombies.Zombie;

// public class PeashooterPea {
//     /**
//      * Represents a ball in the breakout game
//      * This uses modified code from a previous assignment
//      * Helped by Profersor Alhashim
//      */

    
    
//         public static final double PEA_RADIUS = 10;

//     private static final CanvasWindow canvas = null;
    
//         @SuppressWarnings("WeakerAccess")
//         private Ellipse ballShape;
//         private double xVelocity;
//         private double yVelocity;
//         private double centerX;
//         private double centerY;
//         private double maxX;
//         public boolean updatePosition;
//         public GraphicsGroup peashooterpeaSprite;
    
//         /**
//          * Constructs a Ball object
//          * 
//          * @param centerX  The x-coordinate of the centerof the ball
//          * @param centerY  The y-coordinate of the centerof the ball
//          * @param initialVelocityX The initial velocity of the ball alongside the x-axis
//          * @param initialVelocityY The initial velocity of the ball alongside the y-axis
//          * @param canvas  The canvas where the ball will be drawn
//          */
    
//         public PeashooterPea(
//             double centerX,
//             double centerY,
//             double initialVelocityX,
//             double initialVelocityY,
//             CanvasWindow canvas) {
    
//             this.centerX = centerX;
//             this.centerY = centerY;
//             this.ballShape.setFillColor(Color.CYAN);
//             this.xVelocity = initialVelocityX;
//             this.maxX = canvas.getWidth() + 10;
//             canvas.add(ballShape);
//             loadSprite();
//         }


//         public void loadSprite(){
//             Image peashooterpeaImage= new Image("PEASHOOTER_PEA.png");
//             peashooterpeaImage.setMaxHeight(10);
//             peashooterpeaImage.setMaxWidth(10);
//             peashooterpeaSprite = new GraphicsGroup();
//             peashooterpeaSprite.add(peashooterpeaImage);
//             canvas.add(peashooterpeaSprite);
//         }
        
//         /**
//          * Reverses the velocity of the ball along the x-axis.
//          */
//         public void reverseXVelocity() {
//             xVelocity *= -1;
//         }
    
//         /**
//          * Reverses the velocity of the ball along the y-axis.
//          */
//         public void reverseYVelocity() {
//             yVelocity *= -1;
//         }
    
//         /**
//          * Adds the cannonball's shape to the given canvas.
//          */
//         public void addToCanvas(CanvasWindow canvas) {
//             canvas.add(ballShape);
//         }
    
//         /**
//          * Removes the ball's shape from the given canvas.
//          */
//         public void removeFromCanvas(CanvasWindow canvas) {
//             canvas.remove(ballShape);
//         }
    
//         /**
//          * Returns ballShape's radius by using getter method for
//          * its width and then dividing it by two
//          */
//         public double getRadius() {
//             return ballShape.getWidth() / 2;
//         }
    
//         /**
//          * Returns The y-coordinate of the center of the ball.
//          */
//         public double getY() {
//             return ballShape.getY();
//         }
    
//         /**
//          * Returns The x-coordinate of the center of the ball.
//          */
//         public double getX() {
//             return ballShape.getX();
//         }
    
//         /**
//          * Sets the position of the ball using the new x and y-coordinate of the center of the ball.
//          */
//         public void setPosition(Double x, Double y) {
//             ballShape.setPosition(x, y);
//         }
    
//         /**
//          * Updates the position of the ball based on its velocity.
//          *
//          *  dt is the time step for updating the position.
//          */
//         public boolean updatePosition(double dt) {
//             double currX = centerX + (xVelocity * dt);
//             double currY = centerY;
    
//             if (currX > 0 && currX < 240) {
    
//                 this.centerX = currX;
//                 this.centerY = currY;
//                 ballShape.setPosition(currX - PEA_RADIUS, currY);
    
//                 return true;
    
//             } else {
    
//                 return false;
    
//             }
//         }

//             // if (intersectsZombie(Zombie zombie)){
                

//             // }
        
    
//         /**
//          * Checks if the ball intersects with the zombie.
//          */
//         public boolean intersectsZombie(Zombie zombie) {
//             // if (canvas.getElementAt(getX(), getY() + PEA_RADIUS+0.1) instanceof Zombie
//             // || canvas.getElementAt(getX(), getY() - PEA_RADIUS-0.1)  instanceof Zombie
//             // || canvas.getElementAt(getX() + PEA_RADIUS+0.1, getY())  instanceof Zombie
//             // || canvas.getElementAt(getX() - PEA_RADIUS-0.1, getY())  instanceof Zombie) {
//             //     return true;
                
//             //  }
//         return false;
//     }
//     }
    
    

    

