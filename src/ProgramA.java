import java.util.Scanner;

public class ProgramA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер очереди: ");
        int n = scanner.nextInt();

        Queue<Integer> queue = new Queue<>(n);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Извлечь элемент");
            System.out.println("3. Просмотреть первый элемент");
            System.out.println("4. Вывести количество элементов");
            System.out.println("5. Очистить очередь");
            System.out.println("6. Выход");

            System.out.print("\nВаш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("\nВведите число для добавления: ");
                        int num = scanner.nextInt();
                        queue.enqueue(num);
                        System.out.println(num + " добавлен в очередь.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int removed = queue.dequeue();
                        System.out.println(removed + " удален из очереди.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int first = queue.peek();
                        System.out.println(first + " находится первым в очереди.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(queue.getSize() + " элементов в очереди.");
                    break;
                case 5:
                    queue.clear();
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