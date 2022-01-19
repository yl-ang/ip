package errorHandle;

public enum ErrorString {

    ERROR_INDEX_OUT_OF_BOUND_TASK("     ☹ OOPS!!! The task number you specify is invalid.\n"),
    ERROR_EMPTY_TODO_DESC("     ☹ OOPS!!! The description of a todo cannot be empty.\n"),
    ERROR_EMPTY_DEADLINE_DESC("     ☹ OOPS!!! The description of a deadline cannot be empty.\n"),
    ERROR_EMPTY_DEADLINE_DATE("     ☹ OOPS!!! The date of a deadline cannot be empty.\n"),
    ERROR_EMPTY_EVENT_DESC("     ☹ OOPS!!! The description of an event cannot be empty.\n"),
    ERROR_EMPTY_EVENT_DATE("     ☹ OOPS!!! The date of an event cannot be empty.\n"),
    ERROR_INVALID_COMMAND("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"),
    ERROR_EMPTY_MARK_INT("     ☹ OOPS!!! Please specify a task number for me to mark.\n"),
    ERROR_EMPTY_UNMARKED_INT("     ☹ OOPS!!! Please specify a task number for me to unmark.\n"),
    ERROR_NOT_INT_MARK("     ☹ OOPS!!! The task number you specify for me to mark\n     is invalid.\n"),
    ERROR_NOT_INT_UNMARKED("     ☹ OOPS!!! The task number you specify for me to unmark\n     is invalid.\n");

    private String errorString;

    ErrorString(String errorString) {
        this.errorString = errorString;
    }

    @Override
    public String toString() {
        return errorString;
    }
}
