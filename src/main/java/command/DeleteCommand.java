package command;

import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {

    private boolean isExit = false;
    private int taskNum;

    public DeleteCommand(int index) {
        this.taskNum = taskNum;
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

