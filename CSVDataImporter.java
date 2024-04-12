import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVImporter {
    public List<String[]> importCSV(String filePath, String delimiter) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(delimiter);
                records.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    public static void main(String[] args) {
        CSVImporter csvImporter = new CSVImporter();

        String filePath = "data.csv";
        String delimiter = ",";

        List<String[]> records = csvImporter.importCSV(filePath, delimiter);

        // Print the imported records
        for (String[] fields : records) {
            for (String field : fields) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }
}
