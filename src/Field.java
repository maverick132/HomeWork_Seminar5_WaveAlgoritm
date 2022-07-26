public class Field {
    int sizeWidth;
    int sizeHeight;
    Cell[][] Field;

    public Field(int sizeHeight, int sizeWidth) {
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        this.Field = new Cell[sizeHeight][sizeWidth];
        for (int i = 0; i < sizeHeight; i++) {
            for (int j = 0; j < sizeWidth; j++) {
                Cell cell = new Cell(i, j, -1);
                Field[i][j] = cell;
            }
        }
        System.out.printf("Field %d x %d created.\n", sizeHeight, sizeWidth);
    }

    /**
     * ����� ������ ����.
     **/
    public void printField() {
        int sizeElementsMax = 0; // ����������� ������ ������.

        for (Cell[] value : Field) { // ��������� ����� ����������� �������� � �������
            for (int i = 0; i < value.length; i++) {
                if (String.valueOf(value[i].stepToStart).length() > sizeElementsMax) {
                    sizeElementsMax = String.valueOf(value[i].stepToStart).length();
                }
            }
        }
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax)); //������ ���������� �������� ����� ����������

        for (Cell[] value : Field) { // ��������� ����� ����������� �������� � �������
            for (int i = 0; i < value.length; i++) {
                if (String.valueOf(value[i].stepToStart).length() == sizeElementsMax) {
                    System.out.print(value[i].stepToStart + space.toString());
                } else {
                    System.out.print(" ".repeat(sizeElementsMax - String.valueOf(value[i].stepToStart).length()) + value[i].stepToStart + space);
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * ��������� �������� ��������� ����� {x,y} �� �������������� ���� �������� sizeField
     * (�������� �� ������� �� �� ������� ����)
     **/
    public boolean isValidCoordinates(int x, int y, int sizeWidth, int sizeHeight) {
        return x >= 0 && x < sizeWidth && y >= 0 && y < sizeHeight;
    }
}
