package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * DeleteCommand is a command that handles delete instructions.
 *
 * @author yl-ang
 */
public class DeleteCommand extends Command {

    private boolean isExit = false;
    private int taskNum;

    /**
     * Constructs DeleteCommand object with the specified index.
     *
     * @param index The specified index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.taskNum = index;
    };

    /**
     * Executes DeleteCommand with the objects supplied.
     *
     * @param taskLst TaskLst object containing the current tasks.
     * @param ui Ui object containing the user interface messages and scanner object.
     * @param storage Storage object containing the methods to load and save.
     */
    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        Task task = taskLst.deleteTask(this.taskNum);
        storage.save(taskLst.getTaskLst());
        ui.showDeletedTask(task, taskLst.getTaskLst());
    }

    /**
     * Checks and returns the boolean whether if command is exit.
     *
     * @return Boolean if the command is exit.
     */
    @Override
    public boolean isExit() {
        return isExit;
    }
}

