package lab_exam_solution.entities;

import java.util.Objects;

public class Movie {
    private final String movieId;
    private final String title;
    private final int durationInMins;

    public Movie(String movieId, String title, int durationInMins) {
        if(movieId == null || movieId.isBlank()){
            throw new IllegalArgumentException("All Movies must contain a Movie ID");
        }

        this.movieId = movieId;
        this.title = title;
        this.durationInMins = durationInMins;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInMins() {
        return durationInMins;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(movieId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", durationInMins=" + durationInMins +
                '}';
    }
}
