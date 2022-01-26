package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {

    private boolean isExit = false;
    private int taskNum;

    public DeleteCommand(int index) {
        this.taskNum = index;
    };

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        Task task = taskLst.deleteTask(this.taskNum);
        storage.save(taskLst.getTaskLst());
        ui.showDeletedTask(task, taskLst.getTaskLst());
    }

    @Override
    public boolean isExit() {
        return isExit;
    }
}

