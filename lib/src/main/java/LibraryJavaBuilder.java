import java.time.LocalDateTime;
import java.util.List;

public class LibraryJavaBuilder {
    private List<String> books;
    private LocalDateTime opensAt;
    private LocalDateTime closesAt;

    public LibraryJavaBuilder setBooks(List<String> books) {
        this.books = books;
        return this;
    }

    public LibraryJavaBuilder setOpensAt(LocalDateTime opensAt) {
        this.opensAt = opensAt;
        return this;
    }

    public LibraryJavaBuilder setClosesAt(LocalDateTime closesAt) {
        this.closesAt = closesAt;
        return this;
    }

    public LibraryJava createLibrary() {
        return new LibraryJava(books, opensAt, closesAt);
    }
}