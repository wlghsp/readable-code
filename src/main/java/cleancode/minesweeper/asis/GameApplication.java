package cleancode.minesweeper.asis;

import cleancode.minesweeper.asis.gamelevel.GameLevel;
import cleancode.minesweeper.asis.gamelevel.VeryBeginner;

public class GameApplication {



    public static void main(String[] args) {
        GameLevel gameLevel = new VeryBeginner();
        MineSweeper mineSweeper = new MineSweeper(gameLevel);
        mineSweeper.run();
    }



}
