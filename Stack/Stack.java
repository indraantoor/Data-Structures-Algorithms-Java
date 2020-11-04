public class Stack {

    // NODE
    public class Node {

        public String data;
        private Node next;
        private Node previous;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public void setNextNode(Node node) {
            this.next = node;
        }

        public void setPreviousNode(Node node) {
            this.previous = node;
        }

        public Node getNextNode() {
            return this.next;
        }

        public Node getPreviousNode() {
            return this.previous;
        }

    }

    // LINKED LIST
    public class LinkedList {

        public Node head;

        public LinkedList() {
            this.head = null;
        }

        public void addToHead(String data) {
            Node newHead = new Node(data);
            Node currentHead = this.head;
            this.head = newHead;
            if (currentHead != null) {
                this.head.setNextNode(currentHead);
            }
        }

        public void addToTail(String data) {
            Node tail = this.head;
            if (tail == null) {
                this.head = new Node(data);
            } else {
                while (tail.getNextNode() != null) {
                    tail = tail.getNextNode();
                }
                tail.setNextNode(new Node(data));
            }
        }

        public String removeHead() {
            Node removedHead = this.head;
            if (removedHead == null) {
                return null;
            }
            this.head = removedHead.getNextNode();
            return removedHead.data;
        }

        public String toString() {
            Node currentNode = this.head;
            String output = "<head> ";
            while (currentNode != null) {
                output += currentNode.data + " ";
                currentNode = currentNode.getNextNode();
            }
            output += "<tail>";
            return output;
        }
    }

    // STACK IMPLEMENTATION
    public LinkedList stack;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(String data) {
        if (this.hasSpace()) {
            this.stack.addToHead(data);
            this.size++;
            System.out.println("Added " + data + "! Stack size is now " + this.size);
        } else {
            throw new Error("Stack is full!");
        }
    }

    public String pop() {
        if (!this.isEmpty()) {
            String data = this.stack.removeHead();
            this.size--;
            System.out.println("Removed " + data + "! Stack size is now " + this.size);
            return data;
        } else {
            throw new Error("Stack is empty!");
        }
    }

    public String peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.stack.head.data;
        }
    }

    public static void main(String[]args) {
        Stack things = new Stack();
        things.push("house");
        things.push("car");
        things.pop();
    }
}