package duke.ui;

import duke.error.ErrorString;
import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private Scanner sc;

    /**
     * Constructs an Ui object.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Displays to the user the specified string.
     *
     * @param toDisplay ToDisplay the specified string.
     */
    public void echo(String toDisplay) {
        System.out.print(toDisplay);
    }

    /**
     * Displays to the user the greeting message during startup.
     */
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

    /**
     * Displays to the user the line divider.
     */
    public void showLine() {
        String line = "    ____________________________________________________________\n";
        System.out.print(line);
    }

    /**
     * Displays to the user the specified error message.
     *
     * @param errorMessage ErrorMessage specified error message.
     */
    public void showError(String errorMessage) {
        echo(errorMessage);
    }

    /**
     * Displays to the user error loading message.
     */
    public void showLoadingError() {
        echo(ErrorString.ERROR_LOADING_ERROR.toString());
    }

    /**
     * Displays to the user the specified deleted task.
     *
     * @param deletedTask DeletedTask the specified deleted task.
     * @param tasks Tasks the remaining tasks.
     */
    public void showDeletedTask(Task deletedTask, ArrayList<Task> tasks) {
        String output = String.format("     Noted. I've removed this duke.task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", deletedTask.toString(), tasks.size());
        echo(output);
    }

    /**
     * Displays to the user the newly added task.
     *
     * @param addedTask The newly added task.
     * @param tasks The list of all the tasks after adding.
     */
    public void showAddedTask(Task addedTask, ArrayList<Task> tasks) {
        String output = String.format("     Got it. I've added this duke.task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", addedTask.toString(), tasks.size());
        echo(output);
    }

    /**
     * Displays the tasks the user have currently.
     *
     * @param tasks The list containing the current tasks.
     */
    public void showList(ArrayList<Task> tasks) {
        String output = "     Here are the tasks in your list:\n";
        int numItems = tasks.size();
        for (int i = 0; i < numItems; i++) {
            output += "     " + (i + 1) + "." + tasks.get(i).toString() + "\n";
        }
        echo(output);
    }

    /**
     * Displays the marked task to the user.
     *
     * @param selectedTask SelectedTask task marked by the user.
     */
    public void showMark(Task selectedTask) {
        String output = "     Nice! I've marked this duke.task as done:\n";
        output += "       " + selectedTask.toString() + "\n";
        echo(output);
    }

    /**
     * Displays the unmarked task to the user.
     *
     * @param selectedTask SelectedTask task unmarked by the user.
     */
    public void showUnmark(Task selectedTask) {
        String output = "     OK, I've marked this duke.task as not done yet:\n";
        output += "       " + selectedTask.toString() + "\n";
        echo(output);
    }

    /**
     * Displays to the user the tasks that contains the search keyword.
     *
     * @param taskLst The current list of tasks.
     */
    public void showFind(ArrayList<Task> taskLst) {
        String output = "     Here are the matching tasks in your list:\n";
        int numItems = taskLst.size();
        for (int i = 0; i < numItems; i++) {
            output += "     " + (i + 1) + "." + taskLst.get(i).toString() + "\n";
        }
        echo(output);

    }

    /**
     * Reads user input from stdin.
     *
     * @return User input from stdin.
     */
    public String readCommand() {
        String input = this.sc.nextLine();
        return input;
    }

    /**
     * Displays to the user exit message.
     */
    public void showExit() {
        echo("    Bye. Hope to see you again soon!\n");
    }
}
