package ui;
import task.Task;

import java.util.ArrayList;
import java.util.Scanner;

import static errorHandle.ErrorString.ERROR_LOADING_ERROR;

public class Ui {

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
        echo(ERROR_LOADING_ERROR.toString());
    };

    public void showDeletedTask(Task toDel, ArrayList<Task> taskLst) {
        String output = String.format("     Noted. I've removed this task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", toDel.toString(), taskLst.size());
        echo(output);
    };

    public void showAddedTask(Task task, ArrayList<Task> taskLst) {
        String output = String.format("     Got it. I've added this task:\n       %s\n     "
                + "Now you have %s tasks in the list.\n", task.toString(), taskLst.size());
        echo(output);
    };

    public void showList(ArrayList<Task> taskLst) {
        String output = "     Here are the tasks in your list:\n";
        int numItemsLst = taskLst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += "     " + (i + 1) + "." + taskLst.get(i).toString() + "\n";
        }
        echo(output);
    }
    public void showMark() {
        String output = "     Nice! I've marked this task as done:\n";
        echo(output);
    }

    public void showUnmark() {
        String output = "     OK, I've marked this task as not done yet:\n";
        echo(output);
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    };


    public void showExit() {
        echo("    Bye. Hope to see you again soon!\n");
    }
}
