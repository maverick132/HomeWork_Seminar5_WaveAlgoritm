import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Field field = new Field(9, 10);
        field.setStartCell(5, 5);
        field.setFinalCell(8, 8);
        field.printField();
        FindWayCycle.findWay(field);

//        boolean isFinalCell = false;
//        int countCell = 0;
//        Cell cellNow = field.getStartCell();
//        System.out.println(cellNow);
////        FindWay fw = new FindWay();
//        FindWay.FindWay(field, field.getStartCell());
//        System.out.println();


        final int[][] aroundCell = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
//        Field field1 = new Field(8, 8);
//        FindWayCycle.fill2d(field1, 2,2,2);
//        Main.fill2d(field1, 2, 2);
//        field1.printField();


    }

//    public static void  fill2d(int[][] ar, int x,int y) {
//        int numberRectangle = 0;
//        int i = 0;//3 строки [строки, Height,y][столбцы, Width, x]
//        int j = 0;//8 столбцы
//        int N = ar[0].length; //8 столбцы
//        int M = ar.length; //3 строки
//        int number = 1;
//
//        while (number <= N * M) {
//            ar[i][j] = number;
//
//            if (i == numberRectangle && j < N - numberRectangle - 1) j++;
//            else if (j == N - numberRectangle - 1 && i < M - numberRectangle - 1) i++;
//            else if (i == M - numberRectangle - 1 && j > numberRectangle) j--;
//            else i--;
//
//            if (i ==numberRectangle +1 && j ==numberRectangle && numberRectangle != N -numberRectangle -1) {
//                numberRectangle++;
//            }
//            number++;
//        }
//    }

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
            if (x >= 0 && x< field.sizeHeight && y >= 0 && y <field.sizeWidth){
                field.setCell(x, y, number);
            }

            if (y > a && x == c) y--;
            else if (x > d && y == a) x--;
            else if (y < b && x == d) y++;
            else x++;

            if (count == numCircle * 8 +1) {
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


}