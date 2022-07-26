public class Main {
    public static void main(String[] args) {
        Field field = new Field(9,10);
        field.printField();
        int[][] ar = new int[9][10];



        final int[][] aroundCell = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };


        int startCoordinateX = 5;
        int startCoordinateY = 5;

        ar[startCoordinateX][startCoordinateY] = 0;

        int fieldSize = ar.length * ar[0].length;
        boolean flagAllCellPassed = false;
        int countCell = 0;
        int stepCoordinateX = 0;
        int stepCoordinateY = 0;
        int step = 0;
        int countCellPassed = 0;




//        while (!flagAllCellPassed && countCell < fieldSize) {
//            for (int i = 0; i < 8; i++) {
//                int coodrinateX = startCoordinateX + aroundCell[i][0];
//                int coodrinateY = startCoordinateY + aroundCell[i][1];
//                if (ar[coodrinateX][coodrinateY] == -1 && isValidCoordinates(coodrinateX, coodrinateY, fieldSize)) {
//                    ar[coodrinateX][coodrinateY] = step + 1;
//                    flagAllCellPassed = false;
//                } else if (isValidCoordinates(coodrinateX, coodrinateY, fieldSize)) {
//                    flagAllCellPassed = true;
//                }
//            }
//            countCell++;
//            step++;
//
//
//            if (isValidCoordinates(startCoordinateX, startCoordinateY - 1, fieldSize))
//                startCoordinateY--; // Идем на лево
//            else if (isValidCoordinates(startCoordinateX - 1, startCoordinateY, fieldSize))
//                startCoordinateX--; // Иначе идем вверх
//            else if (isValidCoordinates(startCoordinateX, startCoordinateY + 1, fieldSize))
//                startCoordinateY++; // Иначе идем вниз
//            else if (isValidCoordinates(startCoordinateX + 1, startCoordinateY, fieldSize))
//                startCoordinateX++; //Иначе идем вправо
//
//
////            flagAllCellPassed = true;
//        }


    }





}