public class Cat extends Animal {
    private static int countCat = 0;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        countCat += 1;
    }

    @Override
    public void run(int runDistance) {
        if (runDistance <= 200) {
            System.out.println(name + " пробежал: " + runDistance + "m");
        } else {
            System.out.println(name + " не может пробежать: " + runDistance +
                    "m. Максимальная дистанции – 200m");
        }
    }

    @Override
    public void swim(int swimDistance) {
        System.out.println(name + " не умеет плавать");
    }

    public void eat(Food bowl1) {
        if (bowl1.eating(60)) {
            satiety = true;
            System.out.println(name + " покушал");
        } else {
            System.out.println(name + " не хватило еды");
        }
    }

    public void infoSatiety() {
        if (satiety) {
            System.out.println(name + " сыт");
        }else {
            System.out.println(name + " голоден");
        }
    }

    public void infoCat() {
        System.out.println("Количество созданных котов: " + countCat);
    }
}
