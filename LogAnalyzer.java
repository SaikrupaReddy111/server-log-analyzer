import java.io.*;
import java.util.*;

public class LogAnalyzer {

    ArrayList<String> errors = new ArrayList<>();
    ArrayList<String> warnings = new ArrayList<>();

    int totalLogs = 0;


    public void readLogs(String fileName) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String line;


            while ((line = reader.readLine()) != null) {

                totalLogs++;

                if (line.contains("ERROR")) {
                    errors.add(line);
                }

                else if (line.contains("WARNING")) {
                    warnings.add(line);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Cannot read log file");
        }
    }


    public void generateReport() {

        System.out.println("\n===== SERVER LOG REPORT =====");

        System.out.println("Total Logs: " + totalLogs);


        System.out.println("\nERRORS:");

        if(errors.isEmpty()) {
            System.out.println("No errors found");
        }

        for(String error : errors) {
            System.out.println(error);
        }


        System.out.println("\nWARNINGS:");

        if(warnings.isEmpty()) {
            System.out.println("No warnings found");
        }

        for(String warning : warnings) {
            System.out.println(warning);
        }


        if(errors.size() > 0) {
            System.out.println("\nSTATUS: NEEDS ATTENTION");
        }
        else {
            System.out.println("\nSTATUS: HEALTHY");
        }
    }
}
