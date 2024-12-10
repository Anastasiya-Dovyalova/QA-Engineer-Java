import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        List<String> newList = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();

        list.add("киви");
        list.add("мандарин");
        list.add("виноград");
        list.add("клубника");
        list.add("ежевика");
        list.add("виноград");
        list.add("вишня");
        list.add("лимон");
        list.add("киви");
        list.add("мандарин");
        list.add("хурма");
        list.add("инжир");
        list.add("арбуз");
        list.add("лимон");
        list.add("мандарин");
        list.add("виноград");

        for (String o : list) {
            map.put(o, map.getOrDefault(o, 0) + 1);
            if (!newList.contains(o)) {
                newList.add(o);
            }
        }
        System.out.println("Список уникальных фруктов: " + newList);
        System.out.println("Количество каждого фрукта: " + map);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+375298765612");
        phoneBook.add("Петров", "+3752349856");
        phoneBook.add("Сидоров", "+375256237089");
        phoneBook.add("Иванов", "+375292913874");
        phoneBook.printBook();
        System.out.println(phoneBook.get("Иванов"));
    }
}
