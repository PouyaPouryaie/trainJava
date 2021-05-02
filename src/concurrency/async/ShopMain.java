package concurrency.async;

public class ShopMain {

    public static void main(String[] args){

        Shop shop = new Shop("BestShop");

        long start = System.nanoTime();
        String result = shop.getPrice("phone27");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);

        System.out.println("after calculate is : " + result);

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println("Doing something else ...");
    }
}
