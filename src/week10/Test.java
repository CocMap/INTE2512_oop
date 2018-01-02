package week10;

public class Test {
    public static void main(String[] args) {
        // Create 3 movies, one of each type
        String[] titles = {"Beauty and the Beast", "Top Gun", "Star Wars: The Last Jedi"};
        int[] codes = {2, 0, 1};
        Movie[] movies = new Movie[3];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = new Movie(titles[i], codes[i]);
        }

        // Create a customer object
        Customer john = new Customer("John Doe");

        // Create rentals and add them to John's object
        Rental[] rentals = new Rental[3];
        for (int i = 0; i < rentals.length; i++) {
            rentals[i] = new Rental(movies[i], i + 1);
            john.addRental(rentals[i]);
        }

        // Print out John's statement
        System.out.println(john.statement());
    }
}
