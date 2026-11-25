package lab_exam_solution.data;

import lab_exam_solution.entities.Booking;
import lab_exam_solution.entities.Customer;
import lab_exam_solution.entities.Movie;
import lab_exam_solution.entities.Screening;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class BookingGenerator {

    private static final String [] DUMMY_FIRST_NAMES = {
            "Helen", "Norman", "Elias", "Gaius", "Kara",
            "Eleanor", "Athena", "Lee", "Minnie", "Laura",
            "Sam", "Boomer"
    };

    private static final String [] DUMMY_LAST_NAMES = {
            "Collins", "Adama", "Thrace", "Tyrell", "Baltar",
            "Colonial", "Helo", "Roslyn", "Addamson", "Enidsley",
            "Monster", "Pugsleyday", "Heiheiman"
    };

    private static final String [] DUMMY_EMAIL_DOMAINS = {
            "gmail.com", "outlook.com", "yahoo.com",
            "hotmail.com", "example.com"
    };

    private static final String [] DUMMY_MOVIE_TITLES = {
            "The Matrix",
            "Inception",
            "Interstellar",
            "Jurassic Park",
            "The Dark Knight",
            "Toy Story",
            "Finding Nemo",
            "Gladiator",
            "The Lion King",
            "Back to the Future"
    };

    private static final int [] DUMMY_MOVIE_DURATIONS = {
            136, 148, 169, 127, 152,
            81, 100, 155, 88, 116
    };

    private static final LocalTime [] DUMMY_SCREENING_TIMES = {
            LocalTime.of(10, 0),
            LocalTime.of(12, 30),
            LocalTime.of(15, 0),
            LocalTime.of(17, 30),
            LocalTime.of(19, 0),
            LocalTime.of(21, 30)
    };

    private static final Random RANDOM_GENERATOR = new Random();

    private static int customerCount = 0;
    private static int movieCount = 0;
    private static int screeningCount = 0;

    private static String allocateNextCustomerId(){
        customerCount++;
        return "C" + customerCount;
    }

    private static String allocateNextMovieId(){
        movieCount++;
        return "M" + movieCount;
    }

    private static String allocateNextScreeningId(){
        screeningCount++;
        return "S" + screeningCount;
    }

    private static String generateRandomName(){
        int firstNameIndex =
                RANDOM_GENERATOR.nextInt(DUMMY_FIRST_NAMES.length);
        String firstName = DUMMY_FIRST_NAMES[firstNameIndex];

        int lastNameIndex =
                RANDOM_GENERATOR.nextInt(DUMMY_LAST_NAMES.length);
        String lastName = DUMMY_LAST_NAMES[lastNameIndex];

        return firstName + " " + lastName;
    }

    private static String generateRandomEmail(String name){
        String emailName = name.toLowerCase().replace(" ", ".");

        int domainIndex =
                RANDOM_GENERATOR.nextInt(DUMMY_EMAIL_DOMAINS.length);

        String domain = DUMMY_EMAIL_DOMAINS[domainIndex];

        return emailName + "@" + domain;
    }

    private static Customer generateRandomCustomer(){
        String customerId = allocateNextCustomerId();
        String name = generateRandomName();
        String email = generateRandomEmail(name);

        return new Customer(customerId, email, name);
    }

    private static Movie generateRandomMovie(){
        int randomIndex =
                RANDOM_GENERATOR.nextInt(DUMMY_MOVIE_TITLES.length);

        String movieId = allocateNextMovieId();
        String title = DUMMY_MOVIE_TITLES[randomIndex];
        int duration = DUMMY_MOVIE_DURATIONS[randomIndex];

        return new Movie(movieId, title, duration);
    }

    private static Screening generateRandomScreening(){
        String screeningId = allocateNextScreeningId();

        Movie movie = generateRandomMovie();

        LocalDate date = LocalDate.now().plusDays(
                RANDOM_GENERATOR.nextInt(1, 15)
        );

        int randomTimeIndex =
                RANDOM_GENERATOR.nextInt(DUMMY_SCREENING_TIMES.length);

        LocalTime time = DUMMY_SCREENING_TIMES[randomTimeIndex];

        return new Screening(screeningId, movie, date, time);
    }

    public static Booking generateBooking(){
        Customer customer = generateRandomCustomer();
        Screening screening = generateRandomScreening();

        return new Booking(screening, customer);
    }

    public static void main(String[] args) {
        Booking [] bookings = new Booking[10];

        for (int i = 0; i < bookings.length; i++) {
            bookings[i] = generateBooking();
        }

        for(Booking b: bookings){
            System.out.println("Booking ID: " + b.getBookingId());
            System.out.println("Customer: " + b.getCustomer().getName());
            System.out.println("Movie: " +
                    b.getScreening().getMovie().getTitle());
            System.out.println("Screening Date: " +
                    b.getScreening().getDate());
            System.out.println("Screening Time: " +
                    b.getScreening().getTime());
            System.out.println("--------------------------------");
        }
    }
}
