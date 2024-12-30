package lambdatrain.factorypattern.advance;

public abstract class absBank implements BankInterface{

    protected int money=0;
    protected int acctNum;
    protected String name;

    public absBank(int acctNum, String name, int money) {
        this.acctNum = acctNum;
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
        return acctNum;
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
