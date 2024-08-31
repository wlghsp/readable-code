package cleancode.minesweeper.asis.minesweeper.io.sign;

import cleancode.minesweeper.asis.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.asis.minesweeper.board.cell.CellSnapshotStatus;

public class NumberCellSignProvider implements CellSignProvidable {

    @Override
    public boolean supports(CellSnapshot cellSnapshot) {
        return cellSnapshot.isSameStatus(CellSnapshotStatus.NUMBER);
    }

    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return String.valueOf(cellSnapshot.getNearbyLandMineCount());
    }
}
