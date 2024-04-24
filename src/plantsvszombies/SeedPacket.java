package plantsvszombies;

// import java.util.List;

import edu.macalester.graphics.*;

import plant.*;

public class SeedPacket {

    static GraphicsGroup seedPacket;
    Image seedPacketSprite;
    CanvasWindow canvas;
    int plant;
    // List<Image> seedPackets;

    public SeedPacket(CanvasWindow canvas, int plant) {
        this.canvas = canvas;
        this.plant = plant;
        loadSprite(plant);
    }

    public void loadSprite(int plant){
        seedPacketSprite = new Image(getSeedSprite(plant));
        seedPacket = new GraphicsGroup();
        seedPacket.add(seedPacketSprite);
    }

    private String getSeedSprite(int plant) {
        switch (plant) {
            case 0:
                return Sunflower.SEED_SPRITE_PATH;
            case 1:
                return Peashooter.SEED_SPRITE_PATH;
            case 2:
                return Wallnut.SEED_SPRITE_PATH;
            case 3:
                return PotatoMine.SEED_SPRITE_PATH;
            case 4: 
                return CherryBomb.CHERRYBOMB_SEED_SPRITE_PATH;
            default:
                return "game/SEEDPACKET_EMPTY.png";
        }
    }

    public int getPlantCost(int plant) {
        switch (plant) {
            case 0:
                return Sunflower.SUN_COST;
            case 1:
                return Peashooter.SUN_COST;
            case 2:
                return Wallnut.SUN_COST;
            case 3:
                return PotatoMine.SUN_COST;
            case 4: 
                return CherryBomb.SUN_COST;
            default:
                return 0;
        }
    }

    public void getPlant(int plant, Point location) {
        switch (plant) {
            case 0:
                Sunflower sunflower = new Sunflower(canvas, location);
                sunflower.addToCanvas();
            case 1:
                Peashooter peashooter = new Peashooter(canvas, location);
                peashooter.addToCanvas();
            case 2:
                Wallnut wallnut = new Wallnut(canvas, location);
                wallnut.addToCanvas();
            case 3:
                PotatoMine potatoMine = new PotatoMine(canvas, location, true);
                potatoMine.addToCanvas();
            case 4: 
                CherryBomb cherryBomb = new CherryBomb(canvas, location);
                cherryBomb.addToCanvas();
            default:
                System.out.println("BAZINGA!");
        }
    }

    public void addToCanvas() {
        canvas.add(seedPacket);
    }

    public void setPosition(int x, int y) {
        seedPacket.setPosition(x, y);
    }

    public double getWidth() {
        return seedPacket.getWidth();
    }

    public int getPlantID() {
        return plant;
    }

    public void plantPlant(int plant, Point location) {
        PvZ.sunCount -= getPlantCost(plant);
        getPlant(plant, location);
    }
    
}
