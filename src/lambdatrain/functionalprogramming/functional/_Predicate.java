package lambdatrain.functionalprogramming.functional;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("0912293"));
        System.out.println(isPhoneNumberValid("07122930872"));
        System.out.println(isPhoneNumberValid("09122930872"));

        //Predicate
        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("09122930872"));

        //chain in predicate with and / or ...
        System.out.println(isPhoneNumberValidPredicate.and(isPhoneNumberContain3Predicate).test("09122930872"));
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("09") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("09") && phoneNumber.length() == 11;

    static Predicate<String> isPhoneNumberContain3Predicate = phoneNumber ->
            phoneNumber.contains("3");
}
