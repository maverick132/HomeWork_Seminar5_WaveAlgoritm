import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("log1.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
        file = new File("log2.txt");
        fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        Field fieldMoore = new Field(10, 10);
        fieldMoore.setStartCell(5, 5);
        fieldMoore.setFinalCell(8, 8);
        fieldMoore.printField();
        FindWayMoore.findWay(fieldMoore);
        System.out.println(PathRestoration.pathRestoration(fieldMoore));

        Field fieldNeumann = new Field(10, 10);
        fieldNeumann.setStartCell(0, 0);
        fieldNeumann.setFinalCell(3, 8);
        fieldNeumann.printField();
        FindWayNeumann.findWay(fieldNeumann);
        System.out.println(PathRestoration.pathRestoration(fieldNeumann));

    }



}