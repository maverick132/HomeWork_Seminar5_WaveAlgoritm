import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Field {
    int sizeWidth;
    int sizeHeight;
    int size;
    Cell[][] Field;
    Cell startCell;
    Cell finalCell;

    public Field(int sizeHeight, int sizeWidth) {
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
        this.size = sizeHeight * sizeWidth;
        this.Field = new Cell[sizeHeight][sizeWidth];
        for (int i = 0; i < sizeHeight; i++) {
            for (int j = 0; j < sizeWidth; j++) {
                Cell cell = new Cell(i, j, -1);
                this.Field[i][j] = cell;
            }
        }
        System.out.printf("Field %d x %d created.\n", sizeHeight, sizeWidth);
    }

    /**
     * ????? ?????? ????.
     **/
    public void printField() {
        int sizeElementsMax = 0; // ??????????? ?????? ??????.

        for (Cell[] value : Field) { // ????????? ????? ??????????? ???????? ? ???????
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() > sizeElementsMax) {
                    sizeElementsMax = String.valueOf(cell.stepFromStart).length();
                }
            }
        }
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax)); //?????? ?????????? ???????? ????? ??????????

        for (Cell[] value : this.Field) { // ????????? ????? ??????????? ???????? ? ???????
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() == sizeElementsMax) {
                    System.out.print(cell.stepFromStart + space.toString());
                } else {
                    System.out.print(" ".repeat(sizeElementsMax - String.valueOf(cell.stepFromStart).length()) + cell.stepFromStart + space);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printFieldToFile(int countFileNum) throws IOException {
        File file = new File("log" + countFileNum++ + ".txt");
        FileWriter fileWriter = new FileWriter(file, true);

        int sizeElementsMax = 0; // ??????????? ?????? ??????.

        for (Cell[] value : Field) { // ????????? ????? ??????????? ???????? ? ???????
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() > sizeElementsMax) {
                    sizeElementsMax = String.valueOf(cell.stepFromStart).length();
                }
            }
        }
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(sizeElementsMax)); //?????? ?????????? ???????? ????? ??????????

        for (Cell[] value : this.Field) { // ????????? ????? ??????????? ???????? ? ???????
            for (Cell cell : value) {
                if (String.valueOf(cell.stepFromStart).length() == sizeElementsMax) {
                    fileWriter.write(cell.stepFromStart + space.toString());
                } else {
                    fileWriter.write(" ".repeat(sizeElementsMax - String.valueOf(cell.stepFromStart).length()) + cell.stepFromStart + space);
                }
            }
            fileWriter.write("\n");
        }

        fileWriter.write("\n");
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * ????????? ???????? ????????? ????? {x,y} ?? ?????????????? ???? ???????? sizeField
     * (???????? ?? ??????? ?? ?? ??????? ????)
     **/
    public boolean isValidCoordinates(int coordinateX, int coordinateY) {
        return coordinateX >= 0 && coordinateX < this.sizeHeight && coordinateY >= 0 && coordinateY < this.sizeWidth;
    }

    public void setStartCell(int coordinateX, int coordinateY) {
        this.startCell = this.getCell(coordinateX, coordinateY);
        this.startCell.stepFromStart = 0;
    }

    public void setFinalCell(int coordinateX, int coordinateY) {
        this.finalCell = this.getCell(coordinateX, coordinateY);
        this.finalCell.stepFromStart = -2;
    }

    public Cell getStartCell() {
        return startCell;
    }

    public Cell getFinalCell() {
        return finalCell;
    }

    public Cell getCell(int coordinateX, int coordinateY) {
        return this.Field[coordinateX][coordinateY];
    }

    public void setCell(int coordinateX, int coordinateY, int step) {
        if (isValidCoordinates(coordinateX, coordinateY)) {
            this.Field[coordinateX][coordinateY].stepFromStart = step;
        }
    }
}
