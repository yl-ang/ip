package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    private boolean isExit = false;

    /**
     * Executes ListCommand with the objects supplied.
     *
     * @param taskLst TaskLst object containing the current tasks.
     * @param ui Ui object containing the user interface messages and scanner object.
     * @param storage Storage object containing the methods to load and save.
     */
    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        ui.showList(taskLst.getTaskLst());
    }

    /**
     * Checks and returns the boolean whether if command is exit.
     *
     * @return Boolean if command is exit.
     */
    @Override
    public boolean isExit() {
        return this.isExit;
    }
}
