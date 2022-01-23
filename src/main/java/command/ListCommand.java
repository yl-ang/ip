package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    private boolean isExit = false;

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        ui.showList(taskLst.getTaskLst());
    }

    @Override
    public boolean isExit() {
        return this.isExit;
    }
}
