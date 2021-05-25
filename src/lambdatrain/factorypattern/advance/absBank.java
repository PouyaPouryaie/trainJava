package lambdatrain.factorypattern.advance;

public abstract class absBank implements BankInterface{

    protected int money=0;
    protected int acctnum;
    protected String name;

    public absBank(int acctnum,String name, int money) {
        this.acctnum = acctnum;
        this.name = name;
        this.money = money;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMoney() {
        return 0;

    }

    @Override
    public int getAcctNum() {
        return acctnum;
    }

    @Override
    public String toString() {
        return "absBank{" +
                "money=" + money +
                " type=" + getType() +
                " name=" + getName() +
                '}';
    }

    protected abstract String getType();
}
