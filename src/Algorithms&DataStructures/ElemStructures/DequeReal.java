package ElemStructures;

// Класс узла двусвязного списка
class Node {
    String value;
    Client client;
    Node prev;
    Node next;

    public Node(String value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    public Node(Client client) {
        this.client = client;
        this.prev = null;
        this.next = null;
    }
}

public class DequeReal {
    private Node front;
    private Node rear;
    private int size;

    public DequeReal() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void addFirst(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public String removeFirst() {
        checkOnIllegalStateException();
        String value = front.value;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return value;
    }
    public void checkOnIllegalStateException() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("ElemAlgos.DequeReal is empty.");
        }
    }
    public String removeLast() {
        checkOnIllegalStateException();
        String value = rear.value;
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return value;
    }

    public String peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("ElemAlgos.DequeReal is empty.");
        }
        return front.value;
    }

    public String peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("ElemAlgos.DequeReal is empty.");
        }
        return rear.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

class DequeTest {
    public static void main(String[] args) {
        DequeReal dequeReal = new DequeReal();

        dequeReal.addFirst("A");
        dequeReal.addLast("B");
        dequeReal.addFirst("C");
        dequeReal.addLast("D");

        System.out.println("Размер дека: " + dequeReal.size());
        System.out.println("Первый элемент: " + dequeReal.peekFirst());
        System.out.println("Последний элемент: " + dequeReal.peekLast());

        System.out.println("Удален первый элемент: " + dequeReal.removeFirst());
        System.out.println("Удален последний элемент: " + dequeReal.removeLast());

        System.out.println("Размер дека: " + dequeReal.size());
        System.out.println("Первый элемент: " + dequeReal.peekFirst());
        System.out.println("Последний элемент: " + dequeReal.peekLast());

        dequeReal.removeFirst();
        dequeReal.removeLast();

        System.out.println("Дек пуст: " + dequeReal.isEmpty());
    }
}
class ClientDeque {
    private Node front;
    private Node rear;
    private int size;

    public ClientDeque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void addLast(Client client) {
        Node newNode = new Node(client);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    public Client removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("ElemAlgos.DequeReal is empty.");
        }
        Client client = front.client;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return client;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Client peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("ElemAlgos.DequeReal is empty.");
        }
        return front.client;
    }

    public Client peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("ElemAlgos.DequeReal is empty.");
        }
        return rear.client;
    }
}

class Client {
    String name;
    boolean isVip;

    public Client(String name, boolean isVip) {
        this.name = name;
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return (isVip ? "VIP " : "Обычный ") + name;
    }
}

class BankQueueSimulation {
    public static void main(String[] args) {
        ClientDeque clientDeque = new ClientDeque();

        // Добавляем VIP клиентов сначала
        clientDeque.addLast(new Client("Leo", true));
        clientDeque.addLast(new Client("Artem", true));
        clientDeque.addLast(new Client("Yura", true));

        // Добавляем обычных клиентов потом
        clientDeque.addLast(new Client("Te Yan", false));
        clientDeque.addLast(new Client("Daniil", false));

        System.out.println("Обслуживание клиентов:");
        while (!clientDeque.isEmpty()) {
            System.out.println(clientDeque.removeFirst());
        }
    }
}
