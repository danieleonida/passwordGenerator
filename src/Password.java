class Password {

    //ATTRIBUTI
    private int length;             // 8-60
    private Boolean capitalLetters; // A-Z
    private Boolean digits;         // 0-9
    private Boolean symbols;        // @!$%&*
    private String password;

    //COSTRUTTORI
    Password() {
        this.length = 0;
        this.capitalLetters = null;
        this.digits = null;
        this.symbols = null;
        this.password = "";
    }


    //GETS & SETS
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
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
