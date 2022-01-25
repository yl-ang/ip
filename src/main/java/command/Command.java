package command;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public abstract class Command {
    /**
     * Executes based on the command type and the objects supplied.
     *
     * @param taskLst TaskLst object containing the current tasks.
     * @param ui Ui object containing the user interface messages and scanner object.
     * @param storage Storage object containing the methods to load and save.
     */
    public abstract void execute(TaskList taskLst, Ui ui, Storage storage);

    /**
     * Checks and returns if the command is exit.
     *
     * @return Boolean if the command is exit.
     */
    public abstract boolean isExit();
}
