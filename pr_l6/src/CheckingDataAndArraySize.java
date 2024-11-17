public class CheckingDataAndArraySize {
    private int sum = 0;
    public int CheckingArray(String[][] arr)
            throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Неверный размер массива. Массив должен быть размером 4х4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Неверный размер массива. Массив должен быть размером 4х4");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + arr[i][j]);
                }
            }
        }
        return sum;
    }
}
