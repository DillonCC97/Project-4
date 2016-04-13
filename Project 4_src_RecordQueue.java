import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Dillon on 4/11/2016.
 */
public class RecordQueue{
    public Queue<Record> getRepairQueue() {
        return repairQueue;
    }

    private Queue<Record> repairQueue = new PriorityQueue<>();

    public String toString() {
        String printString = "";
        int recordNum = 1;
        for (Record record:repairQueue) {
            printString += recordNum + ". " + record.getTitle() + " by " + record.getArtist() + " (" + record.getYear() +")\n";
            recordNum++;
        }
        return printString;
    }
}