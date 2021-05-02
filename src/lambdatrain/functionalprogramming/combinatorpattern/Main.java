package lambdatrain.functionalprogramming.combinatorpattern;

import java.time.LocalDate;

import static lambdatrain.functionalprogramming.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "pouya",
                "pouya@gmai.com",
                "+09388773155",
                LocalDate.of(1992, 4, 26)
        );

        // System.out.println(new CustomerValidatorService().isValid(customer));

        // using combinator pattern
        /**
         * CustomerRegistrationValidator
         *                 .isEmailValid()
         *                 .and(CustomerRegistrationValidator.isPhoneNumberValid())
         *                 .and(CustomerRegistrationValidator.isAdult()).apply(customer);
         */
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult()).apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
