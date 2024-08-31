package cleancode.minesweeper.asis.minesweeper.io;

import cleancode.minesweeper.asis.minesweeper.board.GameBoard;

public interface OutputHandler {

    void showGameStartComments();

    void showBoard(GameBoard board);

    void showGameWinningComment();

    void showGameLosingComment();

    void showCommentForSelectingCell();

    void showCommentForUserAction();

    void showExceptionMessage(Exception e);

    void showSimpleMessage(String message);
}
