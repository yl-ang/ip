import java.util.ArrayList;
import java.util.Scanner;
import task.*;

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

    public void addToList(String data) {
        Task task = null;
        try {
            String type = (data.startsWith("todo")
                    ? "T" : (data.startsWith("deadline")
                    ? "D" : "E"));

            if (type.equals("T")) {
                task = new ToDo(data);
            } else if (type.equals("D")) {
                String desc = extractStr(data, "deadline ", "/");
                String date = extractStr(data,"by ", null);
                task = new DeadLine(desc, date);
            } else {
                String desc = extractStr(data, "event ", "/");
                String date = extractStr(data,"at ", null);
                task = new Event(desc, date);
            }

            this.taskLst.add(task);

        } catch (Exception e) {
            System.out.println("    Exception occurred");
        }
        String output = "     Got it. I've added this task:\n";
        output += "       " + task.toString() + "\n";
        output += "     Now you have " + this.taskLst.size() +" tasks in the list.\n";
        echo(output);
    }

    public void displayList() {
        String output = "     Here are the tasks in your list:\n";
        int numItemsLst = this.taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += "     " + (i + 1) + "." + this.taskLst.get(i).toString() + "\n";
        }
        echo(output);
    }

    public Task retrieveTask(int i) {
        Task selectedTask = null;
        try {
            selectedTask = this.taskLst.get(i - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please specify an valid index to mark or unmarked");
            System.exit(1);
        }
        return selectedTask;
    }

    public void markOrUnmarked(String action, int i) {
        String output = "";

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
    }

    public String extractStr(String data, String start, String end) {
        int startIndex = data.indexOf(start) + start.length();
        if (end == null) {
            return data.substring(startIndex);
        } else {
            return data.substring(startIndex, data.indexOf(end));
        }
    }

    public static void main(String[] args) {

        Duke bobby = new Duke();
        bobby.greet();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                bobby.displayList();
            } else if (input.startsWith("mark")) {
                bobby.markOrUnmarked("mark", Integer.parseInt(input.substring(5)));
            } else if (input.startsWith("unmark")) {
                bobby.markOrUnmarked("unmark", Integer.parseInt(input.substring(7)));
            } else {
                bobby.addToList(input);
            }
            input = sc.nextLine();
        }

        bobby.exit();
        sc.close();
    }
}
