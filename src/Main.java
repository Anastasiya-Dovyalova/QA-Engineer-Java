import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("№1");
        printThreeWords();
        System.out.println();
        System.out.println("№2");
        checkSumSign();
        System.out.println();
        System.out.println("№3");
        printColor();
        System.out.println();
        System.out.println("№4");
        compareNumbers();
        System.out.println();
        System.out.println("№5");
        System.out.println(checkingTheAmountRange(8, 6));
        System.out.println();
        System.out.println("№6");
        checkTheSign(785);
        System.out.println();
        System.out.println("№7");
        System.out.println(booleanCheckTheSign(-1));
        System.out.println();
        System.out.println("№8");
        printLine("Привет", 5);
        System.out.println();
        System.out.println("№9");
        System.out.println(definitionOfHighYear());
        System.out.println();
        System.out.println("№10");
        replacementMethod();
        System.out.println();
        System.out.println("№11");
        fillingMethod();
        System.out.println();
        System.out.println("№12");
        multiplyingByTwo();
        System.out.println();
        System.out.println("№13");
        createATwoDimensionalArray();
        System.out.println();
        System.out.println("№14");
        printOneDimensionalArray(7, 7);
    }

    //№1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    //№2
    public static void checkSumSign() {
        int a = 3;
        int b = 9;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    //№3
    public static void printColor() {
        int value = 8;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //№4
    public static void compareNumbers() {
        int a = 6;
        int b = 9;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //№5
    public static boolean checkingTheAmountRange(int a, int b)
    {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //№6
    public static void checkTheSign(int a) {
        if (a < 0) {
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }
    }
    //№7
    public  static  boolean booleanCheckTheSign(int a)
    {
        return a >= 0;
    }
    //№8
    public static void printLine(String str, int n)
    {
        for(int i = 0; i < n; i++){
            System.out.println(str);
        }
    }
    //№9
    public static boolean definitionOfHighYear()
    {
        int year = 2023;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return  true;
                }else {return false;}
            } else { return true;}
        }else {return false;}
    }
    //№10
    public static void replacementMethod()
    {
        int [] arr ={ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i]==1)
            {
                arr[i]=0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    //№11
    public static void fillingMethod()
    {
        int [] arr = new
                int[100];
        int counter = 1;
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = counter;
            counter++;
        }
        System.out.println(Arrays.toString(arr));
    }
    //№12
    public static void multiplyingByTwo()
    {
        int [] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 6){
                arr[i] = arr[i] * 2;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
    //№13
    public static void createATwoDimensionalArray(){
        int [] [] arr = new int [5] [5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(i == j)
                {
                    arr[i][j] = 1;
                }
                else
                {
                    arr[i][j]  = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    //14
    public static void printOneDimensionalArray(int len, int initialValue)
    {   int [] arr = new int [len];
        int count = initialValue;
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = count;
        }
        System.out.println(Arrays.toString(arr));
    }

}
