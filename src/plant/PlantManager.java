package plant;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;
import plantsvszombies.UI;
import zombies.Zombie;

/**
 * Manages the placement and logic of plants. Handles projectiles and explosions
 * created by plants.
 */
public class PlantManager {
    CanvasWindow canvas;

    // Lists of plants
    public List<Sunflower> sunflowers;
    List<Peashooter> peashooters;
    List<Wallnut> wallnuts;
    List<PotatoMine> potatoMines;
    List<CherryBomb> cherryBombs;

    // Plant creations
    public static List<Projectile> projectiles;
    public static List<Explosion> explosions;

    // Current plant statuses
    boolean cherryBombExploding;

    public PlantManager(CanvasWindow cv) {
        canvas = cv;
        sunflowers = new ArrayList<Sunflower>();
        peashooters = new ArrayList<Peashooter>();
        wallnuts = new ArrayList<Wallnut>();
        potatoMines = new ArrayList<PotatoMine>();
        cherryBombs = new ArrayList<CherryBomb>();
        projectiles = new ArrayList<Projectile>();
        explosions = new ArrayList<Explosion>();

        cherryBombExploding = false;
    }

    /**
     * Plants the specified plant.
     * Will not do anything if the player does not have enough suns.
     * @param type 0 = Sunflower, 1 = Peashooter, 2 = Wallnut, 3 = PotatoMine, 4 = CherryBomb
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
                    Wallnut wallnut = new Wallnut();
                    wallnut.setPosition(position);
                    wallnuts.add(wallnut);
                    canvas.add(wallnut);
                }
                break;
            case 3:
                if (PvZ.sunCount >= PotatoMine.SUN_COST) {
                    PotatoMine potatomine = new PotatoMine();
                    potatomine.setPosition(position);
                    potatoMines.add(potatomine);
                    canvas.add(potatomine);
                }
                break;
            case 4:
                if (PvZ.sunCount >= CherryBomb.SUN_COST) {
                    CherryBomb cherrybomb = new CherryBomb();
                    cherrybomb.setPosition(position);
                    cherryBombs.add(cherrybomb);
                    canvas.add(cherrybomb);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Meant to be run every 2160 frames. Handles sunflower logic:
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
     * Meant to be run every 90 frames. Handles peashooter logic:
     * Summons a pea projectile.
     */
    public void shootPeas() {
        if (peashooters != null) { // Check for peashooters
            for (Peashooter peashooter : peashooters) {
                    Projectile projectile = new Projectile(peashooter.getPosition(), Peashooter.PEASHOOTER_DAMAGE, Peashooter.PEA_SPRITE_PATH);
                    projectiles.add(projectile);
                    canvas.add(projectile);
            }
        }
    }

    /**
     * Meant to be run every 90 frames. If there is a cherry bomb placed, it explodes it.
     */
    public void explodeCherryBombs() {
        if (cherryBombs != null) {
            for (CherryBomb cherryBomb : cherryBombs) {
                if (!cherryBomb.getExplodeStatus()) {
                    Explosion explosion = new Explosion(CherryBomb.CHERRYBOMB_EXPLOSION_RADIUS, cherryBomb.getPosition(), CherryBomb.CHERRYBOMB_DAMAGE);
                    explosions.add(explosion);
                    canvas.add(explosion);
                    cherryBomb.setExploded(true);
                }
                if ((PvZ.frame % 90) == 0 && cherryBomb.getExplodeStatus()) {
                    cherryBomb.die();
                }
            }
        }    
    }

    /**
     * Meant to be run every 90 frames. If the given zombie is near any potato mine,
     * and the potato mine is armed, it causes it to explode.
     */
    public void createPotatoMineExplosion(Zombie zombie) {
        if (potatoMines != null) {
            for (PotatoMine potatoMine : potatoMines) {
                if (!potatoMine.getBuriedStatus() && canvas.getElementAt(potatoMine.getCenter()) == canvas.getElementAt(zombie.getCenter())) {
                    if (!potatoMine.getExplodeStatus()) {
                        Explosion explosion = new Explosion(PotatoMine.POTATOMINE_EXPLOSION_RADIUS, potatoMine.getPosition(), PotatoMine.POTATOMINE_DAMAGE);
                        explosions.add(explosion);
                        canvas.add(explosion);
                        potatoMine.setExploded(true);
                    }
                    if ((PvZ.frame % 90) == 0 && potatoMine.getExplodeStatus()) {
                        potatoMine.die();
                    }
                }
            }
        }
    }

    /**
     * Moves all projectiles by 1 pixel. If the projectile is out of bounds, it deletes it.
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
    
    /**
     * Causes the plant to explode, creating the explosion and inflicts damage on surrounding zombies.
     */
    public void runExplosionLogic(Zombie zombie) {
        if (explosions != null) {
            Iterator<Explosion> iterator = explosions.iterator();
            Explosion explosion;
            while (iterator.hasNext()) {
                explosion = iterator.next();
                damageZombieExplosion(explosion, zombie);
                if ((PvZ.frame % 2) == 0) {
                    iterator.remove();
                    canvas.remove(explosion);
                }
            }
        }
    }
    /** 
     * Detects if a pea projectile intersects a zombie object and inflicts damage upon if so.
     */
    private Boolean damageZombieProjectile(Projectile projectile, Zombie zombie) {
        if (canvas.getElementAt(projectile.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
            zombie.reduceHealth(projectile.getDamage());
            return true;
        }
        else return false;
    }

    /**
     * Detects if a plant explosion intersects a zombie objects and inflicts damage upon if so.
     */
    private Boolean damageZombieExplosion(Explosion explosion, Zombie zombie) {
        if (Math.hypot(zombie.getCenter().getX() - explosion.getCenter().getX(), zombie.getCenter().getY() - explosion.getCenter().getY()) <= explosion.getRadius() + zombie.getWidth() / 2) {
            zombie.reduceHealth(explosion.getDamage());
            return true;
        }
        else return false;
    }
    
    /**
    * Causes zombie contact with plant to inflict damage upon the plant, as it eats it 
    */
    public void zombieDamagePlant(Zombie zombie) {
        if (sunflowers != null) {
            Iterator<Sunflower> iterator = sunflowers.iterator();
            Sunflower sunflower;
            while (iterator.hasNext()) {
                sunflower = iterator.next();
                if (canvas.getElementAt(sunflower.getCenter()) == canvas.getElementAt(zombie.getCenter())) {
                    zombie.setEatingStatus(true);
                    sunflower.reduceHealth(zombie.getDamage());
                    if (sunflower.getHealth() <= 0) {
                        iterator.remove();
                        zombie.setEatingStatus(false);
                    }
                } else zombie.setEatingStatus(false);
            }
        }
        if (peashooters != null) {
            Iterator<Peashooter> iterator = peashooters.iterator();
            Peashooter peashooter;
            while (iterator.hasNext()) {
                peashooter = iterator.next();
                if (canvas.getElementAt(peashooter.getCenter()) == canvas.getElementAt(zombie.getCenter())) {
                    zombie.setEatingStatus(true);
                    peashooter.reduceHealth(zombie.getDamage());
                    if (peashooter.getHealth() <= 0) {
                        iterator.remove();
                        zombie.setEatingStatus(false);
                    }
                } else zombie.setEatingStatus(false);
            }
        }
        if (wallnuts != null) {
            Iterator<Wallnut> iterator = wallnuts.iterator();
            Wallnut wallnut;
            while (iterator.hasNext()) {
                wallnut = iterator.next();
                if (canvas.getElementAt(wallnut.getCenter()) == canvas.getElementAt(zombie.getCenter())) {
                    zombie.setEatingStatus(true);
                    wallnut.reduceHealth(zombie.getDamage());
                    if (wallnut.getHealth() <= 0) {
                        iterator.remove();
                        zombie.setEatingStatus(false);
                    }
                } else zombie.setEatingStatus(false);
            }
        }
    }
    
    /**
     * Arms all potato mines, which makes them able to explode upon contact with a Zombie.
     */
    public void armPotatoMine() {
        if (potatoMines != null) {
            Iterator<PotatoMine> iterator = potatoMines.iterator();
            PotatoMine potatoMine;
            while (iterator.hasNext()) {
                potatoMine = iterator.next();
                potatoMine.arm();
            }
        }
    }
    
    /*
    * Iterates through all plants to find the plant based on the graphics object given.
    */
    public void removePlant(GraphicsObject clickedObject) {
        Iterator<Sunflower> iterator = sunflowers.iterator();
        while (iterator.hasNext()) {
            Sunflower plant = iterator.next();
            if (plant.sunflowerSprite == clickedObject) {
                plant.die();
                iterator.remove();
                UI.shovelMode = false;
                break;
            }
        }
        Iterator<Peashooter> iterator2 = peashooters.iterator();
        while (iterator2.hasNext()) {
            Peashooter plant = iterator2.next();
            if (plant.peashooterSprite == clickedObject) {
                plant.die();
                iterator2.remove();
                UI.shovelMode = false;
                break;
            }
        }
        Iterator<Wallnut> iterator3 = wallnuts.iterator();
        while (iterator3.hasNext()) {
            Wallnut plant = iterator3.next();
            if (plant.wallnutSprite == clickedObject) {
                plant.die();
                iterator3.remove();
                UI.shovelMode = false;
                break;
            }
        }
        Iterator<PotatoMine> iterator4 = potatoMines.iterator();
        while (iterator4.hasNext()) {
            PotatoMine plant = iterator4.next();
            if (plant.potatoMineSprite == clickedObject) {
                plant.die();
                iterator4.remove();
                UI.shovelMode = false;
                break;
            }
        }
        Iterator<CherryBomb> iterator5 = cherryBombs.iterator();
        while (iterator5.hasNext()) {
            CherryBomb plant = iterator5.next();
            if (plant.cherryBombSprite == clickedObject) {
                plant.die();
                iterator5.remove();
                UI.shovelMode = false;
                break;
            }
        }
    }

    /**
     * Removes all plant creations from their respective list and canvas.
     */
    public void removeAllPlantCreations() {
        Iterator<Projectile> projectileIterator = projectiles.iterator();
        Iterator<Explosion> explosionIterator = explosions.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            canvas.remove(projectile);
            projectileIterator.remove();
        }
        while (explosionIterator.hasNext()) {
            Explosion explosion = explosionIterator.next();
            canvas.remove(explosion);
            explosionIterator.remove();
        }
    }
}