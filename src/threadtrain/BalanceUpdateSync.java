package threadtrain;

public class BalanceUpdateSync {

    private static int  balance = 100;

    public static void main(String[] args){

        startBalanceUpdateThrad();
        startBalanceMonitorThread();
    }



    public static synchronized void balance(){
        balance = balance - 10;
        balance = balance + 10;
    }

    public static synchronized void monitor(){

        int data = balance;
        if(data != 100){
            System.out.println("balance change: " + data);
        }
    }

    public static void startBalanceUpdateThrad(){

        Thread balanceUpdate = new Thread(() -> {while (true){balance();}});
        balanceUpdate.start();
    }

    public static void startBalanceMonitorThread(){

        Thread monitorBalance = new Thread(() -> {while(true){monitor();}});
        monitorBalance.start();
    }
}
