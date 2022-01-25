package ui;
import task.Task;

import java.util.ArrayList;
import java.util.Scanner;

import static error.ErrorString.ERROR_LOADING_ERROR;

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
        echo(ERROR_LOADING_ERROR.toString());
    };

    /**
     * Displays to the user the specified deleted task.
     *
     * @param toDel ToDel the specified deleted task.
     * @param taskLst TaskLst the remaining tasks.
     */
    public void showDeletedTask(Task toDel, ArrayList<Task> taskLst) {
        String output = String.format("     Noted. I've removed this task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", toDel.toString(), taskLst.size());
        echo(output);
    };

    /**
     * Displays to the user the newly added task.
     *
     * @param task Task the newly added task.
     * @param taskLst TaskLst the list of all the tasks after adding.
     */
    public void showAddedTask(Task task, ArrayList<Task> taskLst) {
        String output = String.format("     Got it. I've added this task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", task.toString(), taskLst.size());
        echo(output);
    };

    /**
     * Displays the tasks the user have currently.
     *
     * @param taskLst TaskLst the list containing the current tasks.
     */
    public void showList(ArrayList<Task> taskLst) {
        String output = "     Here are the tasks in your list:\n";
        int numItemsLst = taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += "     " + (i + 1) + "." + taskLst.get(i).toString() + "\n";
        }
        echo(output);
    }

    /**
     * Displays the marked task to the user.
     *
     * @param selectedTask SelectedTask task marked by the user.
     */
    public void showMark(Task selectedTask) {
        String output = "     Nice! I've marked this task as done:\n";
        output += "       " + selectedTask.toString() + "\n";
        echo(output);
    }

    /**
     * Displays the unmarked task to the user.
     *
     * @param selectedTask SelectedTask task unmarked by the user.
     */
    public void showUnmark(Task selectedTask) {
        String output = "     OK, I've marked this task as not done yet:\n";
        output += "       " + selectedTask.toString() + "\n";
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
    };

    /**
     * Displays to the user exit message.
     */
    public void showExit() {
        echo("    Bye. Hope to see you again soon!\n");
    }
}
