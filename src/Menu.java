import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static char answer;

    private static Boolean answerHandler(char answer) {
        return switch (answer) {
            case 'y' -> true;
            case 'n' -> false;
            default -> throw new IllegalStateException("Unexpected value: " + answer);
        };
    }

    private static void userInput(Password password) {

        System.out.print("\nlunghezza password: ");
        password.setLength(input.nextInt());

        System.out.print("\nutilizzare le lettere maiuscole (A-Z) (y/n): ");
        password.setCapitalLetters(answerHandler(input.next().charAt(0)));

        System.out.print("\nutilizzare i numeri (0-9) (y/n): ");
        password.setDigits(answerHandler(input.next().charAt(0)));

        System.out.print("\nutilizzare i simboli (y/n): ");
        password.setSymbols(answerHandler(input.next().charAt(0)));
    }

    static void startGenerator() {
        boolean newLoop = false;
        Password password = new Password();

        do {
            if(!newLoop) userInput(password);

            System.out.print("\n\nPASSWORD: " + Generator.generatePassword(password));
            System.out.print("\nGenerare nuova pw (y/n): ");
            newLoop = (answerHandler(input.next().charAt(0)));
            password.setPassword("");

        } while(newLoop);


    }
}
