
import java.time.LocalDateTime;
import java.util.List;

class LibraryJava {

    private final List<String> books;
    private final LocalDateTime opensAt;
    private final LocalDateTime closesAt;

    public LibraryJava(List<String> books, LocalDateTime opensAt, LocalDateTime closesAt) {
        this.books = books;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
    }

    public List<String> getBooks() {
        return books;
    }

    public LocalDateTime getOpensAt() {
        return opensAt;
    }

    public LocalDateTime getClosesAt() {
        return closesAt;
    }
}