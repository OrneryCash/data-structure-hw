import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked") 
public class Graph {
    
    Vertex[] vertexList; // This list contain vertices
    LinkedList<Integer>[] adjacencyList; // Graph implemented by Adjacency List
    
    int cap;
    int size;
    int cc;

    public Graph(int cap){ // Initialize constructor for graph
        // Pls initialize all varibles here
        this.vertexList = new Vertex[cap]; //create array that contain vertices and has cap size
        this.adjacencyList = new LinkedList[cap]; //create array that contain adjacency vertices and has cap size 
        this.cap = cap; //Initialize cap 
        this.size = 0; //Initialize size = 0
        this.cc = 0; //initialize cc
    }
    
    public void addVertex(int key){
         //create function to check if vertex list is full
        if (size==cap){ //if size equal cap print vertex list is full and return nothing
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }
        
        // Create Vertex object and the LinkedList object
        // Add these objects to the corresponding arrays
        // finally, size++;

        //if vertex list is not full 
        Vertex v = new Vertex(key); //create new vertex 
        vertexList[key] = v; //add vertex into vertex list
        LinkedList<Integer> l = new LinkedList<>(); //create new edge 
        adjacencyList[key] = l; //add edge to array of adjacencyList
        size++; //after adding vertex increase the size of vertex list
    }
    
    // Two way edge
    // If you make a path from u to v, you must make a path from v to u
    public void addEdge(int u, int v){ //create edge from vertex to vertex
        //create function to check if vertexList is null
        if (vertexList[u]==null){ //if source vertexList is null print source node does not exist and return nothing
            System.out.println("Source node does not exist");
            return;
        } if (vertexList[v]==null){ //if destination vertex is null print Destination node does not exist and return nothing
            System.out.println("Destination node does not exist");
            return;
        }
        
        // Check if there is already an edge from u to v
        if (!isConnected(u, v)){ //if both vertex is not connected to each other
            // Add edge from Vertex(u) to Vertex(v)
            adjacencyList[u].add(v);
            // and then from Vertex(v) to Vertex(u)
            adjacencyList[v].add(u);
            
        }else{ //if vertex is already connected to each other, then print There is already an edge connecting vertex u and vertex v
            System.out.println("There is already an edge connecting vertex "+u+" and vertex "+v);
        }
    }
    
    // Check if Vertex(u) and Vertex(v) has an edge to one another
    public boolean isConnected(int u, int v){
        return adjacencyList[u].contains(v); // return boolean that check if u has path to v
    }

    // This function is complete, no need to edit
    // Please study how this function works
    // if you understand this function, you will undertand the whole homework
    public void showAdjacentVertices(int u){
        Vertex v = vertexList[u]; //create vertex v that initailize as vertexList index u 
        System.out.print("Vertex " + v.strKey + " connected to the following vertices: "); //print vertex v's strkey 
        
        LinkedList<Integer> list = adjacencyList[u]; //create list that contains adjacencyList index u  
        for (int vertex_index : list) { //loop that print each strkey of vertex in vertexlist
            System.out.print(vertexList[vertex_index].strKey + ", ");
        }
        System.out.println();
    }  
    
    public void BFS(Vertex s){ 
      // Set all Vertex.dist to Infinity (Use Integer.MAX_VALUE to represent Infinity)
      for (int i = 0; i < cap; i++) { //loop that run until i equals cap
          //check if vertexList is null
          if (vertexList[i] != null) { //if vertexList at index i is not null set distance of that vertex to infinity
            vertexList[i].dist = Integer.MAX_VALUE;
          }
      }
      // Set dist of the start vertex (s) to 0
      // Push the start vertex to an empty queue
      s.dist = 0; 
      Queue<Vertex> q = new LinkedList<>(); //create queue
      q.add(s); //add vertex s to q
      // [*] Check if the queue is not empty
      // Pop the queue, and get the current vertex
      // Extract the list of all vertices that are connected to current vertex
      
      // Traverse all the list, and check if the dist value of anyone are still infinity or not
      // If yes,  push that vertex into the queue
      //          increase the dist variable of that vertex by one
      //          set the prev variable of that vertex to the current vertex
      
      // Repeat [*]
      while (!q.isEmpty()) { //loop that run while q of vertex is not empty
          Vertex curr = q.remove(); //dequeue vertex and set curr to contain the value we dequeue
          LinkedList<Integer> adj = adjacencyList[curr.intKey]; //create linkedlist that contains adjacencyList at index key of vertex curr
          for (int i = 0; i < adj.size(); i++) { //loop that continue until i equals adj size 
              Vertex vertex = vertexList[adj.get(i)]; //create vertex that value is vertex at index i of vertexlist
              //check if vertex distance isequal infinity
              if (vertex.dist == Integer.MAX_VALUE) { //if condition is true
                  q.add(vertex); //add vertex to queue
                  vertex.dist = curr.dist + 1; //set vertex distance to be curr distance + 1
                  vertex.prev = curr; //set previous vertex to curr
              }
          }
      }
  }

  
  public Stack getShortestPathList(Vertex S, Vertex U){ 
    //FIX THIS
    //check if vertex U 's previous vertex is null 
    if (U.prev == null) { //if previous vertex of U is null, then print There is no path from s.intkey to U.intkey and return empty stack
      System.out.printf("There is no path from %d to %d", S.intKey, U.intKey);
      return new Stack(); 
    }
      // Create a stack
      Stack<Vertex> s = new Stack<>(); 
      // Start from Vertex U
      // [*] push the current Vertex into the stack
      // Go back one Vertex using U.prev
      // Repeat [*] until you reach the Vertex S
      Vertex curr = U; //create vertex curr and initialize its value to be as U
      while (curr != S) { //push curr to stack and curr's previous vertex until curr is not equal S
          s.push(curr);
          curr = curr.prev;
      }
      s.push(curr);
      // return the stack
      return s; // Fix this
  }
  
  public void printShortestPath(int s_index, int u_index){
    
      
      
      
      // Get shortestPartList(starting Vertex, ending Vertex)
      // Traverse all the stack and print the Vertex name
      BFS(vertexList[s_index]); // Map Vertex names to index numbers
      Stack<Vertex> s = getShortestPathList(vertexList[s_index], vertexList[u_index]); // Get vertices from the vertexList
      if (s.empty()) return; //if stack is empty return nothing
      while (s.peek() != vertexList[u_index]) {  //loop that print key of vertex that pop out of stack while first vertex of stack is not equal vertex at index u
          System.out.print(s.pop().intKey + " -> ");
      }
      System.out.println(s.pop().intKey);  //print last vertex
  }
    
    
    // This is editable test case, but no need to edit
    public static Graph constructGraph1(){
        Graph graph = new Graph(32); 
        for (int i=0; i<16; i++)
            graph.addVertex(i);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 8);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(6, 10);
        graph.addEdge(6, 9);
        graph.addEdge(7, 14);
        graph.addEdge(8, 9);
        graph.addEdge(8, 13);
        graph.addEdge(8, 12);
        graph.addEdge(10, 14);
        graph.addEdge(11, 15);
        graph.addEdge(13, 14);
        graph.addEdge(14, 15);
        
        return graph;
    }
    
    // This is editable test case, but no need to edit
    public static Graph constructGraph2(){
        Graph graph = new Graph(32); 
        for (int i=0; i<16; i++)
            graph.addVertex(i);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(5, 9);
        graph.addEdge(6, 9);
        graph.addEdge(7, 14);
        graph.addEdge(8, 13);
        graph.addEdge(8, 12);
        graph.addEdge(10, 14);
        graph.addEdge(11, 15);
        graph.addEdge(14, 15);
        return graph;
    }
}
