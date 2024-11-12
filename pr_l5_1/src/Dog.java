public class Dog extends Animal {
    private static int countDog = 0;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int runDistance) {
        if (runDistance <= 500) {
            System.out.println(name + " пробежал: " + runDistance + "m");
        } else {
            System.out.println(name + " не может пробежать: " + runDistance +
                    "m. Максимальная дистанции – 500m");
        }
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance <= 10) {
            System.out.println(name + " проплыл: " + swimDistance + "m");
        } else {
            System.out.println(name + " не может проплыть: " + swimDistance +
                    "m. Максимальная дистанции – 10m");
        }
    }

    public void infoDog() {
        System.out.println("Количество созданных собак: " + countDog);
    }
}
