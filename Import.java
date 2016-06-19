/**
 * Created by Dillon on 4/12/2016.
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Import {
    public static void ImportInventory() throws FileNotFoundException{
        int recordID = 0;
        System.out.print("Input the name of the text file: ");
        Scanner s = new Scanner(System.in);
        String fileName = s.next();
        File inventory = new File(fileName);
        Scanner fileScan = new Scanner(inventory);

        while (fileScan.hasNextLine()){
            Scanner lineScanner = new Scanner(fileScan.nextLine()).useDelimiter(",");
            String artist = lineScanner.next().trim();
            String title = lineScanner.next().trim();
            String yearString = lineScanner.next().trim();
            int year = Integer.parseInt(yearString);
            String type = lineScanner.next().trim();

            if (type.equals("EP")) {
                Project4.getAllRecords()[recordID] = new Record.EP(title, artist, year, recordID);
                Project4.getEpStack().addRecord(Project4.getAllRecords()[recordID]);
                recordID++;
            } else if (type.equals("LP")){
                Project4.getAllRecords()[recordID] = new Record.EP(title, artist, year, recordID);
                Project4.getLpStack().addRecord(Project4.getAllRecords()[recordID]);
                recordID++;
            }
        }
    }
}