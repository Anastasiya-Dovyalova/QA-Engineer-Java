public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        CheckingDataAndArraySize checkingDataAndArraySize = new CheckingDataAndArraySize();
        try {
            int sum = checkingDataAndArraySize.CheckingArray(arr);
            System.out.println("Массив корректного размера. Сумма элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}