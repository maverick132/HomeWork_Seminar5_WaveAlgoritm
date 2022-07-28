public class PathRestoration {

    final static int[][] aroundCell = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public static String pathRestoration(Field field) {

        StringBuilder wayToStart = new StringBuilder();
        boolean isWayFind = false;
        boolean isWayCantFound = false;
        Cell cellNow = new Cell(field.getFinalCell().coordinateX, field.getFinalCell().coordinateY, field.getFinalCell().stepFromStart);
        while (!isWayFind && !isWayCantFound) {
            int x = cellNow.coordinateX;
            int y = cellNow.coordinateY;
            int stepNow = cellNow.stepFromStart;
            int count = 0;
            if (stepNow != 0) {
                int minStepAround = stepNow;
                for (int i = 0; i < 8; i++) {
                    if (field.isValidCoordinates(x + aroundCell[i][0], y + aroundCell[i][1])){
                        if (field.getCell(x + aroundCell[i][0], y + aroundCell[i][1]).stepFromStart + 1 == minStepAround) { //ѕереопределить метод сравнени€ €чеек
                            cellNow.coordinateX = field.getCell(x + aroundCell[i][0], y + aroundCell[i][1]).coordinateX;
                            cellNow.coordinateY = field.getCell(x + aroundCell[i][0], y + aroundCell[i][1]).coordinateY;
                            cellNow.stepFromStart = field.getCell(x + aroundCell[i][0], y + aroundCell[i][1]).stepFromStart;
                            count++;
                            minStepAround = cellNow.stepFromStart;
                        }
                    }

                }
                if (count > 0) {
                    stepNow = cellNow.stepFromStart;
                    wayToStart.append("(").append(cellNow.coordinateX).append(",").append(cellNow.coordinateY).append(")");
                } else {
                    isWayCantFound = true;
                }
            } if (stepNow == 0) {
                isWayFind = true;
            }
        }
        if (isWayFind) {
            return wayToStart.toString();
        }
        else {
            return "Way cant found";
        }
    }
}
