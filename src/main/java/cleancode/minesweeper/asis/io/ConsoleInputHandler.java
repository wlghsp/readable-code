package cleancode.minesweeper.asis.io;

import cleancode.minesweeper.asis.BoardIndexConverter;
import cleancode.minesweeper.asis.position.CellPosition;
import cleancode.minesweeper.asis.user.UserAction;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);

    private final BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

    @Override
    public UserAction getUserActionFromUser() {
        String userInput = SCANNER.nextLine();

        if ("1".equals(userInput)) {
            return UserAction.OPEN;
        }

        if ("2".equals(userInput)) {
            return UserAction.FLAG;
        }

        return UserAction.UNKNOWN;
    }

    @Override
    public CellPosition getCellPositionFromUser() {
        String userInput = SCANNER.nextLine();

        int rowIndex = boardIndexConverter.getSelectedRowIndex(userInput);
        int colIndex = boardIndexConverter.getSelectedColIndex(userInput);
        return CellPosition.of(rowIndex, colIndex);
    }
}
