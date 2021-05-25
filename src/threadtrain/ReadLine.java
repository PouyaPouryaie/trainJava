package threadtrain;

import java.util.Scanner;

public class ReadLine extends Thread{

    private boolean done = false;

    public static void main(String[] args) {
        ReadLine readLine = new ReadLine();
        readLine.start();
        int i = 0;
        while (!readLine.isDone()){
            System.out.println(i);
            i++;
        }
    }


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        done = true;
    }

    public boolean isDone() {
        return done;
    }
}
