package lambdatrain.factorypattern.advance;

public interface AccountFactory {

    BankInterface create(int acctnum, String name, int money);

    static AccountFactory[] accounts = AccountFactories.values();

    static BankInterface createAccount(int type, int acctnum, String name, int money){
        AccountFactory af = accounts[type-1];
        return af.create(acctnum, name, money);
    }

}
