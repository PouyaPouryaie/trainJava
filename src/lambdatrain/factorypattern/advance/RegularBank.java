package lambdatrain.factorypattern.advance;

public class RegularBank extends absBank{

    public RegularBank(int acctnum,String name) {
        super(acctnum, name, 0);
    }

    @Override
    protected String getType() {
        return "regular";
    }
}
