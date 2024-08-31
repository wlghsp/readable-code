package cleancode.minesweeper.asis;

import cleancode.minesweeper.asis.minesweeper.MineSweeper;
import cleancode.minesweeper.asis.minesweeper.config.GameConfig;
import cleancode.minesweeper.asis.minesweeper.gamelevel.Beginner;
import cleancode.minesweeper.asis.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.asis.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(
                new Beginner(),
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );

        MineSweeper mineSweeper = new MineSweeper(gameConfig);
        mineSweeper.initialize();
        mineSweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     *
     * DI (Dependency Injection) - "3"
     *
     * IoC (Inversion of Control)
     */


}
