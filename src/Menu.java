import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static char answer;

    private static Boolean answerHandler(char answer) {
        return switch (answer) {
            case 'y' -> true;
            case 'n' -> false;
            default -> null;
        };
    }

    private static int lenghtHandler(int lenght) {
        if(lenght >= 8 && lenght <= 60) return lenght;
        return lenght = 0;
    }

    private static void userInput(Password password) {

        do {
            System.out.print("\nLunghezza password (8-60): ");
            password.setLength(lenghtHandler(input.nextInt()));
            if (password.getLength() == 0)
                System.out.print("\nERRORE: valore inserito non valido, riprovare");
        } while (password.getLength() == 0);

        do {
            System.out.print("\nUtilizzare le lettere maiuscole (A-Z) (y/n): ");
            password.setCapitalLetters(answerHandler(input.next().charAt(0)));
            if (password.getCapitalLetters() == null)
                System.out.print("\nERRORE: valore inserito non valido, riprovare");
        } while (password.getCapitalLetters() == null);

        do {
            System.out.print("\nUtilizzare i numeri (0-9) (y/n): ");
            password.setDigits(answerHandler(input.next().charAt(0)));
            if (password.getDigits() == null)
                System.out.print("\nERRORE: valore inserito non valido, riprovare");
        } while (password.getDigits() == null);

        do {
            System.out.print("\nUtilizzare i simboli (y/n): ");
            password.setSymbols(answerHandler(input.next().charAt(0)));
            if (password.getSymbols() == null)
                System.out.print("\nERRORE: valore inserito non valido, riprovare");
        } while (password.getSymbols() == null);

        System.out.print("\n- - - - - - - - - - - - - - - - - - - \n\n");
    }

    static void startGenerator() {
        boolean newLoop = false;
        Password password = new Password();

        do {
            if(!newLoop) userInput(password);

            System.out.print("PASSWORD: " + Generator.generatePassword(password));
            System.out.print("\n\nGenerare nuova pw (y/n): ");
            newLoop = (answerHandler(input.next().charAt(0)));
            password.setPassword("");

        } while(newLoop);


    }
}
