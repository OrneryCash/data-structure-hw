public class Node extends BTreePrinter { // Fix this line

    Node left;
    Node right;
    int data;

    public Node(int data) {
        // Add something
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void printTree() {
        super.printTree(this);
    }

    public void printBFT() {
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
        // Do something
        q.enqueue(this);
        while (!q.isEmpty()) {
            Node curr = q.dequeue();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.enqueue(curr.left);
            }
            if (curr.right != null) {
                q.enqueue(curr.right);
            }
        }
        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        // Do something
        s.push(this);
        while (!s.isEmpty()) {
            Node curr = s.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
        System.out.println("]");
    }
}
