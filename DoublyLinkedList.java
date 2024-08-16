public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        //START FIX HERE
        this.listName = name;
        //END FIX HERE
    }
    
    public void PopTail() {
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
        }
        else {
            if (head.next == null && tail.previous == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
        }
        //END FIX HERE
    }
    
    public void PopHead(){
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
        }
        else {
            if (head.next == null && tail.previous == null) {
                head = null;
                tail = null;
            } else {
                Node curr = head;
                head = curr.next;
                
                head.previous = null;
            }
        }
        //END FIX HERE
    }
    
    public Node GetHead(){
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            return head;
        }
        //END FIX HERE
    }
    
    public Node GetTail(){
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            return tail;
        }
        //END FIX HERE
    }
    
    public void PushHead(Node node){
        //START FIX HERE
        if (IsEmpty()) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head = node;

            Node curr = head.next;
            curr.previous = head;
        }
        //END FIX HERE
    }
    
    public void PushTail(Node node) {
        //START FIX HERE
        if (IsEmpty()) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;

            Node curr = tail.next;
            curr.previous = tail;

            tail = tail.next;
        }
        //END FIX HERE
    }

    public Node FindNode(int id){
        //START FIX HERE
        if (IsEmpty()) {
            return new Node("Empty List!");
        }
        else {
            Node curr = head;
            while (curr != null) {
                if (curr.heroId == id) {
                    return curr;
                }
                curr = curr.next;
            }
            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }
    
    public Node EraseNode(int id){
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            if (head.heroId == id) {
                Node tmp = head;
                head = head.next;
                head.previous = null;
                return tmp;
            } else if (tail.heroId == id) {
                Node tmp = tail;
                tail = tail.previous;
                tail.next = null;
                return tmp;
            } else {
                Node curr = head;
                while (curr != null) {
                    if (curr.heroId == id) {
                        Node tmp = curr;
                        curr = curr.previous;
                        curr.next = curr.next.next;

                        return tmp;
                    }
                    curr = curr.next;
                }
            }
            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }
    
    public void AddNodeAfter(Node node1, Node node2){
        //START FIX HERE
        if (node1 == tail) {
            node1.next = node2;
            node2.previous = node1;

            tail = node2;
        } else {
            node2.next = node1.next;
            node2.previous = node1;

            node1.next = node2;

            Node curr = node2.next;
            curr.previous = node2;
        }
        //END FIX HERE
    }
    
    public void AddNodeBefore(Node node1, Node node2){
        //START FIX HERE
        if (node1 == head) {
            node2.next = head;
            head.previous = node2;

            head = node2;
        } else {
            node2.next = node1;
            node2.previous = node1.previous;

            node1.previous = node2;

            Node curr = node2.previous;
            curr.next = node2;
        }
        //END FIX HERE
    }
    
    public boolean IsEmpty(){
        //START FIX HERE
        return head == null && tail == null;
        //END FIX HERE
    }
    public void Merge(DoublyLinkedList list){
        //START FIX HERE
        if (list.IsEmpty()) return;
        this.tail.next = list.head;
        list.head.previous = this.tail;
        this.tail = list.tail;
        //END FIX HERE
    }
    
    public void PrintStructure(){
        //START FIX HERE
        Node curr = head;
        System.out.print(listName + ": head <-> ");
        while(curr != null){
            System.out.print("{" + curr.heroId + "} <-> ");
            curr = curr.next;
        }
        System.out.println("tail");
        //END FIX HERE
    }
    
    // This may be useful for you for implementing printStructure()
    public void PrintStructureTailward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.heroId + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node GetHighestHPHero(){
        //START FIX HERE
        if (IsEmpty()) {
            return new Node("Empty List!");
        } else {
            Node curr = head;
            Node maxHPHero = curr;
            curr = curr.next;
            while (curr != null) {
                if (curr.hp >= maxHPHero.hp) {
                    maxHPHero = curr;
                }
                curr = curr.next;
            }
            return maxHPHero;
        }
        //END FIX HERE
    }
    public double GetMiddleHP(){
        //START FIX HERE
        if (IsEmpty()) {
            return 0.0;
        }
        Node c1 = head;
        Node c2 = tail;

        double midHP = 0.0;
        while (c1 != null && c2 != null) {
            if (c1.next == c2) {
                midHP = (c1.hp + c2.hp) / 2.0;
                break;
            } else if (c1 == c2) {
                midHP = c1.hp;
                break;
            }
            c1 = c1.next;
            c2 = c2.previous;
        }
        return midHP;
        //END FIX HERE
    }
    public void PrintHeroWithType(Attribute att){
        if (IsEmpty()){
            System.out.println("Empty List!");
            return;
        }
        //START FIX HERE
        int n=0;
        Node curr = head;
        while (curr != null) {
            if (curr.att == att) {
                n++;
            }
            curr = curr.next;
        }

        if (n == 0) {
            System.out.println("There is no hero with this attribute");
        } else if (n == 1) {
            System.out.printf("Print Hero With This Attribute: %s has %d hero\n",att, n);
        } else {
            System.out.printf("Print Hero With This Attribute: %s has %d heroes\n",att, n);
        }

        int i = n;
        curr = head;
        while (curr != null) {
            if (curr.att == att) {
                System.out.printf("%d. HeroID: %d , Name: %s , HP: %.1f, Attribute: %s\n", i, curr.heroId, curr.name, curr.hp, curr.att);
                i--;
            }
            curr = curr.next;
        }
        // END FIX HERE
    }
}

