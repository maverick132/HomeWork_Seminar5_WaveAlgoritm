public class Cell {
    int coordinateX;// попробовать сделать абстрактный класс ячейки и 3 класса наследуемых от него
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
