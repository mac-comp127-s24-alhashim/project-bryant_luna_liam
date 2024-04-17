package plantsvszombies;

public class Player {

    private final short maxSun = 9999;

    private short sunCount;
    private int zombiesKilled = 0; 
    private String playerName;

    public Player(String playerName, short sunCount) {
        this.playerName = playerName;
        this.sunCount = sunCount;
    }

    public int getSunCount() {
        return sunCount;
    }

    public void changeSunCount(int sun) {
        if (sunCount <= 0 || sunCount >= maxSun) {
            sunCount += sun;
        }
    }

    public String getName() {
        return playerName;
    }

}
