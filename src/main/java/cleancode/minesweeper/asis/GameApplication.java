package cleancode.minesweeper.asis;

import cleancode.minesweeper.asis.config.GameConfig;
import cleancode.minesweeper.asis.gamelevel.Beginner;
import cleancode.minesweeper.asis.io.ConsoleInputHandler;
import cleancode.minesweeper.asis.io.ConsoleOutputHandler;

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
