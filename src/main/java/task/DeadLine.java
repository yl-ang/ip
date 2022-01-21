package task;

public class DeadLine extends Task {

    protected String by;

    public DeadLine(String description,String data) {
        super(description);
        this.by = data;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toStringForStorage() {
        int isDone = super.isDone ? 1 : 0;
        return "D | " + isDone + " | " + this.description + " | " + this.by;
    }
}
