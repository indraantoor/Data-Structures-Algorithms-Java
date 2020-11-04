public class Queue {
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

    public LinkedList queue;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Queue() {
        this(DEFAULT_MAX_SIZE);
    }

    public Queue(int maxSize) {
        this.queue = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(String data) {
        if (this.hasSpace()) {
            this.queue.addToTail(data);
            this.size++;
            System.out.println("Added " + data + "! Queue size is now " + this.size);
        } else {
            throw new Error("Queue is full!");
        }
    }

    public String dequeue() {
        if (!this.isEmpty()) {
            String data = this.queue.removeHead();
            this.size--;
            System.out.println("Removed " + data + "! Queue size is now " + this.size);
            return data;
        } else {
            throw new Error("Queue is empty!");
        }
    }

    public String peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.queue.head.data;
        }
    }

    public static void main(String[] args) {
        Queue boundedQueue = new Queue(4);
        boundedQueue.enqueue("pizza");
        boundedQueue.dequeue();
    }
}