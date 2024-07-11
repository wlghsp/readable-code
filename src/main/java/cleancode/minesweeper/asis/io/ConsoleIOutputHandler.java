package cleancode.minesweeper.asis.io;

import cleancode.minesweeper.asis.Cell;

public class ConsoleIOutputHandler {

    public void showGameStartComments() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void showBoard(Cell[][] board) {
        System.out.println("   a b c d e f g h i j");
        for (int row = 0; row < board.length; row++) {
            System.out.printf("%d  ", row + 1);
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col].getSign() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printGameWinningComment() {
        System.out.println("지뢰를 모두 찾았습니다. GAME CLEAR!");
    }

    public void printGameLosingComment() {
        System.out.println("지뢰를 밟았습니다. GAME OVER!");
    }

    public void printCommentForSelectingCell() {
        System.out.println("선택할 좌표를 입력하세요. (예: a1)");
    }
}
