package command;

import error.DukeException;
import error.ErrorString;
import storage.Storage;
import task.*;
import ui.Ui;

public class AddCommand extends Command {

    private boolean isExit = false;
    private Task task;

    /**
     * Constructs AddCommand object with the supplied user input and taskCommand.
     *
     * @param data Full user input.
     * @param taskCommand Task command specified by the user.
     * @throws DukeException If no task description or no date and time is supplied.
     */
    public AddCommand(String data, String taskCommand) throws DukeException {
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

        this.task = task;
    };

    /**
     * Extracts the task description from the user input.
     *
     * @param data Data the full user input.
     * @param start Starting string to extract from.
     * @param timeCommand Stopping string to extract to.
     * @return Extracted task description from user input.
     */
    public String extractDesc(String data, String start, String timeCommand) {
        int startIndex = data.indexOf(start) + start.length();
        if (timeCommand == null) {
            return data.substring(startIndex);
        } else {
            int endIndex = data.indexOf(timeCommand);
            return data.substring(startIndex, endIndex - 1);
        }
    }

    /**
     * Extracts the task date and time from the user input.
     *
     * @param data Full user input.
     * @param timeCommand Starting time and date to extract from.
     * @return Extracted date dnd time from user input.
     */
    public String extractTime(String data, String timeCommand) {
        int startIndex = data.indexOf(timeCommand) + timeCommand.length();
        return data.substring(startIndex);
    }

    /**
     * Executes AddCommand with the objects supplied.
     *
     * @param taskLst TaskLst object containing the current tasks.
     * @param ui Ui object containing the user interface messages and scanner object.
     * @param storage Storage object containing the methods to load and save.
     */
    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        taskLst.addToList(this.task);
        storage.save(taskLst.getTaskLst());
        ui.showAddedTask(this.task, taskLst.getTaskLst());
    }

    /**
     * Checks and returns the boolean whether if command is exit.
     *
     * @return Boolean if the command is exit.
     */
    @Override
    public boolean isExit() {
        return this.isExit;
    }
}
