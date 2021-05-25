package threadtrain;

public class PrinterThread {

    public static void main(String[] args){
        Thread thread = new Thread(PrinterThread::print);
        thread.start();
    }

    public static void print(){
        for(int i = 0; i < 500 ; i++){
            System.out.println("the number is " + i);
        }
    }
}
