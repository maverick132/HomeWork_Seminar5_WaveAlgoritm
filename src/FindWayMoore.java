import java.io.IOException;

public class FindWayMoore {

    final static int[][] cellAroundMoore = { // Реализация Окрестности Мура
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static int step = 0;
    static boolean isFinalCellFind = false;

    public static void findWay(Field field) throws IOException {
        int x = field.startCell.coordinateX;
        int y = field.startCell.coordinateY;
        Cell cell = field.startCell.copy();
        int borderLeft = y - 1;
        int borderRight = y + 1;
        int borderUp = x - 1;
        int borderDown = x + 1;
        int numCircle = 1;
        int count = 0;

        while (!isFinalCellFind) {
            cell.coordinateX = x;
            cell.coordinateY = y;
            count++;
            if (field.isValidCoordinates(x, y)) {
                cell.stepFromStart = field.getCell(x, y).stepFromStart;
                fillCellAroundMoore(field, cell);
                field.printFieldToFile(1);
            }

            if (y > borderLeft && x == borderDown) y--;
            else if (x > borderUp && y == borderLeft) x--;
            else if (y < borderRight && x == borderUp) y++;
            else x++;

            if (count == numCircle * 8 + 1) {
                count = 0;
                borderLeft--;
                borderRight++;
                borderUp--;
                borderDown++;
                numCircle++;
                step++;
            }
        }

    }

    public static void fillCellAroundMoore(Field field, Cell cell) {
        for (int i = 0; i < 8; i++) {
            int x = cell.coordinateX + cellAroundMoore[i][0];
            int y = cell.coordinateY + cellAroundMoore[i][1];
            if (field.isValidCoordinates(x, y)) {
                if (field.getCell(x, y).stepFromStart == -1) {
                    field.setCell(x, y, cell.stepFromStart + 1);
                } else if (field.getCell(x, y).stepFromStart == -2) {
                    field.setCell(x, y, cell.stepFromStart + 1);
                    isFinalCellFind = true;
                }
            }
        }
    }

}
