package task;

public class Event extends Task {

    protected String at;

    /**
     * Constructs an Event object containing the user specified description and date.
     *
     * @param description Description specified by the user.
     * @param at At date specified by the user.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Converts event object into string format for display.
     *
     * @return Formatted string of the event description and date.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.at + ")";
    }

    /**
     * Converts event object into string format for storage in duke.txt.
     *
     * @return Formatted string of the event description and date for storage in duke.txt.
     */
    @Override
    public String toStringForStorage() {
        int isDone = super.isDone ? 1 : 0;
        return "E | " + isDone + " | " + this.description + " | " + this.at;
    }
}
