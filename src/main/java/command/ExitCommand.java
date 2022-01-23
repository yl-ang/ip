package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;


public class ExitCommand extends Command {

    private boolean isExit = true;

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        ui.showExit();
    }

    @Override
    public boolean isExit() {
        return isExit;
    }

}
