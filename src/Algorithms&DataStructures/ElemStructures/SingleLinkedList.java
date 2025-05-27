package ElemStructures;

public class SingleLinkedList {

    Node head;

    static class Node {

        String FIO;
        String address;
        int assemp1;
        int assemp2;
        int assemp3;
        Node next;

        Node(String FIO, String address, int assemp1, int assemp2, int assemp3)
        {
            this.FIO = FIO;
            this.address = address;
            this.assemp1 = assemp1;
            this.assemp2 = assemp2;
            this.assemp3 = assemp3;
            next = null;
        }
    }

    public static SingleLinkedList insert(SingleLinkedList list, String FIO, String address, int assemp1, int assemp2, int assemp3)
    {
        Node new_node = new Node(FIO, address, assemp1, assemp2, assemp3);

        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }

    public static Double searchByAddress(SingleLinkedList list, String address) {
        Node currNode = list.head;
        Double sum = null;
        while (currNode != null) {
            if (currNode.address.toLowerCase().contains(address.toLowerCase())) {
                if (sum == null) {
                    sum = (double) (currNode.assemp1 + currNode.assemp2 + currNode.assemp3);
                    sum /= 3;
                    continue;
                }
                sum += currNode.assemp1 + currNode.assemp2 + currNode.assemp3;
                sum /= 4;
            }
            currNode = currNode.next;
        }
        return sum;
    }

    public static void printList(SingleLinkedList list)
    {
        Node currNode = list.head;

        System.out.println("LinkedList: ");

        while (currNode != null) {
            System.out.println(currNode.FIO + " " + currNode.address + " " + currNode.assemp1 + " " + currNode.assemp2 + " " + currNode.assemp3);

            currNode = currNode.next;
        }

        System.out.print("AVG - " + searchByAddress(list, "Минск"));
    }
    // Driver code
    public static void main(String[] args)
    {
        SingleLinkedList list = new SingleLinkedList();
        list = insert(list, "sdfgf sdfg sfgds", "Минск", 2, 2, 2);
        list = insert(list, "sdfgf sdfg sfgds", "Москва", 1, 2, 5);
        list = insert(list, "sdfgf sdfg sfgds", " malsd psang", 5, 2, 5);
        list = insert(list, "sdfgf sdfg sfgds", "Минск", 2, 2, 2);
        list = insert(list, "sdfgf sdfg sfgds", "Курск", 3, 4, 5);

        printList(list);
    }
}
