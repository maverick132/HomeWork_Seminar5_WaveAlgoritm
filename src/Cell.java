public class Cell {
    int coordinateX;// ����������� ������� ����������� ����� ������ � 3 ������ ����������� �� ����
    int coordinateY;
    int stepFromStart;

    public Cell(int x, int y, int step) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.stepFromStart = step;
    }

    @Override
    public String toString() {
        return "(" + (this.coordinateX) + "," + (this.coordinateY) + ") " + (this.stepFromStart);
    }
}
