public class Food {
    private int foodAmount;

    public Food(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean eating(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void foodInfo() {
        System.out.println("Количество еды в миске: " + foodAmount);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        } else {
            System.out.println("Добавьте положительное количество еды");
        }
    }
}
