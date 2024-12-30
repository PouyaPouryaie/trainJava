package lambdatrain.factorypattern.advance;

public interface AccountFactory {

    BankInterface create(int acctNum, String name, int money);

    static AccountFactory[] accounts = AccountFactories.values();

    static BankInterface createAccount(int type, int acctNum, String name, int money){
        AccountFactory af = accounts[type-1];
        return af.create(acctNum, name, money);
    }

}
