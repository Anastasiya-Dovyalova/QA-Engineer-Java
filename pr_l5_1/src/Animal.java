public class Animal {
    protected String name;
    private static int count = 0;

    public Animal(String name) {
        this.name = name;
        count += 1;
    }

    public void run(int runDistance) {
        System.out.println(name + " пробежал: " + runDistance + "m");
    }

    public void swim(int swimDistance) {
        System.out.println(name + " проплыл: " + swimDistance + "m");
    }

    public void info() {
        System.out.println("Количество созданных животных: " + count);
    }
}
