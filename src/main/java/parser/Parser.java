package parser;

import command.*;
import error.DukeException;
import error.ErrorString;

public class Parser {

    // deals with making sense of the user command

    public static Command parse(String fullCommand) throws DukeException {

        Command currCommand;

        if (fullCommand.equals("list")) {
            currCommand = new ListCommand();
        } else if (fullCommand.startsWith("mark")) {

            Integer i = null;
            try {
                i = Integer.parseInt(fullCommand.substring("mark".length() + 1));
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(ErrorString.ERROR_EMPTY_MARK_INT.toString());
            } catch (NumberFormatException e) {
                throw new DukeException(ErrorString.ERROR_NOT_INT_MARK.toString());
            }

            currCommand = new MarkCommand(i);

        } else if (fullCommand.startsWith("unmark")) {

            Integer i = null;
            try {
                i = Integer.parseInt(fullCommand.substring("unmark".length() + 1));
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(ErrorString.ERROR_EMPTY_UNMARKED_INT.toString());
            } catch (NumberFormatException e) {
                throw new DukeException(ErrorString.ERROR_NOT_INT_UNMARKED.toString());
            }

            currCommand = new UnmarkCommand(i);

        } else if (fullCommand.startsWith("delete")) {

            Integer i = null;

            try {
                i = Integer.parseInt(fullCommand.substring("delete".length() + 1));
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(ErrorString.ERROR_EMPTY_DELETE.toString());
            } catch (NumberFormatException e) {
                throw new DukeException(ErrorString.ERROR_NOT_NUMBER_STRING.toString());
            }

            currCommand = new DeleteCommand(i);
        } else if (fullCommand.startsWith("todo")) {
            currCommand = new AddCommand(fullCommand, "todo");
        } else if (fullCommand.startsWith("deadline")) {
            currCommand = new AddCommand(fullCommand, "deadline");
        } else if (fullCommand.startsWith("event")) {
            currCommand = new AddCommand(fullCommand, "event");
        } else if (fullCommand.startsWith("find")) {
            currCommand = new FindCommand(fullCommand);
        } else if (fullCommand.equals("bye") || fullCommand.startsWith("bye")) {
            currCommand = new ExitCommand();
        } else {
            throw new DukeException(ErrorString.ERROR_INVALID_COMMAND.toString());
        }

        return currCommand;
    }
}
