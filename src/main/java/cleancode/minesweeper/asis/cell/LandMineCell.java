package cleancode.minesweeper.asis.cell;

public class LandMineCell extends Cell2 {

    private boolean isLandMine;

    @Override
    public void turnOnLandMine() {
        this.isLandMine = true;
    }

    @Override
    public void updateNearbyLandMineCount(int count) {

    }

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMineCount() {
        return false;
    }

    @Override
    public String getSign() {
        return "";
    }
}
