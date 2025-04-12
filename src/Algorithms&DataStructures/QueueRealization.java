class QueueRealization {
    public static void main(String[] args) {
        queueEx1();
        queueEx2();
    }
    public static void queueEx1() {
        QueueReal queueRealInShop = new QueueReal(7);
        queueRealInShop.enQueue("a");
        queueRealInShop.enQueue("b");
        queueRealInShop.enQueue("c");
        queueRealInShop.deQueue();
        queueRealInShop.peek();
    }
    public static void queueEx2() {
        QueueRealInShop queueInShop = new QueueRealInShop(8);
        queueInShop.enQueue("Client1");
        queueInShop.enQueue("Client2");
        queueInShop.enQueue("Client3");
        queueInShop.enQueue("Client4");
        queueInShop.deQueue();
        queueInShop.peek();
    }
}
class QueueRealInShop extends QueueReal {
    private int size;
    private String[] array;
    private int front = -1;
    private int rear = -1;
    void numberInQueueFromBack() {
        System.out.println("numberInQueue: " + rear);
    }
    void timeInQueueFromBack() {
        System.out.println("timeInQueue: " + (rear*2));
    }
    void timeInQueueFromForward() {
        System.out.println("timeInQueue: " + (front*2));
    }
    void numberInQueueFromForward() {
        System.out.println("numberInQueue: " + front);
    }
    QueueRealInShop(int size) {
        super(size);
        this.size = size;
        array = new String[size];
    }

    int size() {
        return size;
    }
    boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    boolean isFull() {
        return rear == size - 1;
    }
    void enQueue(String x) {
        if (isFull()) {
            System.out.println("QueueInShop is full");
            return;
        } else if (front == -1 && rear == -1) {
            System.out.println(array.length);
            front = rear = 0;
        } else {
            rear++;
        }
        array[rear] = x;
        numberInQueueFromBack();
        timeInQueueFromBack();
    }
    void deQueue() {
        if (isEmpty()) {
            System.out.println("QueueInShop is empty");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }
    void peek() {
        System.out.println(array[front]);
        numberInQueueFromForward();
        timeInQueueFromForward();
    }
}
class QueueReal {
    private int size;
    private String[] array;
    private int front = -1;
    private int rear = -1;
    QueueReal(int size) {
        this.size = size;
        array = new String[size];
    }

    int size() {
        return size;
    }
    boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    boolean isFull() {
        return rear == size - 1;
    }
    void enQueue(String x) {
        if (isFull()) {
            System.out.println("QueueInShop is full");
            return;
        } else if (front == -1 && rear == -1) {
            System.out.println(array.length);
            front = rear = 0;
        } else {
            rear++;
        }
        array[rear] = x;
    }
    void deQueue() {
        if (isEmpty()) {
            System.out.println("QueueInShop is empty");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }
    void peek() {
        System.out.println(array[front]);
    }

}
