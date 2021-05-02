package concurrency.async;

import java.util.Random;

public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name){
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName(){return name;}

    public String getPrice(String product){

        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double calculatePrice(String product) {
        //Utils.delay();
        Utils.randomDelay();
        return Utils.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}
