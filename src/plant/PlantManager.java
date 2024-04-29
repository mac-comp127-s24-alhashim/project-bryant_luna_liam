package plant;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;
import zombies.Zombie;

/**
 * Manages the placement and logic of plants. Handles projectiles and explosions
 * created by plants.
 */
public class PlantManager {
    CanvasWindow canvas;

    // Plants with logic
    List<Sunflower> sunflowers;
    List<Peashooter> peashooters;
    List<Wallnut> wallnuts;
    List<PotatoMine> potatoMines;
    List<CherryBomb> cherrybombs;

    // Plant creations
    public static List<Projectile> projectiles;


    public PlantManager(CanvasWindow cv) {
        canvas = cv;
        sunflowers = new ArrayList<Sunflower>();
        peashooters = new ArrayList<Peashooter>();
        cherrybombs = new ArrayList<CherryBomb>();
        projectiles = new ArrayList<Projectile>();
    }

    /**
     * If the sun cost requirement for the plant is met, plants the specified
     * plant.
     * @param type 0=Sunflower, 1=Peashooter, 2=Wallnut, 3=PotatoMine, 4=CherryBomb
     * @param position
     */
    public void addPlant(int type, Point position) {
        switch(type) {
            case 0:
                if (PvZ.sunCount >= Sunflower.SUN_COST) {
                    Sunflower sunflower = new Sunflower();
                    sunflower.setPosition(position);
                    sunflowers.add(sunflower);
                    canvas.add(sunflower);
                    }
                break;
            case 1:
                if (PvZ.sunCount >= Peashooter.SUN_COST) {
                    Peashooter peashooter = new Peashooter();
                    peashooter.setPosition(position);
                    peashooters.add(peashooter);
                    canvas.add(peashooter);
                    }
                break;
            case 2:
                if (PvZ.sunCount >= Wallnut.SUN_COST) {
                    Wallnut wallnut= new Wallnut();
                    wallnut.setPosition(position);
                    canvas.add(wallnut);
                }
                break;
            case 3:
                if (PvZ.sunCount >= PotatoMine.SUN_COST) {
                    PotatoMine potatomine= new PotatoMine();
                    potatomine.setPosition(position);
                    canvas.add(potatomine);
                }
                break;
            case 4:
                if (PvZ.sunCount >= CherryBomb.SUN_COST) {
                    CherryBomb cherrybomb= new CherryBomb();
                    cherrybomb.setPosition(position);
                    canvas.add(cherrybomb);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Meant to be run every 24 seconds. Handles sunflower logic:
     * Summons a sun on the sunflower.
     */
    public void produceSunflowerSuns() {
        if (sunflowers != null) { // Check for sunflowers
            for (Sunflower sunflower : sunflowers) {
                Image sun = new Image("game/SUN.png");
                sun.setPosition((sunflower.getPosition()));
                PvZ.sunflowerSuns.add(sun);
                canvas.add(sun);
            }
        }
    }

    /**
     * Meant to be run every 1.5 seconds. Handles peashooter logic:
     * Summons a projectile.
     */
    public void shootProjectile() {
        if (peashooters != null) { // Check for peashooters
            for (Peashooter peashooter : peashooters) {
                Projectile projectile = new Projectile(peashooter.getPosition(), Peashooter.PEASHOOTER_DAMAGE, Peashooter.PEA_SPRITE_PATH);
                projectiles.add(projectile);
                canvas.add(projectile);
            }
        }
    }

    /**
     * Meant to be run every 7 frames. Handles movement of projectiles.
     */
    public void moveProjectiles(Zombie zombie) {
        if (projectiles != null) {
            Iterator<Projectile> iterator = projectiles.iterator();
            Projectile projectile;
            while (iterator.hasNext()) {
                projectile = iterator.next();
                if (projectile.getX() > PvZ.CANVAS_WIDTH || damageZombieProjectile(projectile, zombie)) {
                    iterator.remove();
                    canvas.remove(projectile);
                } else projectile.moveBy(1, 0);
            }
        }
    }

    private Boolean damageZombieProjectile(Projectile projectile, Zombie zombie) {
        if (canvas.getElementAt(projectile.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
            zombie.reduceHealth(projectile.getDamage());
            return true;
        }
        else return false;
    }

    public void armPotatoMine() {
        if (potatoMines != null) {
            for (PotatoMine potatoMine : potatoMines) {
                potatoMine.armUp();
            }
        }
    }

    // private Boolean damagePlant(Sunflower sunflower, Peashooter peashooter, Wallnut wallnut, Zombie zombie) {
    //     if (canvas.getElementAt(sunflower.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
    //         sunflower.reduceHealth(zombie.getDamage());
    //         return true;
    //     }
    //     else return false;
    // }

    // private Boolean damageZombieExplosion(Explosion explosion, Zombie zombie) {
    //     if (canvas.getElementAt(explosion.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
    //         zombie.reduceHealth(explosion.getDamage());
    //         return true;
    //     }
    //     else return false;
    // }
}