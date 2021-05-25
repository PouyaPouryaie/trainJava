package lambdatrain.factorypattern.advance;

public class DepositeBank extends absBank{

    public DepositeBank(int acctnum,String name, int money) {
        super(acctnum, name, money);
    }

    @Override
    protected String getType() {
        return null;
    }
}
