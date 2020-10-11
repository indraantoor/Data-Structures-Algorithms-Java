public class Node {

    public String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }

    public Node getNextNode() {
        return this.next;
    }

    public static void main(String[] args) {
        // TEST
        Node strawberry = new Node("Strawberry First");
        Node banana = new Node("Banana Second");
        Node coconut = new Node("Coconut Third");

        strawberry.setNextNode(banana);
        banana.setNextNode(coconut);

        Node currentNode = strawberry;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.getNextNode();
        }
    }

}
