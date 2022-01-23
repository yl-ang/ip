package task;
import error.DukeException;
import error.ErrorString;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String data) {
        this.description = data;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() throws DukeException {

        if (this.isDone == false) {
            this.isDone = true;
        } else {
            throw new DukeException(ErrorString.ERROR_TASK_MARKED_ALREADY.toString());
        }
    }

    public void undoDone() {

        if (this.isDone == true) {
            this.isDone = false;
        } else {
            throw new DukeException(ErrorString.ERROR_TASK_UNMARKED_ALREADY.toString());
        }
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String toStringForStorage() {
        return "";
    }
}
