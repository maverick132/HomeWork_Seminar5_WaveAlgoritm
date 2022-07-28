import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("print.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        Field field = new Field(9, 10);
        field.setStartCell(5, 5);
        field.setFinalCell(8, 8);
        field.printField();
        FindFinalCell.findWay(field);
        System.out.println(PathRestoration.pathRestoration(field));

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




}