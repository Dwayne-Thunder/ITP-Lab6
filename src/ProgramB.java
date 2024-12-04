import java.util.Scanner;

public class ProgramB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер очереди: ");
        int n = scanner.nextInt();

        Queue<SmallBusiness> businessQueue = new Queue<>(n);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить предприятие");
            System.out.println("2. Извлечь предприятие");
            System.out.println("3. Просмотреть первое предприятие");
            System.out.println("4. Вывести количество предприятий");
            System.out.println("5. Очистить очередь");
            System.out.println("6. Выход");

            System.out.print("\nВаш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после ввода числа

            switch (choice) {
                case 1:
                    System.out.print("Введите тип предприятия (Магазин/Парикмахерская): ");
                    String type = scanner.nextLine();
                    System.out.print("Введите название предприятия: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите имя владельца: ");
                    String owner = scanner.nextLine();

                    SmallBusiness business = new SmallBusiness(type, name, owner);
                    try {
                        businessQueue.enqueue(business);
                        System.out.println(business + " добавлено в очередь.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        SmallBusiness removed = businessQueue.dequeue();
                        System.out.println(removed + " удалено из очереди.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        SmallBusiness first = businessQueue.peek();
                        System.out.println(first + " находится первым в очереди.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println(businessQueue.getSize() + " предприятий в очереди.");
                    break;

                case 5:
                    businessQueue.clear();
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
