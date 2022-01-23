package task;

import error.DukeException;
import error.ErrorString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DeadLine extends Task {

    protected LocalDate by;

    public DeadLine(String description,String date) throws DukeException {
        super(description);

        try {
            this.by = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new DukeException(ErrorString.ERROR_INVALID_DEADLINE_DATE_FORMAT.toString());
        }
    }

    @Override
    public String toString() {
        String dateFormatted = this.by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toStringForStorage() {
        int isDone = super.isDone ? 1 : 0;
        return "D | " + isDone + " | " + this.description + " | " + this.by;
    }
}
