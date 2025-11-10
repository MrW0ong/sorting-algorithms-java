import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class DataLoader {
    public List<Double> loadData(String filePath) throws FileNotFoundException {
        List<Double> alcohol = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(filePath))) {

            if (sc.hasNextLine()) sc.nextLine(); // skip header

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isBlank()) continue;

                String[] values = line.split(";");
                String s = values[10].trim();
                if (s.isEmpty()) continue;

                double alc = Double.parseDouble(s);
                alcohol.add(alc);

            }
        } return alcohol;
    }
}
