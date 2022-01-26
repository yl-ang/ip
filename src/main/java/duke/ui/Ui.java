package duke.ui;

import duke.error.ErrorString;
import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public void echo(String toDisplay) {
        System.out.print(toDisplay);
    }

    public void showWelcome() {

        String intro = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        intro += "    Hello! I'm Bobby\n";
        intro += "    What can I do for you?\n";
        showLine();
        echo(intro);
        showLine();
    }

    public void showLine() {
        String line = "    ____________________________________________________________\n";
        System.out.print(line);
    }

    public void showError(String errorMessage) {
        echo(errorMessage);
    }

    public void showLoadingError() {
        echo(ErrorString.ERROR_LOADING_ERROR.toString());
    }

    public void showDeletedTask(Task deletedTask, ArrayList<Task> tasks) {
        String output = String.format("     Noted. I've removed this duke.task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", deletedTask.toString(), tasks.size());
        echo(output);
    }

    public void showAddedTask(Task addedTask, ArrayList<Task> tasks) {
        String output = String.format("     Got it. I've added this duke.task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", addedTask.toString(), tasks.size());
        echo(output);
    }

    public void showList(ArrayList<Task> tasks) {
        String output = "     Here are the tasks in your list:\n";
        int numItems = tasks.size();
        for (int i = 0; i < numItems; i++) {
            output += "     " + (i + 1) + "." + tasks.get(i).toString() + "\n";
        }
        echo(output);
    }

    public void showMark(Task selectedTask) {
        String output = "     Nice! I've marked this duke.task as done:\n";
        output += "       " + selectedTask.toString() + "\n";
        echo(output);
    }

    public void showUnmark(Task selectedTask) {
        String output = "     OK, I've marked this duke.task as not done yet:\n";
        output += "       " + selectedTask.toString() + "\n";
        echo(output);
    }

    public String readCommand() {
        String input = this.sc.nextLine();
        return input;
    }

    public void showExit() {
        echo("    Bye. Hope to see you again soon!\n");
    }
}
