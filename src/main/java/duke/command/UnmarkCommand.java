package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class UnmarkCommand extends Command {

    private boolean isExit = false;
    private int taskNum;

    public UnmarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        Task selectedTask = taskLst.markOrUnmarked("unmark", this.taskNum);
        storage.save(taskLst.getTaskLst());
        ui.showUnmark(selectedTask);
    }

    @Override
    public boolean isExit() {
        return this.isExit;
    }
}
