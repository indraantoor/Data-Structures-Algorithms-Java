import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    // TREE NODE
    public static class TreeNode {

        public Object data;
        public ArrayList<TreeNode> children;

        public TreeNode(Object data) {
            this.data = data;
            this.children = new ArrayList<TreeNode>();
        }

        public void addChild(TreeNode child) {
            this.children.add(child);
        }

        public void addChild(Object childData) {
            TreeNode child = new TreeNode(childData);
            this.children.add(child);
        }

        public void removeChild(TreeNode childToRemove) {
            if (this.children.isEmpty()) {
                return;
            } else if (this.children.contains(childToRemove)) {
                this.children.remove(childToRemove);
                return;
            } else {
                for (TreeNode child : this.children) {
                    child.removeChild(childToRemove);
                }
            }
        }

        public void removeChild(Object data) {
            if (this.children.isEmpty()) {
                return;
            }
            for (TreeNode child : this.children) {
                if (child.data == data) {
                    removeChild(child);
                    return;
                }
            }
            for (TreeNode child : this.children) {
                child.removeChild(data);
            }
        }
    }

    // TREE IMPLEMENTATION
    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void print() {
        print(this.root, 0);
    }

    public void print(TreeNode current, int level) {
        String levelMarks = "";
        for (int i = 0; i < level; i++) {
            levelMarks += "-- ";
        }
        System.out.println(levelMarks + current.data);
        for (TreeNode child : current.children) {
            print(child, level + 1);
        }
    }

    // Depth First Traversal
    public void depthFirstTraversal(TreeNode current) {
        System.out.print(current.data + " ");
        for (TreeNode child : current.children) {
            depthFirstTraversal(child);
        }
    }

    // Breadth First Traversal
    public void breadthFirstTraversal(){
        TreeNode current = this.root;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()){
            current = queue.poll();
            System.out.print(current.data + " ");
            queue.addAll(current.children);
        }

    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode("1");
        TreeNode child1 = new TreeNode("2");
        TreeNode child2 = new TreeNode("3");
        TreeNode grandchild1 = new TreeNode("4");
        TreeNode grandchild2 = new TreeNode("5");
        treeRoot.addChild(child1);
        treeRoot.addChild(child2);
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);

        Tree tree = new Tree(treeRoot);
        tree.print();

        System.out.println(" ");

        System.out.println("Breadth First Traversal");
        tree.breadthFirstTraversal();

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Depth First Traversal");
        tree.depthFirstTraversal(treeRoot);

    }

}
