import java.util.Scanner;

public class ProgramB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер очереди: ");
        int n = scanner.nextInt();

        Queue<Person> personQueue = new Queue<>(n);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Извлечь человека");
            System.out.println("3. Просмотреть первого человека");
            System.out.println("4. Вывести количество людей");
            System.out.println("5. Очистить очередь");
            System.out.println("6. Выход");

            System.out.print("\nВаш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.next();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    Person person = new Person(name, age);
                    try {
                        personQueue.enqueue(person);
                        System.out.println(person + " добавлен в очередь.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Person removed = personQueue.dequeue();
                        System.out.println(removed + " удален из очереди.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Person first = personQueue.peek();
                        System.out.println(first + " находится первым в очереди.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(personQueue.getSize() + " человек в очереди.");
                    break;
                case 5:
                    personQueue.clear();
                    System.out.println("Очередь очищена.");
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.err.println("Неверный ввод!");
            }
        }
    }
}