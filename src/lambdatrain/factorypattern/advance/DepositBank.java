package lambdatrain.factorypattern.advance;

public class DepositBank extends absBank{

    public DepositBank(int acctNum, String name, int money) {
        super(acctNum, name, money);
    }

    @Override
    protected String getType() {
        return "deposit";
    }
}
