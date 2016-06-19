/**
 * Created by Dillon on 4/11/2016.
 */

import java.util.Stack;

public class RecordStack {
    private Stack<Record> recordStack = new Stack<>();

    public void addRecord(Record record2add) {
        this.recordStack.push(record2add);
    }

    public Record sellRecord() {
        return this.recordStack.pop();
    }

    public boolean isEmpty() {
        if (this.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String printString = "";
        int recordNum = 1;
        for (Record record:recordStack) {
            printString += recordNum + ". " + record;
            recordNum++;
        }
        return printString;
    }
}