import java.util.Scanner;

public class Duke {

    public void printLine() {
        System.out.println("____________________________________________________________");
    };

    public void greet() {
        printLine();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("Hello! I'm Bobby");
        System.out.println("What can I do for you?");
        printLine();
        System.out.println();
    };

    public void echo(String userInput) {
        printLine();
        System.out.println(userInput);
        printLine();
        System.out.println();
    }

    public void exit() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        System.out.println();
    }

    public static void main(String[] args) {

        Duke bobby = new Duke();
        bobby.greet();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while (!command.equals("bye")) {
            bobby.echo(command);
            command = sc.nextLine();
        }

        bobby.exit();
        sc.close();

    }
}
