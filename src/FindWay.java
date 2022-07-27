import java.io.IOException;

public class FindWay {
    final static int[][] aroundCell = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    static int countCell = 0;
    static int step = 0;
    static boolean isFinalCellFind = false;


    public static void FindWay(Field field, Cell startCell) throws IOException {
        if (field.getFinalCell().stepFromStart != -2) {
            field.getFinalCell().stepFromStart = ++step;
            isFinalCellFind = true;
//            return " " + field.getFinalCell().stepFromStart;
        } else {
            step++;
            for (int i = 0; i < 8; i++) {
                int x = startCell.coordinateX + aroundCell[i][0];
                int y = startCell.coordinateY + aroundCell[i][1];
                if (field.isValidCoordinates(x,y)){
                    if (field.getCell(x,y).stepFromStart == -1) {
                        field.setCell(x, y, step);
                        field.printFieldToFile();
                    }
//                    else {
//                        step--;
//                        return;
//                    }
                }

            }
            for (int i = 0; i < 8; i++) {
                int x = startCell.coordinateX + aroundCell[i][0];
                int y = startCell.coordinateY + aroundCell[i][1];
                if (field.isValidCoordinates(x,y)) {
                    Cell cellNow = new Cell(x, y, step);
                    FindWay(field, cellNow);
                }
            }


//            return " " + step;
        }
    }
}
