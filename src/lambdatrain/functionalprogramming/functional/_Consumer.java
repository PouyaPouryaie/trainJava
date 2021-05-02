package lambdatrain.functionalprogramming.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        // Normal java function
        Customer pouya = new Customer("pouya", "1234");
        greetCustomer(pouya);

        // consumer functional interface
        greetCustomerConsumerFunction.accept(pouya);
        greetCustomerConsumerMethodRef.accept(pouya);
        greetCustomerConsumerFunctionV2.accept(pouya, false);
    }

    static Consumer<Customer> greetCustomerConsumerFunction = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for register phone number " +
                    customer.customerPhoneNumber);

    static Consumer<Customer> greetCustomerConsumerMethodRef = System.out::println;


    static BiConsumer<Customer, Boolean> greetCustomerConsumerFunctionV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for register phone number " +
                    (showPhoneNumber ? customer.customerPhoneNumber: "*************"));

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName +
                ", thanks for register phone number " +
                customer.customerPhoneNumber);
    }

    static class Customer{

        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
