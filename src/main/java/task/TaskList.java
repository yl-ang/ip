package task;

import errorHandle.DukeException;
import errorHandle.ErrorString;
import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskLst;

    public TaskList(ArrayList<Task> tasks) {
        this.taskLst = tasks;
    }

    public TaskList() {
        this.taskLst = new ArrayList<Task>();
    }


    public ArrayList<Task> getTaskLst() {
        return taskLst;
    }

    public Task retrieveTask(int i) throws DukeException {
        Task selectedTask = null;
        try {
            selectedTask = this.taskLst.get(i - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(ErrorString.ERROR_INDEX_OUT_OF_BOUND_TASK.toString());
        }

        return selectedTask;
    }


    public void addToList(Task task) throws DukeException {
        this.taskLst.add(task);
    }

    public Task deleteTask(int index) throws DukeException {
        Task toDel = retrieveTask(index);
        this.taskLst.remove(index -1);
        return toDel;
    }

    public Task markOrUnmarked(String action, int taskNum) throws DukeException {
        Task selectedTask = retrieveTask(taskNum);

        if (action.equals("mark")) {
            selectedTask.markAsDone();

        } else {
            selectedTask.undoDone();
        }
        return selectedTask;
    }

}
