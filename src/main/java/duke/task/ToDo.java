package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toStringForStorage() {
        int isDone = super.isDone ? 1 : 0;
        return "T | " + isDone + " | " + this.description;
    }
}
