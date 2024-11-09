public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Иванов  Александр Михайлович", "Техник", "ivanov@mail.com", "+375(29)123-45-67", 1800, 45);
        empArray[1] = new Employee("Романова Софья Максимовна", "Бухгалтер", "romanova@mail.com", "+375(29)231-47-65", 2600, 27);
        empArray[2] = new Employee("Астахов Юрий Владимирович", "Генеральный директор", "astahov@mail.com", "+375(29)631-47-52", 6790, 48);
        empArray[3] = new Employee("Зуева Елизавета Степановна", "Инженер по охране труда", "zueva@mail.com", "+375(29)136-75-24", 2100, 54);
        empArray[4] = new Employee("Морозов Савелий Константинович", "Специалист по защите информации", "morozov@mail.com", "+375(29)745-21-36", 3400, 23);
        Employee employee1 = empArray[4];
        employee1.info();
    }
}