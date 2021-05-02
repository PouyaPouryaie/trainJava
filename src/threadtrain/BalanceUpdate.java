package threadtrain;

public class BalanceUpdate {

    private static int balance = 100;

    public static void main(String[] args){

        startBalanceUpdateThread();
        startBalanceMonitorThread();
    }

    public static void updateBalance(){
        balance = balance + 10;
        balance = balance - 10;
    }

    public static void monitorBalance(){

        int b = balance;

        if(b != 100){
            System.out.println("balance change: " + b);
        }
    }

    public static void startBalanceUpdateThread(){

        Thread balanceUpdate = new Thread(() -> {while (true){updateBalance();}});
        balanceUpdate.start();
    }

    public static void startBalanceMonitorThread(){

        Thread monitorBalance = new Thread(() -> {while(true){monitorBalance();}});
        monitorBalance.start();
    }
}
