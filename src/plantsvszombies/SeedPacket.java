package plantsvszombies;

import edu.macalester.graphics.*;

import plant.*;

public class SeedPacket {

    GraphicsGroup seedPacket;
    Image seedPacketSprite;

    public SeedPacket(int plant) {
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
                return Sunflower.SUNFLOWER_SEED_SPRITE_PATH;
            case 1:
                return Peashooter.PEASHOOTER_SEED_SPRITE_PATH;
            // case 2:
            //     return Wallnut.WALLNUT_SEED_SPRITE_PATH;
            // case 3:
            //     return PotatoMine.POTATOMINE_SEED_SPRITE_PATH;
            // case 4: 
            //     return CherryBomb.CHERRYBOMB_SEED_SPRITE_PATH;
            default:
                return "game/SEEDPACKET_EMPTY.png";
        }
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(seedPacket);
    }

    public void setPosition(int x, int y) {
        seedPacket.setPosition(x, y);
    }

    public double getWidth() {
        return seedPacket.getWidth();
    }

    private void plantPlant(int plant) {

    }
    
}
