package threadtrain.semaphoresample;

import java.util.concurrent.Semaphore;

public class Restaurant {

    private Semaphore tables;

    public Restaurant(int countTables) {
        this.tables = new Semaphore(countTables);
    }

    public void getTable(int customerId){

        System.out.println("Customer #" + customerId + " is trying to get a table.");

        try{
            tables.acquire();
            System.out.println("Customer #" + customerId + " got a table.");
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void returnTable(int customerId){
        System.out.println("Customer #" + customerId + " returned a table.");
        tables.release();
    }


    public static void main(String[] args){

        Restaurant restaurant = new Restaurant(3);

        for(int i = 1; i<=5; i++){
            RestaurantCustomer restaurantCustomer = new RestaurantCustomer(restaurant, i);
            restaurantCustomer.start();
        }
    }
}
