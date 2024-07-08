class Password {

    //ATTRIBUTI
    private int length;             // 8-60
    private Boolean capitalLetters; // A-Z
    private Boolean digits;         // 0-9
    private Boolean symbols;        // @!$%&*
    private String password;

    //COSTRUTTORI
    Password() {
        this.length = 12;
        this.capitalLetters = true;
        this.digits = true;
        this.symbols = true;
        this.password = "";
    }


    //GETS & SETS
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        if(length < 8) {
            System.out.print("\nPassword troppo corta!");
        } else if (length > 60) {
            System.out.print("\nPassword troppo lunga!");
        } else {
            this.length = length;
        }
    }

    public Boolean getCapitalLetters() {
        return capitalLetters;
    }
    public void setCapitalLetters(Boolean capitalLetters) {
        this.capitalLetters = capitalLetters;
    }

    public Boolean getDigits() {
        return digits;
    }
    public void setDigits(Boolean digits) {
        this.digits = digits;
    }

    public Boolean getSymbols() {
        return symbols;
    }
    public void setSymbols(Boolean symbols) {
        this.symbols = symbols;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
