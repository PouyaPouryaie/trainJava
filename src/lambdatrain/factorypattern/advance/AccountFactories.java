package lambdatrain.factorypattern.advance;

public enum AccountFactories implements AccountFactory{

    SAVING("saving", (x,y, z) -> new RegularBank(x, y)),
    DEPOSIT("deposit", (x, y, z) -> new DepositBank(x, y, z));

    private String name;
    private AccountFactory af;

    AccountFactories(String name, AccountFactory af) {
        this.name = name;
        this.af = af;
    }

    @Override
    public BankInterface create(int acctNum, String name, int money) {
        return af.create(acctNum, name, money);
    }

    @Override
    public String toString() {
        return name;
    }
}
