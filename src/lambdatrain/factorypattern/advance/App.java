package lambdatrain.factorypattern.advance;

public class App {

    public static void main(String[] args) {

        Bank bank = new Bank(10);

        int result = bank.newAccount(1, "basic", 10);
        System.out.println(result);

        result = bank.newAccount(1, "pro", 0);
        System.out.println(result);

        result = bank.newAccount(2, "mid", 2000);
        System.out.println(result);

        System.out.println(bank.toString());
    }
}
