package duke.command;

import duke.exception.DukeException;
import duke.exception.ErrorString;
import duke.gui.Ui;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

public class UpdateCommand extends Command {

    private boolean isExit = false;
    private int taskNum;
    private String desc;
    private String date;

    /**
     * Constructs UpdateCommand object with the supplied user input.
     *
     * @param data Full user input.
     * @throws DukeException If no task description or no date and time is supplied.
     */
    public UpdateCommand(String data) throws DukeException {
        String[] temp = data.split(" ");

        if (temp.length == 1) {
            throw new DukeException(ErrorString.ERROR_EMPTY_UPDATE.toString());
        }

        int taskNum;
        try {
            taskNum = Integer.parseInt(temp[1]);
        } catch (NumberFormatException e) {
            throw new DukeException(ErrorString.ERROR_NOT_INT_UPDATE.toString());
        }

        this.taskNum = taskNum;
        for (int i = 2; i < temp.length; i++) {
            String smallUpdate = temp[i];

            if (smallUpdate.startsWith("d/") && smallUpdate.length() > 2) {
                this.desc = smallUpdate.substring(2);
            } else if (smallUpdate.startsWith("d/") && smallUpdate.length() <= 2) {
                throw new DukeException(ErrorString.ERROR_EMPTY_DESC_UPDATE.toString());
            }

            if (smallUpdate.startsWith("t/") && smallUpdate.length() > 2) {
                this.date = smallUpdate.substring(2);
            } else if (smallUpdate.startsWith("t/") && smallUpdate.length() <= 2) {
                throw new DukeException(ErrorString.ERROR_EMPTY_DATE_UPDATE.toString());
            }
        }

        if (this.desc == null && this.date == null) {
            throw new DukeException(ErrorString.ERROR_EMPTY_UPDATE.toString());
        }
    }

    /**
     * Executes UpdateCommand with the objects supplied.
     *
     * @param taskLst TaskLst object containing the current tasks.
     * @param ui Ui object containing the user interface messages and scanner object.
     * @param storage Storage object containing the methods to load and save.
     * @return Formatted response from executing command.
     */
    @Override
    public String execute(TaskList taskLst, Ui ui, Storage storage) {
        Task selectedTask = taskLst.retrieveTask(this.taskNum);
        selectedTask.updateDescription(this.desc);
        selectedTask.updateDate(this.date);
        storage.save(taskLst.getTaskLst());
        String response = ui.updateResponse(selectedTask);
        return response;
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
