package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.gui.Ui;

/**
 * MarkCommand is a command that handles mark commands.
 *
 * @author yl-ang
 */
public class MarkCommand extends Command {

    private boolean isExit = false;
    private int taskNum;

    /**
     * Constructs a MarkCommand object with the specified task number.
     *
     * @param taskNum Task number specified by the user.
     */
    public MarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes MarkCommand with the objects supplied.
     *
     * @param taskLst TaskLst object containing the current tasks.
     * @param ui Ui object containing the user interface messages and scanner object.
     * @param storage Storage object containing the methods to load and save.
     */
    @Override
    public String execute(TaskList taskLst, Ui ui, Storage storage) {
        Task selectedTask = taskLst.markOrUnmarked("mark", this.taskNum);
        storage.save(taskLst.getTaskLst());
        return ui.markResponse(selectedTask);
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
