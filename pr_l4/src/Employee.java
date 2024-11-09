public class Employee {
    private String fullName;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String jobTitle, String email,
                    String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("ФИО: " + fullName + ";\n" + "Должность: " + jobTitle + ";\n" +
                "email: " + email + ";\n" + "Телофон: " + phoneNumber + ";\n" +
                "Зарплата: " + salary + ";\n" + "Возраст: " + age + ".");
    }
}
