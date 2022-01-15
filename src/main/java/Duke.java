import java.util.ArrayList;
import java.util.Scanner;
import task.Task;

public class Duke {

    private ArrayList<Task> taskLst = new ArrayList<>();

    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void greet() {
        printLine();
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("    Hello! I'm Bobby");
        System.out.println("    What can I do for you?");
        printLine();
        System.out.println();
    }

    public void echo(String userInput) {
        printLine();
        System.out.println(userInput);
        printLine();
        System.out.println();
    }

    public void exit() {
        printLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printLine();
        System.out.println();
    }

    public void addToList(String data) {
        try {
            this.taskLst.add(new Task(data));
        } catch (Exception e) {
            System.out.println("    Exception occurred");
        }
        echo("     added: " + data);
    }

    public void displayList() {
        String output = "     Here are the tasks in your list:\n";
        int numItemsLst = this.taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += "     " + (i + 1) + "." + this.taskLst.get(i).toString();
            if (i != numItemsLst - 1) {
                output += "\n";
            }
        }
        printLine();
        System.out.println(output);
        printLine();
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

        // Need to check for valid value -> could be out of index
        Task selectedTask = retrieveTask(i);

        if (action.equals("mark")) {
            output += "     Nice! I've marked this task as done:\n";
            selectedTask.markAsDone();

        } else {
            output += "     OK, I've marked this task as not done yet:\n";
            selectedTask.undoDone();
        }
        output += "       " + selectedTask.toString();
        System.out.println(output);
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
