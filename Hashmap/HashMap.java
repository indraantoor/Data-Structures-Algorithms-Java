public class HashMap {

    // NODE
    public class Node {
        public String key;
        public String value;
        private Node next;

        public Node(String key, String value) {
            this.key  = key;
            this.value = value;
            this.next = null;
        }

        public void setNextNode(Node node) {
            this.next = node;
        }

        public Node getNextNode() {
            return this.next;
        }

        public void setKeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // LINKED LIST
    public class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }

        public void addToHead(String key, String value) {
            Node newHead = new Node(key, value);
            Node currentHead = this.head;
            this.head = newHead;
            if (currentHead != null) {
                this.head.setNextNode(currentHead);
            }
        }

        public void addToTail(String key, String value) {
            Node tail = this.head;
            if (tail == null) {
                this.head = new Node(key, value);
            } else {
                while (tail.getNextNode() != null) {
                    tail = tail.getNextNode();
                }
                tail.setNextNode(new Node(key, value));
            }
        }

        public void removeHead() {
            Node removedHead = this.head;
            if (removedHead == null) {
                return;
            }
            this.head = removedHead.getNextNode();
        }
    }

    // HASHMAP IMPLEMENTATION
    public LinkedList[] hashmap;

    public HashMap(int size) {
        this.hashmap = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.hashmap[i] = new LinkedList();
        }
    }

    public int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode + Character.codePointAt(key, i);
        }
        hashCode = hashCode % this.hashmap.length;
        return hashCode;
    }

    public void assign(String key, String value) {
        int arrayIndex = this.hash(key);
        LinkedList list = this.hashmap[arrayIndex];
        if (list.head == null) {
            list.addToHead(key, value);
            return;
        }
        Node current = list.head;
        while (current != null) {
            if (current.key == key) {
                current.setKeyValue(key, value);
            }
            if (current.getNextNode() == null) {
                current.setNextNode(new Node(key, value));
                break;
            }
            current = current.getNextNode();
        }
    }

    public String retrieve(String key) {
        int arrayIndex = this.hash(key);
        Node current = this.hashmap[arrayIndex].head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap food = new HashMap(2);
        food.assign("item1", "pizza");
        food.assign("item2", "burger");
        System.out.println(food.retrieve("item1"));
        System.out.println(food.retrieve("item2"));
    }
}