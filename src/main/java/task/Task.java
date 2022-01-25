package task;
import error.DukeException;
import error.ErrorString;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task object with specified description.
     *
     * @param data Data the specified description.
     */
    public Task(String data) {
        this.description = data;
        this.isDone = false;
    }

    /**
     *
     * @return The status icon of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Changes the status of the task from unmarked to marked.
     *
     * @throws DukeException if the task is already marked as done.
     */
    public void markAsDone() throws DukeException {

        if (this.isDone == false) {
            this.isDone = true;
        } else {
            throw new DukeException(ErrorString.ERROR_TASK_MARKED_ALREADY.toString());
        }
    }

    /**
     * Changes the status of the task from marked to unmarked.
     *
     * @throws DukeException if the task is already marked as undone.
     */
    public void undoDone() throws DukeException {

        if (this.isDone == true) {
            this.isDone = false;
        } else {
            throw new DukeException(ErrorString.ERROR_TASK_UNMARKED_ALREADY.toString());
        }
    }

    /**
     * Converts task object into string format for display.
     *
     * @return Formatted string of the task description.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Converts task object into string format for storage in duke.txt.
     *
     * @return Formatted string of the task description for storage in duke.txt.
     */
    public String toStringForStorage() {
        return "";
    }
}
