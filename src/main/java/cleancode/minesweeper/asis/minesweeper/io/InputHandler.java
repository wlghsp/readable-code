package cleancode.minesweeper.asis.minesweeper.io;

import cleancode.minesweeper.asis.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.asis.minesweeper.user.UserAction;

public interface InputHandler {

    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
