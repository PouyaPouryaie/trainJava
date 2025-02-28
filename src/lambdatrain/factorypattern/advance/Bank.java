package lambdatrain.factorypattern.advance;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer,BankInterface> accounts = new HashMap<>();
    private int acctNum;

    public Bank(int acctNum) {
        this.acctNum = acctNum;
    }

    public int newAccount(int type, String name, int money){
        acctNum += 1;
        BankInterface ba = AccountFactory.createAccount(type,acctNum, name, money);
        accounts.put(acctNum, ba);
        return acctNum;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("The bank has " + accounts.size() + " accounts.");
        for (BankInterface ba : accounts.values())
            result.append("\n\t").append(ba.toString());
        return result.toString();
    }

}
