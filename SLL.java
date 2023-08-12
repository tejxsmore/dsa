class SLL {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int val) {
            data = val;
            next = null;
        }
    }

    void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    void addAny(int val, int pos) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node prev = null;
        Node curr = head;
        while (pos > 1) {
            prev = curr;
            curr = curr.next;
            pos--;
        }
        prev.next = newNode;
        newNode.next = curr;
    }

    void deleteFirst() {
        if (head == null)
            return;

        head = head.next;
    }

    void deleteLast() {
        if (head == null)
            return;

        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }

    void deleteAny(int pos) {
        if (head == null)
            return;

        Node prev = null;
        Node curr = head;
        while (pos > 1) {
            prev = curr;
            curr = curr.next;
            pos--;
        }
        prev.next = curr.next;
    }

    Node reverseIt(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node reverseRe(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverseRe(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    int getSize() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    void print() {
        if (head == null) {
            System.out.println("EMPTY LIST");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " => ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SLL list = new SLL();
        list.addFirst(1);
        list.addFirst(0);
        list.print();

        list.addLast(4);
        list.addLast(5);
        list.print();

        list.addAny(2, 3);
        list.addAny(3, 4);
        list.print();

        list.deleteFirst();
        list.print();

        list.deleteLast();
        list.print();

        list.deleteAny(4);
        list.print();

        System.out.print("Reverse Iteratively : ");
        list.head = list.reverseIt(list.head);
        list.print();

        System.out.print("Reverse Recursively : ");
        list.head = list.reverseRe(list.head);
        list.print();

        System.out.println("Get Size : " + list.getSize());
    }
}
