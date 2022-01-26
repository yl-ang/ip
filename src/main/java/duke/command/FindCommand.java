package duke.command;

import duke.error.DukeException;
import duke.error.ErrorString;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {

    private boolean isExit = false;
    private String keyword;

    public FindCommand(String data) {
        try {
            String[] temp = data.split(" ");
            this.keyword = temp[1];
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(ErrorString.ERROR_EMPTY_FIND_KEYWORD.toString());
        }
    }

    @Override
    public void execute(TaskList taskLst, Ui ui, Storage storage) {
        ArrayList<Task> tasks = taskLst.findTask(keyword);
        ui.showFind(tasks);
    }

    @Override
    public boolean isExit() {
        return isExit;
    }

}
