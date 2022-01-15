package task;

public class DeadLine extends Task {

    protected String by;

    public DeadLine(String description,String data) {
        super(description);
        this.by = data;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}
