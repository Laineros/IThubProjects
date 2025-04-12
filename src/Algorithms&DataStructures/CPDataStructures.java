import java.util.*;
import java.util.Queue;

public class CPDataStructures {
    public static void main(String[] args) {
        StackRealization.stackEx2();
        MaximumInSubset mi = new MaximumInSubset();
        System.out.println(mi.initialize(mi.getArrFromConsole(), mi.getKfromConsole()));
        MaintainingListOfActiveUsers list = new MaintainingListOfActiveUsers();
        list.processUserActions();
    }
}

class MaximumInSubset {
    Scanner sc = new Scanner(System.in);
    public int[] getArrFromConsole() {
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public int getKfromConsole() {
        System.out.println("Enter the size of the subset: ");
        return sc.nextInt();
    }
    public List<Integer> initialize(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result;
    }
}

class MaintainingListOfActiveUsers {
    private Scanner sc = new Scanner(System.in);
    private Queue<Client> activeUsersQueue = new LinkedList<>();

    public void processUserActions() {
        System.out.println("Enter user actions:");

        while (sc.hasNextLine()) {
            String action = sc.nextLine();
            if (action.equals("exit")) {
                break;
            }
            handleAction(action);
        }
    }

    private void handleAction(String action) {
        String[] parts = action.split(" ");
        String userName = parts[0];
        String actionType = parts[1];

        Client user = new Client(userName);

        if (actionType.equals("вошел")) {
            if (!isUserActive(user)) {
                activeUsersQueue.add(user);
            }
        } else if (actionType.equals("вышел")) {
            if (isUserActive(user)) {
                activeUsersQueue.remove(user);
            }
        }
        printActiveUsers();
    }

    private boolean isUserActive(Client user) {
        return activeUsersQueue.contains(user);
    }

    private void printActiveUsers() {
        System.out.print("Active users: ");
        for (Client user : activeUsersQueue) {
            System.out.print(user.getName() + " ");
        }
        System.out.println();
    }

    class Client {
        private String name;

        public Client(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Client client = (Client) o;
            return Objects.equals(name, client.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }
}