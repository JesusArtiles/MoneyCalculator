package Model;


public class Currency {

    private String name;
    private String code;
    private String symbol;

    public Currency(String code, String name,String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public Currency(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }
}
