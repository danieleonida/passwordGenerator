import java.util.Random;

//METODI
class Generator {

    private static char[] getAlphabet(char letterCase) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) (letterCase + i);
        }
        return alphabet;
    }

    private static char[] getLowercaseAlphabet() {
        char LOWER_CASE_LETTER = 'a';
        return getAlphabet(LOWER_CASE_LETTER);
    }

    private static char[] getUppercaseAlphabet() {
        char UPPER_CASE_LETTER = 'A';
        return getAlphabet(UPPER_CASE_LETTER);
    }

    private static char[] getDigit() {
        char[] NUMBERS = new char[10];
        for (int i = 0; i <= 9; i++) {
            NUMBERS[i] = (char) ('0' + i);
        }
        return NUMBERS;
    }

    private static char[] getSymbol() {
        // @ = '64' | ! = '33' | $ = '36' | % = '37' | & = '38' | * = '42'
        return new char[]{'@', '!', '$', '%', '&', '*'};
    }

    private static String userBooleanChoice(Password password) {
        String ArrayCase = "L";

        if(password.getCapitalLetters()) ArrayCase = ArrayCase + "U";
        if(password.getDigits()) ArrayCase = ArrayCase + "D";
        if(password.getSymbols()) ArrayCase = ArrayCase + "S";

        return ArrayCase;
    }

    private static char[] mergeCharArrays(char[] array1, char[] array2) {
        char[] mergedArray = new char[array1.length + array2.length];

        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

        return mergedArray;
    }

    private static char[] getTotalCaracters(Password password) {

        char[] lowercaseAlphabet = getLowercaseAlphabet();
        char[] uppercaseAlphabet = getUppercaseAlphabet();
        char[] digits = getDigit();
        char[] symbols = getSymbol();

        return switch (userBooleanChoice(password)) {
            case "L"    ->  lowercaseAlphabet;
            case "LU"   ->  mergeCharArrays(lowercaseAlphabet,uppercaseAlphabet);
            case "LD"   ->  mergeCharArrays(lowercaseAlphabet,digits);
            case "LS"   ->  mergeCharArrays(lowercaseAlphabet,symbols);
            case "LUD"  ->  mergeCharArrays(mergeCharArrays(lowercaseAlphabet,uppercaseAlphabet),digits);
            case "LUS"  ->  mergeCharArrays(mergeCharArrays(lowercaseAlphabet,uppercaseAlphabet),symbols);
            case "LUDS" ->  mergeCharArrays(mergeCharArrays(lowercaseAlphabet,uppercaseAlphabet),mergeCharArrays(digits,symbols));
            default -> throw new IllegalStateException("Unexpected value: " + userBooleanChoice(password));
        };
    }

    public static String generatePassword(Password password) {
        final char[] TO_USE_CARACTERS = getTotalCaracters(password);
        Random rand = new Random();

        for (int i = 0; i < password.getLength(); i++) {
            int randomInt = rand.nextInt(TO_USE_CARACTERS.length);
            password.setPassword(password.getPassword() + TO_USE_CARACTERS[randomInt]);
        }
        return password.getPassword();
    }

}