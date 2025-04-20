import java.time.LocalDate;

public record Transaction(int id, String description, double amount, LocalDate date) {
}
