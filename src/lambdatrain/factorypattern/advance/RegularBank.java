package lambdatrain.factorypattern.advance;

public class RegularBank extends absBank{

    public RegularBank(int acctNum, String name) {
        super(acctNum, name, 0);
    }

    @Override
    protected String getType() {
        return "regular";
    }
}
