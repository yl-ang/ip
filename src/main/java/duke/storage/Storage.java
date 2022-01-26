package duke.storage;

import duke.error.DukeException;
import duke.error.ErrorString;
import duke.task.DeadLine;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(ArrayList<Task> taskLst) throws DukeException {
        // only invoke when duke.task list is changed

        // Check if dir exists
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Get tasks to export
        String output = "";
        int numItemsLst = taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += taskLst.get(i).toStringForStorage() + "\n";
        }

        FileWriter myWriter = null;
        try {

            // FileWriter handles the missing file duke.txt,
            // if the file does not exist, it will create it
            // if the file exists, we will overwrite it with the updates duke.task

            myWriter = new FileWriter(this.filePath, false);
            myWriter.write(output);
            myWriter.close();
        } catch (IOException e) {
            throw new DukeException(ErrorString.ERROR_FILE_IO_ERROR.toString());
        }
    }

    public ArrayList<Task> load() {

        File file = new File (this.filePath);

        // Check if file exists

        ArrayList<Task> taskLst = new ArrayList<Task>();

        FileReader myReader = null;
        if (file.exists()) {
            try {
                myReader = new FileReader(this.filePath);
                BufferedReader inStream = new BufferedReader(myReader);

                String inString;


                while ((inString = inStream.readLine()) != null) {
                    String[] taskString = inString.split(" \\| ");

                    Task currTask = null;

                    switch(taskString[0]) {
                        case "T":
                            currTask = new ToDo(taskString[2]);
                            break;
                        case "D":
                            currTask = new DeadLine(taskString[2], taskString[3]);
                            break;
                        case "E":
                            currTask = new Event(taskString[2], taskString[3]);
                            break;
                    }

                    if (taskString[1].equals("1")) {
                        currTask.markAsDone();
                    }

                    taskLst.add(currTask);
                }
            } catch (IOException e) {
                throw new DukeException(ErrorString.ERROR_FILE_IO_ERROR.toString());
            }
        }
        return taskLst;
    }
}
