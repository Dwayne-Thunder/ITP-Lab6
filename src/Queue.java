public class Queue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    // Конструктор очереди с заданной ёмкостью
    public Queue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Проверка, пуста ли очередь
    public boolean isEmpty() {
        return size == 0;
    }

    // Проверка, заполнена ли очередь
    public boolean isFull() {
        return size == capacity;
    }

    // Добавление элемента в конец очереди
    public void enqueue(T item) throws Exception {
        if (isFull()) {
            throw new Exception("Очередь переполнена");
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    // Извлечение элемента из начала очереди
    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Очередь пуста");
        }
        T item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Получение первого элемента без извлечения
    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Очередь пуста");
        }
        return array[front];
    }

    // Размер очереди
    public int getSize() {
        return size;
    }

    // Очистка очереди
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    // Сравнение двух очередей на равенство
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Queue<?> other = (Queue<?>) obj;
        if (size != other.size)
            return false;

        for (int i = 0; i < size; i++) {
            if (!array[(front + i) % capacity].equals(other.array[(other.front + i) % other.capacity]))
                return false;
        }
        return true;
    }
}