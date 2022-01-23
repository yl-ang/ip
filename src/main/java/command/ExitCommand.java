package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;


public class ExitCommand extends Command {

    private boolean isExit = false;

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        ui.showExit();
        this.changeExitStatus();
    }

    @Override
    public boolean isExit() {
        return this.isExit;
    }

    public void changeExitStatus() {
        this.isExit = true;
    }

}
