package plant;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.GraphicsGroup;
import plantsvszombies.PvZ;
import plantsvszombies.UI;
import zombies.Zombie;

/**
 * Manages the placement and logic of plants. Handles projectiles and explosions
 * created by plants.
 */
public class PlantManager {
    CanvasWindow canvas;

    // Plants with logic
    public List<Sunflower> sunflowers;
    List<Peashooter> peashooters;
    List<Wallnut> wallnuts;
    List<PotatoMine> potatoMines;
    List<CherryBomb> cherrybombs;
    public List<Image> plantImages;

    // Plant creations
    public static List<Projectile> projectiles;


    public PlantManager(CanvasWindow cv) {
        canvas = cv;
        sunflowers = new ArrayList<Sunflower>();
        peashooters = new ArrayList<Peashooter>();
        wallnuts = new ArrayList<Wallnut>();
        potatoMines = new ArrayList<PotatoMine>();
        cherrybombs = new ArrayList<CherryBomb>();
        projectiles = new ArrayList<Projectile>();
        plantImages = new ArrayList<Image>();
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
                    plantImages.add(sunflower.sunflowerSprite);
                    }
                break;
            case 1:
                if (PvZ.sunCount >= Peashooter.SUN_COST) {
                    Peashooter peashooter = new Peashooter();
                    peashooter.setPosition(position);
                    peashooters.add(peashooter);
                    canvas.add(peashooter);
                    plantImages.add(peashooter.peashooterSprite);
                    }
                break;
            case 2:
                if (PvZ.sunCount >= Wallnut.SUN_COST) {
                    Wallnut wallnut = new Wallnut();
                    wallnut.setPosition(position);
                    wallnuts.add(wallnut);
                    canvas.add(wallnut);
                    plantImages.add(wallnut.wallnutSprite);
                }
                break;
            case 3:
                if (PvZ.sunCount >= PotatoMine.SUN_COST) {
                    PotatoMine potatomine = new PotatoMine();
                    potatomine.setPosition(position);
                    potatoMines.add(potatomine);
                    canvas.add(potatomine);
                    plantImages.add(potatomine.potatoMineSprite);
                }
                break;
            case 4:
                if (PvZ.sunCount >= CherryBomb.SUN_COST) {
                    CherryBomb cherrybomb = new CherryBomb();
                    cherrybomb.setPosition(position);
                    cherrybombs.add(cherrybomb);
                    canvas.add(cherrybomb);
                    plantImages.add(cherrybomb.cherryBombSprite);
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
                // if (peashooter.getY() == zombie.getY() + zombie.getHeight() / 3) {
                    Projectile projectile = new Projectile(peashooter.getPosition(), Peashooter.PEASHOOTER_DAMAGE, Peashooter.PEA_SPRITE_PATH);
                    projectiles.add(projectile);
                    canvas.add(projectile);
                // }
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

    public void damagePlant(Zombie zombie) {
        for (Sunflower sunflower : sunflowers) {
            if (canvas.getElementAt(sunflower.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
                zombie.setEatingState(true);
                sunflower.reduceHealth(zombie.getDamage());
                if (sunflower.getHealth() <= 0) {
                    sunflowers.remove(sunflower);
                }
            }
            else {
                zombie.setEatingState(false);
            }
        }
        for (Peashooter peashooter : peashooters) {
            if (canvas.getElementAt(peashooter.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
                zombie.setEatingState(true);
                peashooter.reduceHealth(zombie.getDamage());
                if (peashooter.getHealth() <= 0) {
                    peashooters.remove(peashooter);
                }            
            }
            else {
                zombie.setEatingState(false);
            }
        }
        for (Wallnut wallnut : wallnuts) {
            if (canvas.getElementAt(wallnut.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
                zombie.setEatingState(true);
                wallnut.reduceHealth(zombie.getDamage());
                if (wallnut.getHealth() <= 0) {
                    wallnuts.remove(wallnut);
                }
            }
            else {
                zombie.setEatingState(false);
            }
        }
    }

    public void armPotatoMine() {
        if (potatoMines != null) {
            for (PotatoMine potatoMine : potatoMines) {
                potatoMine.armUp();
                System.out.println("ARM POTATO MINE");
            }
        }
    }

    public void removePlant(GraphicsObject clickedObject) {
        // Iterates through all plants to find the plant based on the graphics object given.
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
                System.out.println("found peashooter");
                plant.die();
                iterator2.remove();
                System.out.println("exiting shovel mode");
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
        Iterator<CherryBomb> iterator5 = cherrybombs.iterator();
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

    public List<Sunflower> getSunflowers() {
        return sunflowers;
    }

    public List<Peashooter> getPeashooters() {
        return peashooters;
    }

    public List<Wallnut> getWallnuts() {
        return wallnuts;
    }

    public List<PotatoMine> getPotatoMines() {
        return potatoMines;
    }

    public List<CherryBomb> getCherryBombs() {
        return cherrybombs;
    }
}