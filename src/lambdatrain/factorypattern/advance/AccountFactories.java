package lambdatrain.factorypattern.advance;

public enum AccountFactories implements AccountFactory{

    SAVING("saving", (x,y, z) -> new RegularBank(x, y)),
    DEPOSITE("depo", (x,y, z) -> new DepositeBank(x, y, z));

    private String name;
    private AccountFactory af;

    AccountFactories(String name, AccountFactory af) {
        this.name = name;
        this.af = af;
    }

    @Override
    public BankInterface create(int acctnum, String name, int money) {
        return af.create(acctnum, name, money);
    }

    @Override
    public String toString() {
        return name;
    }
}
