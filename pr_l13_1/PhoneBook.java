import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PhoneBook {
    Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (book.containsKey(surname)) {
            book.get(surname).add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            book.put(surname, numbers);
        }
    }

    public List<String> get(String surname) {
        return book.get(surname);
    }

    public void printBook() {
        System.out.println(book);
    }
}
