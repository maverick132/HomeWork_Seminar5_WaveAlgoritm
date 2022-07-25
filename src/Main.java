public class Main {
    public static void main(String[] args) {
        int[][] ar = new int[9][10];

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j <ar[0].length ; j++) {
                ar[i][j] = -1;
            }
        }
       int startCoordinateI = 5;
       int startCoordinateJ = 5;

       ar[startCoordinateI][startCoordinateJ] = 0;
       printArray(ar);


    }

    /*Метод вывода двумерного массива, матрицы, поля. Метод выравнивает все числа по правому краю*/
    public static void printArray(int[][] ar) {
        int sizeElementsMax=0; // Минимальный размер элемента в массиве.

        for (int[] value : ar) { // Вычисляем длинну наибольшего элемента в массиве
            for (int j = 0; j < ar[0].length; j++) {
                if (String.valueOf(value[j]).length() > sizeElementsMax) {
                    sizeElementsMax = String.valueOf(value[j]).length();
                }
            }

        }
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax)); //Делаем количество пробелов между элементами

        for (int[] ints : ar) {
            for (int j = 0; j < ar[0].length; j++) {
                if (String.valueOf(ints[j]).length() == sizeElementsMax) {
                    System.out.print(ints[j] + space.toString());
                }
                else {
                    System.out.print(" ".repeat(sizeElementsMax - String.valueOf(ints[j]).length()) + ints[j] + space);
                }
            }
            System.out.println();
        }
    }
}