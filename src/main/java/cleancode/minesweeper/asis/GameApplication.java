package cleancode.minesweeper.asis;

import cleancode.minesweeper.asis.gamelevel.Beginner;
import cleancode.minesweeper.asis.gamelevel.GameLevel;
import cleancode.minesweeper.asis.gamelevel.VeryBeginner;
import cleancode.minesweeper.asis.io.ConsoleInputHandler;
import cleancode.minesweeper.asis.io.ConsoleOutputHandler;
import cleancode.minesweeper.asis.io.InputHandler;
import cleancode.minesweeper.asis.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        MineSweeper mineSweeper = new MineSweeper(gameLevel, inputHandler, outputHandler);
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
