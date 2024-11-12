public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Феликс");
        Dog dog1 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Food bowl1 = new Food(0);
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Тишка");
        cat[1] = new Cat("Пушок");
        cat[2] = new Cat("Кузя");
        dog1.run(589);
        dog1.swim(10);
        cat1.run(23);
        cat1.swim(2);
        cat2.run(234);
        cat2.swim(2);
        animal.info();
        dog1.infoDog();
        cat1.infoCat();
        bowl1.foodInfo();
        bowl1.addFood(200);
        bowl1.foodInfo();
        cat1.eat(bowl1);
        bowl1.foodInfo();
        cat2.eat(bowl1);
        bowl1.foodInfo();
        for (Cat objCat : cat) {
            objCat.eat(bowl1);
        }
        bowl1.foodInfo();
        for (Cat objCat : cat) {
            objCat.infoSatiety();
        }
    }
}