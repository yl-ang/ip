package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeadLine extends Task {

    protected LocalDate by;

    public DeadLine(String description,String date) {
        super(description);
        this.by = LocalDate.parse(date);
    }

    @Override
    public String toString() {
        String dateFormatted = this.by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[D]" + super.toString() + "(by: " + dateFormatted + ")";
    }
}
