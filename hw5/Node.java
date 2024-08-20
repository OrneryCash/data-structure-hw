public class Node extends BTreePrinter { //setting Node to inherit the traits of BTreePrinter which is a class

    Node left; 
    Node right;
    int data;

    public Node(int data) { //create constructor to contain an input data when create a new Node 
        // Add something
        this.data = data;
        this.left = null; 
        this.right = null;
    }

    public void printTree() { //function that print Tree structure
        super.printTree(this);  //use function printTree from class BTreePrinter 
    }

    public void printBFT() { //function that print data of each node in Tree by Breadth first traversal method 
        Queue q = new Queue(50); //create a queue to implement Tree by BFT method
        System.out.print("BFT node sequence [ ");
        // Do something
        q.enqueue(this); //enqueue root node to queue
        while (!q.isEmpty()) { //loop that continue until queue is empty
            Node curr = q.dequeue(); //create node name curr to contain first node of queue after dequeue root node from queue
            System.out.print(curr.data + " "); //print curr node's data
            if (curr.left != null) { //check if the first node in queue has left node
                q.enqueue(curr.left); //if the node has left node ,then enqueue that node's left node into queue
            }
            if (curr.right != null) { //check if the first node in queue has right node
                q.enqueue(curr.right); //if the node has right node, then enqueue that node's right node into queue
            }
        }
        System.out.println("]");
    }

    public void printDFT() { // function that print data of each node in Tree by Depth first traversal method (Preorder)
        Stack s = new Stack(50); //create a stack to implement Tree by DFT method (Preorder)
        System.out.print("DFT node sequence [ ");
        // Do something
        s.push(this); //push root node into stack
        while (!s.isEmpty()) { //loop that continue until stack is empty
            Node curr = s.pop(); //create node name curr to contain root node after pop root node from stack
            System.out.print(curr.data + " "); //print curr node's data
            if (curr.right != null) { //check if the last node in stack has right node
                s.push(curr.right); // if the node has right node, then push that node's right node into stack 
            }
            if (curr.left != null) { //check if the last node in stack has left node
                s.push(curr.left); //if the node has left node, then push that node's left node into stack
            }
        }
        System.out.println("]");
    }
}
