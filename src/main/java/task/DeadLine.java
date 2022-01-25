package task;

import error.DukeException;
import error.ErrorString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DeadLine extends Task {

    protected LocalDate by;

    /**
     * Constructs a DeadLine object containing the user specified description and date.
     *
     * @param description Description specified by the user.
     * @param date Date specified by the user.
     * @throws DukeException If date specified is not of the format yyyy-mm-dd.
     */
    public DeadLine(String description,String date) throws DukeException {
        super(description);

        try {
            this.by = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new DukeException(ErrorString.ERROR_INVALID_DEADLINE_DATE_FORMAT.toString());
        }
    }

    /**
     * Converts deadline object into string format for display.
     *
     * @return Formatted string of the deadline description and date.
     */
    @Override
    public String toString() {
        String dateFormatted = this.by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Converts deadline object into string format for storage in duke.txt.
     *
     * @return Formatted string of the deadline description and date for storage in duke.txt.
     */
    @Override
    public String toStringForStorage() {
        int isDone = super.isDone ? 1 : 0;
        return "D | " + isDone + " | " + this.description + " | " + this.by;
    }
}
