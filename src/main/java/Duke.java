import errorHandle.DukeException;
import errorHandle.ErrorString;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import task.DeadLine;
import task.Event;
import task.Task;
import task.ToDo;


public class Duke {

    private ArrayList<Task> taskLst = new ArrayList<>();

    public void greet() {

        String intro = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        intro += "    Hello! I'm Bobby\n";
        intro += "    What can I do for you?\n";
        echo(intro);
    }

    public void echo(String data) {
        String line = "    ____________________________________________________________\n";
        String toDisplay = line + data + line;
        System.out.println(toDisplay);
    }

    public void exit() {
        echo("    Bye. Hope to see you again soon!\n");
    }


    public String extractDesc(String data, String start, String timeCommand) {

        int startIndex = data.indexOf(start) + start.length();
        if (timeCommand == null) {
            return data.substring(startIndex);
        } else {
            int endIndex = data.indexOf(timeCommand);
            return data.substring(startIndex, endIndex - 1);
        }
    }

    public String extractTime(String data, String timeCommand) {
        int startIndex = data.indexOf(timeCommand) + timeCommand.length();
        return data.substring(startIndex);

    }

    public void addToList(String data, String taskCommand) throws DukeException {
        Task task = null;

        String[] temp = data.split(" ");

        if (taskCommand.equals("todo")) {

            if (temp.length == 1) {
                throw new DukeException(ErrorString.ERROR_EMPTY_TODO_DESC.toString());
            }

            String desc = extractDesc(data, "todo ", null);
            task = new ToDo(desc);

        } else if (taskCommand.equals("deadline")) {

            if ((temp.length == 1) || (temp[1].equals("/by"))) {
                throw new DukeException(ErrorString.ERROR_EMPTY_DEADLINE_DESC.toString());
            }

            if (!data.contains("/by")) {
                throw new DukeException(ErrorString.ERROR_EMPTY_DEADLINE_DATE.toString());
            }

            String desc = extractDesc(data, "deadline ", "/by");
            String date = extractTime(data,"/by ");
            task = new DeadLine(desc, date);

        }  else {

            // Event handling

            if ((temp.length == 1) || (temp[1].equals("/at"))) {
                throw new DukeException(ErrorString.ERROR_EMPTY_EVENT_DESC.toString());
            }

            if (!data.contains("/at")) {
                throw new DukeException(ErrorString.ERROR_EMPTY_EVENT_DATE.toString());
            }

            String desc = extractDesc(data, "event ", "/at");
            String date = extractTime(data,"/at ");
            task = new Event(desc, date);

        }

        // Adding task
        this.taskLst.add(task);
        String output = String.format("     Got it. I've added this task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", task.toString(), taskLst.size());
        echo(output);
        save();
    }

    public void deleteTask(String input) throws DukeException {
        Integer i = null;

        try {
            i = Integer.parseInt(input.substring("delete".length() + 1));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(ErrorString.ERROR_EMPTY_DELETE.toString());
        }

        Task toDel = retrieveTask(i);

        String output = String.format("     Noted. I've removed this task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", toDel.toString(), taskLst.size());
        echo(output);
        save();
    }

    public void displayList() {
        String output = "     Here are the tasks in your list:\n";
        int numItemsLst = this.taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += "     " + (i + 1) + "." + this.taskLst.get(i).toString() + "\n";
        }
        echo(output);
    }

    public Task retrieveTask(int i) throws DukeException {
        Task selectedTask = null;
        try {
            selectedTask = this.taskLst.get(i - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(ErrorString.ERROR_INDEX_OUT_OF_BOUND_TASK.toString());
        }
        return selectedTask;
    }

    public void markOrUnmarked(String action, String input) throws DukeException {
        String output = "";

        Integer i = null;
        try {
            // Also can check if user specify an int or char
            i = Integer.parseInt(input.substring(action.length() + 1));
        } catch (IndexOutOfBoundsException e) {
            if (action.equals("mark")) {
                throw new DukeException(ErrorString.ERROR_EMPTY_MARK_INT.toString());
            } else {
                throw new DukeException(ErrorString.ERROR_EMPTY_UNMARKED_INT.toString());
            }
        } catch (NumberFormatException e) {
            if (action.equals("mark")) {
                throw new DukeException(ErrorString.ERROR_NOT_INT_MARK.toString());
            } else {
                throw new DukeException(ErrorString.ERROR_NOT_INT_UNMARKED.toString());
            }
        }

        Task selectedTask = retrieveTask(i);

        if (action.equals("mark")) {
            output += "     Nice! I've marked this task as done:\n";
            selectedTask.markAsDone();

        } else {
            output += "     OK, I've marked this task as not done yet:\n";
            selectedTask.undoDone();
        }
        output += "       " + selectedTask.toString() + "\n";
        echo(output);
        save();
    }

    public void save() throws DukeException {
        // only invoke when task list is changed

        // Check if dir exists
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Get tasks to export
        String output = "";
        int numItemsLst = this.taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += this.taskLst.get(i).toStringForStorage() + "\n";
        }

        FileWriter myWriter = null;
        try {

            // FileWriter handles the missing file duke.txt,
            // if the file does not exist, it will create it
            // if the file exists, we will overwrite it with the updates task

            myWriter = new FileWriter("data/duke.txt", false);
            myWriter.write(output);
            myWriter.close();
        } catch (IOException e) {
            throw new DukeException(ErrorString.ERROR_FILE_IO_ERROR.toString());
        }
    }

    public void load() {

        File file = new File ("data/duke.txt");

        // Check if file exists

        FileReader myReader = null;
        if (file.exists()) {
            try {
                myReader = new FileReader("data/duke.txt");
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
                    this.taskLst.add(currTask);
                }
            } catch (IOException e) {
                throw new DukeException(ErrorString.ERROR_FILE_IO_ERROR.toString());
            }
         }
    }

    public static void main(String[] args) throws DukeException {

        Duke bobby = new Duke();
        bobby.greet();
        bobby.load();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            try {
                if (input.equals("list")) {
                    bobby.displayList();
                } else if (input.startsWith("mark")) {
                    bobby.markOrUnmarked("mark", input);
                } else if (input.startsWith("unmark")) {
                    bobby.markOrUnmarked("unmark",input);
                } else if (input.startsWith("delete")) {
                    bobby.deleteTask(input);
                } else if (input.startsWith("todo")) {
                    bobby.addToList(input, "todo");
                } else if (input.startsWith("deadline")) {
                    bobby.addToList(input, "deadline");
                } else if (input.startsWith("event")) {
                    bobby.addToList(input, "event");
                } else {
                    throw new DukeException(ErrorString.ERROR_INVALID_COMMAND.toString());
                }
            } catch (DukeException e) {
                bobby.echo(e.getMessage());
            } finally {
                input = sc.nextLine();
            }
        }

        bobby.exit();
        sc.close();
    }
}
