import edu.macalester.graphics.*;

public class Shovel {
    
    private Image shovelSprite;
    
    public Shovel() {
        loadSprite();
    }

    private void loadSprite(){
        shovelSprite = new Image("res\\game\\SHOVEL.png");
    }
    
}
