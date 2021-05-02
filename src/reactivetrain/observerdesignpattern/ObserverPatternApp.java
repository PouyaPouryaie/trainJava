package reactivetrain.observerdesignpattern;

public class ObserverPatternApp {

    public static void main(String[] args) {

        Book book = new Book("Goosebumps", "horror","Xyz" ,200.0, "sold out");

        EndUser endUser1 = new EndUser("bob", book);
        EndUser endUser2 = new EndUser("rob", book);

        System.out.println(book.getInStock());

        book.setInStock("In stock");
    }
}
