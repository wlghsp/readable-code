package cleancode.minesweeper.asis.minesweeper;

import cleancode.minesweeper.asis.game.GameInitializable;
import cleancode.minesweeper.asis.game.GameRunnable;
import cleancode.minesweeper.asis.minesweeper.board.GameBoard;
import cleancode.minesweeper.asis.minesweeper.board.GameStatus;
import cleancode.minesweeper.asis.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.asis.minesweeper.config.GameConfig;
import cleancode.minesweeper.asis.minesweeper.exception.GameException;
import cleancode.minesweeper.asis.minesweeper.io.InputHandler;
import cleancode.minesweeper.asis.minesweeper.io.OutputHandler;
import cleancode.minesweeper.asis.minesweeper.user.UserAction;

public class MineSweeper implements GameInitializable, GameRunnable {

    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private GameStatus gameStatus;

    public MineSweeper(GameConfig gameConfig) {
        gameBoard = new GameBoard(gameConfig.getGameLevel());
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
        gameStatus = GameStatus.IN_PROGRESS;
    }

    @Override
    public void initialize() {
        gameBoard.initializeGame();
        gameStatus = GameStatus.IN_PROGRESS;
    }

    @Override
    public void run() {
        outputHandler.showGameStartComments();

        while (gameBoard.isInProgress()) {
            try {
                outputHandler.showBoard(gameBoard);

                CellPosition cellPosition = getCellInputFromUser();
                UserAction userAction = getUserActionInputFromUser();
                actOnCell(cellPosition, userAction);

            } catch (GameException e) {
                outputHandler.showExceptionMessage(e);

            } catch (Exception e) {
                outputHandler.showSimpleMessage("프로그램에 문제가 생겼습니다.");
            }
        }

        outputHandler.showBoard(gameBoard);

        if (gameBoard.isWinStatus()) {
            outputHandler.showGameWinningComment();
        }
        if (gameBoard.isLoseStatus()) {
            outputHandler.showGameLosingComment();
        }
    }

    private CellPosition getCellInputFromUser() {
        outputHandler.showCommentForSelectingCell();
        CellPosition cellPosition = inputHandler.getCellPositionFromUser();
        if (gameBoard.isInvalidCellPosition(cellPosition)) {
            throw new GameException("잘못된 좌표를 선택하셨습니다.");
        }
        return cellPosition;
    }

    private UserAction getUserActionInputFromUser() {
        outputHandler.showCommentForUserAction();
        return inputHandler.getUserActionFromUser();
    }


    private void actOnCell(CellPosition cellPosition, UserAction userAction) {

        if (doesUserChooseToPlantFlag(userAction)) {
            gameBoard.flagAt(cellPosition);
            return;
        }

        if (doesUserChooseToOpenCell(userAction)) {
            gameBoard.openAt(cellPosition);
            return;
        }
        throw new GameException("잘못된 번호를 선택하셨습니다.");
    }

    private boolean doesUserChooseToPlantFlag(UserAction userAction) {
        return userAction == UserAction.FLAG;
    }

    private boolean doesUserChooseToOpenCell(UserAction userAction) {
        return userAction == UserAction.OPEN;
    }

}
