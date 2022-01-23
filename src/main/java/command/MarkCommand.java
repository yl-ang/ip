package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;


public class MarkCommand extends Command {

    private boolean isExit = false;
    private int taskNum;

    public MarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        taskLst.markOrUnmarked("mark", this.taskNum);
        storage.save(taskLst.getTaskLst());
        ui.showMark();
    }


    @Override
    public boolean isExit() {
        return this.isExit;
    }

}
