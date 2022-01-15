import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private ArrayList<String> lst = new ArrayList<>();
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

    public void addToList(String data) {
        try {
            this.lst.add(data);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        echo("added: " + data);
    }

    public void displayList() {
        String output = "";
        int numItemsLst = this.lst.size();
        for (int i=0; i < numItemsLst; i++) {
            output += (i + 1) + ". " + this.lst.get(i);
            if (i != numItemsLst - 1) {
                output += "\n";
            }
        }
        printLine();
        System.out.println(output);
        printLine();
    }

    public static void main(String[] args) {

        Duke bobby = new Duke();
        bobby.greet();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                bobby.displayList();
            } else {
                bobby.addToList(input);
            }
            input = sc.nextLine();
        }

        bobby.exit();
        sc.close();

    }
}
