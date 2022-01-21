package task;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + this.at + ")";
    }

    @Override
    public String toStringForStorage() {
        int isDone = super.isDone ? 1 : 0;
        return "E | " + isDone + " | " + this.description + " | " + this.at;
    }
}
