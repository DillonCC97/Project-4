/**
 * Created by Dillon on 4/11/2016.
 */
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project4 {

    private static Record[] allRecords = new Record[50000000];
    private static RecordStack epStack = new RecordStack();
    private static RecordStack lpStack = new RecordStack();
    private static RecordQueue queue = new RecordQueue();

    public static Record[] getAllRecords() {
        return allRecords;
    }
    public static RecordStack getEpStack() {
        return epStack;
    }
    public static RecordStack getLpStack() {
        return lpStack;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int recordID = 0;
        String mainMenu = ("" +
                "----------------------------------\n" +
                "1. Add a new album to be repaired\n" +
                "2. View Repair Queue\n" +
                "3. Repair an album\n" +
                "4. Add a new album to be sold\n" +
                "5. View Sales Inventories\n" +
                "6. Sell an LP\n" +
                "7. Sell an EP\n" +
                "8. Import Initial Inventory\n" +
                "9. Exit\n" +
                "----------------------------------\n" +
                "Select Option: ");

        Scanner s = new Scanner(System.in);
        System.out.println("Hello Lucy, What would you like to do?:");
        while (true) {
            System.out.print(mainMenu);
            int userInput = s.nextInt();


            switch (userInput) {
                case 1: //Add a new album to be repaired
                    System.out.print("\nIs the album an EP or LP: ");
                    String userInput1 =  s.next();
                    if (!(userInput1.equals("EP") || userInput1.equals("LP"))) {
                        System.out.println("Invalid Input: Please try again");
                        continue;
                    }

                    System.out.print("Input the Title of the album: ");
                    s.nextLine();
                    String albumTitle = s.nextLine();
                    System.out.print("Input the Artist of the album: ");
                    String albumArtist = s.nextLine();
                    System.out.print("Input the Year of the album's release: ");
                    int albumYear = s.nextInt();

                    if (userInput1.equals("EP")) {
                        allRecords[recordID] = new Record.EP(albumTitle, albumArtist, albumYear, recordID);
                        queue.getRepairQueue().add(allRecords[recordID]);
                        recordID++;
                    } else if (userInput1.equals("LP")) {
                        allRecords[recordID] = new Record.LP(albumTitle, albumArtist, albumYear, recordID);
                        queue.getRepairQueue().add(allRecords[recordID]);
                        recordID++;
                    }
                    break;


                case 3: //Repair an album
                    Record album2Repair = queue.getRepairQueue().remove();
                    if (album2Repair instanceof Record.EP){
                        System.out.println("Repairing EP: " + album2Repair);
                        epStack.addRecord(album2Repair);
                    }
                    break;


                case 2: //View Repair Queue
                    System.out.println("Albums that need to be repaired: ");
                    System.out.println(queue);
                    System.out.println("");
                    break;


                case 4: //Add a new album to be sold
                    System.out.print("\nIs the album an EP or LP: ");
                    String userInput2 =  s.next();
                    if (!(userInput2.equals("EP") || userInput2.equals("LP"))) {
                        System.out.println("Invalid Input: Please try again");
                        continue;
                    }

                    System.out.print("Input the Title of the album: ");
                    String albumTitle1 = s.next();
                    System.out.print("Input the Artist of the album: ");
                    s.nextLine();
                    String albumArtist1 = s.nextLine();
                    System.out.print("Input the Year of the album's release: ");
                    int albumYear1 = s.nextInt();

                    if (userInput2.equals("EP")) {
                        allRecords[recordID] = new Record.EP(albumTitle1, albumArtist1, albumYear1, recordID);
                        epStack.addRecord(allRecords[recordID]);
                        recordID++;
                    } else if (userInput2.equals("LP")) {
                        allRecords[recordID] = new Record.LP(albumTitle1, albumArtist1, albumYear1, recordID);
                        lpStack.addRecord(allRecords[recordID]);
                        recordID++;
                    }
                    break;


                case 6: //Sell an LP
                    if (!(lpStack.isEmpty())) {
                        Record lp2Sell = lpStack.sellRecord();
                        System.out.println("Selling: " + lp2Sell);
                    } else {
                        System.out.println("There are no LPs to sell!");
                    }
                    break;


                case 7: //Sell an EP
                    if (!(epStack.isEmpty())) {
                        Record ep2Sell = epStack.sellRecord();
                        System.out.println("Selling: " + ep2Sell);
                    } else {
                        System.out.println("There are no EPs to sell!");
                    }
                    break;


                case 5: //View Sales Inventories
                    System.out.println("EPs available for sale: ");
                    System.out.println(epStack);
                    System.out.println("LPs available for sale: ");
                    System.out.println(lpStack);
                    break;


                case 9: //Exit Program
                    System.out.println("Goodbye, exiting program . . .");
                    System.exit(0);
                    break;


                case 8: //Import inventory from text file
                    Import.ImportInventory();
            }
        }
    }
}
