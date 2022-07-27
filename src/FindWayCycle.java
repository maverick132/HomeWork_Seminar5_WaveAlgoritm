import java.io.IOException;

public class FindWayCycle {
    final static int[][] aroundCell = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    static int step = 0;
    static int stepWave;
    static boolean isFinalCellFind = false;
    static boolean isUp, isDown, isLeft, isRight;
    static int count = 0;

    public static void findWay(Field field) throws IOException {
        int x = field.startCell.coordinateX;
        int y = field.startCell.coordinateY;
        int borderLeft = y - 1;
        int borderRight = y + 1;
        int borderUp = x - 1;
        int borderDown = x + 1;
        int numCircle = 1;
        int count = 0;


        while (!isFinalCellFind) {
            if (field.getFinalCell().stepFromStart != -2) {
                isFinalCellFind = true;
            } else {

                count++;
                if (x >= 0 && x < field.sizeHeight && y >= 0 && y < field.sizeWidth) {
                    if (field.getCell(x, y).stepFromStart == -1) {
                        field.setCell(x, y, step + 1);
                        field.printFieldToFile();
                    } else if (field.getCell(x, y).stepFromStart == -2) {
                        field.setCell(x, y, step + 1);
                        field.printFieldToFile();
                        isFinalCellFind = true;
                    }
                }

                if (y > borderLeft && x == borderDown) y--;
                else if (x > borderUp && y == borderLeft) x--;
                else if (y < borderRight && x == borderUp) y++;
                else x++;

                if (count == numCircle * 8 +1) {
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

    }


    public static void fill2d(Field field, int x, int y) {
        int a = y - 1;
        int b = y + 1;
        int d = x - 1;
        int c = x + 1;
        int number = 1;
        int numCircle = 1;
        int count = 0;

        while (number <= 200) {
            count++;
            if (x >= 0 && x < field.sizeHeight && y >= 0 && y < field.sizeWidth) {
                field.setCell(x, y, number);
            }

            if (y > a && x == c) y--;
            else if (x > d && y == a) x--;
            else if (y < b && x == d) y++;
            else x++;

            if (count == numCircle * 8) {
                count = 0;
                a--;
                b++;
                d--;
                c++;
                numCircle++;
            }

            number++;
        }
    }


//    public static void  fill2d(Field field, int numberRectangle) {
////        int numberRectangle = 0;
//        boolean flag = false;
//        int i = numberRectangle;
//        int j = numberRectangle;
//        int row = field.sizeHeight;
//        int column = field.sizeWidth;
//        int number = 1;
//
//        while (number <= column * row || !flag) {
//            field.setCell(i,j, number);
//            if (i == numberRectangle && j < column - numberRectangle - 1) j++;
//            else if (j == column - numberRectangle - 1 && i < row - numberRectangle - 1) i++;
//            else if (i == row - numberRectangle - 1 && j > numberRectangle) j--;
//            else i--;
//
//            if (i == numberRectangle + 1 && j ==numberRectangle && numberRectangle != column -numberRectangle -1) {
//                flag = true;
//            }
//            number++;
//        }
//    }

    public static void fillAroundCell(Field field, Cell cell, int step) throws IOException {
        for (int i = 0; i < 8; i++) {
            int x = cell.coordinateX + aroundCell[i][0];
            int y = cell.coordinateY + aroundCell[i][1];
            if (field.isValidCoordinates(x, y)) {
                if (field.getCell(x, y).stepFromStart == -1) {
                    field.setCell(x, y, step);
                    field.printFieldToFile();
                } else if (field.getCell(x, y).stepFromStart == -2) {
                    isFinalCellFind = true;
                }
            }
        }
    }
}
