package errorHandle;

public enum ErrorString {

    ERROR_INDEX_OUT_OF_BOUND_TASK("     ☹ OOPS!!! The task number you specify is invalid.\n"),
    ERROR_EMPTY_TODO_DESC("     ☹ OOPS!!! The description of a todo cannot be empty.\n"),
    ERROR_EMPTY_DEADLINE_DESC("     ☹ OOPS!!! The description of a deadline cannot be empty.\n"),
    ERROR_EMPTY_DEADLINE_DATE("     ☹ OOPS!!! The date of a deadline cannot be empty.\n"),
    ERROR_EMPTY_EVENT_DESC("     ☹ OOPS!!! The description of an event cannot be empty.\n"),
    ERROR_EMPTY_EVENT_DATE("     ☹ OOPS!!! The date of an event cannot be empty.\n"),
    ERROR_INVALID_COMMAND("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");

    private String errorString;

    ErrorString(String errorString) {
        this.errorString = errorString;
    }

    @Override
    public String toString() {
        return errorString;
    }
}
