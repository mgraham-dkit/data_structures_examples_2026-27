package lab_exam_solution.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Screening {
    private final String screeningId;
    private final Movie movie;
    private final LocalDate date;
    private final LocalTime time;

    public Screening(String screeningId, Movie movie, LocalDate date, LocalTime time) {
        if(screeningId == null || screeningId.isBlank()){
            throw new IllegalArgumentException("All Screenings must contain a screening ID");
        }

        if(movie == null){
            throw new IllegalArgumentException("All Screenings must contain a Movie");
        }

        if(date == null || time == null){
            throw new IllegalArgumentException("All Screenings must contain a date and time");
        }

        this.screeningId = screeningId;
        this.movie = movie;
        this.date = date;
        this.time = time;
    }

    public String getScreeningId() {
        return screeningId;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Screening screening = (Screening) o;
        return screeningId.equals(screening.screeningId);
    }

    @Override
    public int hashCode() {
        return screeningId.hashCode();
    }

    @Override
    public String toString() {
        return "Screening{" +
                "screeningId='" + screeningId + '\'' +
                ", movie=" + movie +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
