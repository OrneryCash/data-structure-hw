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

    public Graph(int cap){
        // Pls initialize all varibles here
        this.vertexList = new Vertex[cap];
        this.adjacencyList = new LinkedList[cap];
        this.cap = cap;
        this.size = 0;
        this.cc = 0;
    }
    
    public void addVertex(int key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }
        
        // Create Vertex object and the LinkedList object
        // Add these objects to the corresponding arrays
        // finally, size++;
        Vertex v = new Vertex(key);
        vertexList[key] = v;
        LinkedList<Integer> l = new LinkedList<>();
        adjacencyList[key] = l;
        size++;
    }
    
    // Two way edge
    // If you make a path from u to v, you must make a path from v to u
    public void addEdge(int u, int v){
        if (vertexList[u]==null){
            System.out.println("Source node does not exist");
            return;
        } if (vertexList[v]==null){
            System.out.println("Destination node does not exist");
            return;
        }
        
        // Check if there is already an edge from u to v
        if (!isConnected(u, v)){
            // Add edge from Vertex(u) to Vertex(v)
            adjacencyList[u].add(v);
            // and then from Vertex(v) to Vertex(u)
            adjacencyList[v].add(u);
            
        }else{
            System.out.println("There is already an edge connecting vertex "+u+" and vertex "+v);
        }
    }
    
    // Check if Vertex(u) and Vertex(v) has an edge to one another
    public boolean isConnected(int u, int v){
        return adjacencyList[u].contains(v); // Fix this
    }

    // This function is complete, no need to edit
    // Please study how this function works
    // if you understand this function, you will undertand the whole homework
    public void showAdjacentVertices(int u){
        Vertex v = vertexList[u];
        System.out.print("Vertex " + v.strKey + " connected to the following vertices: ");
        
        LinkedList<Integer> list = adjacencyList[u];
        for (int vertex_index : list) {
            System.out.print(vertexList[vertex_index].strKey + ", ");
        }
        System.out.println();
    }  
    
    public void BFS(Vertex s){
      // Set all Vertex.dist to Infinity (Use Integer.MAX_VALUE to represent Infinity)
      for (int i = 0; i < cap; i++) {
          if (vertexList[i] != null) {
            vertexList[i].dist = Integer.MAX_VALUE;
          }
      }
      // Set dist of the start vertex (s) to 0
      // Push the start vertex to an empty queue
      s.dist = 0;
      Queue<Vertex> q = new LinkedList<>();
      q.add(s);
      // [*] Check if the queue is not empty
      // Pop the queue, and get the current vertex
      // Extract the list of all vertices that are connected to current vertex
      
      // Traverse all the list, and check if the dist value of anyone are still infinity or not
      // If yes,  push that vertex into the queue
      //          increase the dist variable of that vertex by one
      //          set the prev variable of that vertex to the current vertex
      
      // Repeat [*]
      while (!q.isEmpty()) {
          Vertex curr = q.remove();
          LinkedList<Integer> adj = adjacencyList[curr.intKey];
          for (int i = 0; i < adj.size(); i++) {
              Vertex vertex = vertexList[adj.get(i)];
              if (vertex.dist == Integer.MAX_VALUE) {
                  q.add(vertex);
                  vertex.dist = curr.dist + 1;
                  vertex.prev = curr;
              }
          }
      }
  }

  
  public Stack getShortestPathList(Vertex S, Vertex U){
    //FIX THIS
    if (U.prev == null) {
      System.out.printf("There is no path from %d to %d", S.intKey, U.intKey);
      return new Stack();
    }
      // Create a stack
      Stack<Vertex> s = new Stack<>();
      // Start from Vertex U
      // [*] push the current Vertex into the stack
      // Go back one Vertex using U.prev
      // Repeat [*] until you reach the Vertex S
      Vertex curr = U;
      while (curr != S) {
          s.push(curr);
          curr = curr.prev;
      }
      s.push(curr);
      // return the stack
      return s; // Fix this
  }
  
  public void printShortestPath(int s_index, int u_index){
    
      // Map Vertex names to index numbers
      // Get vertices from the vertexList
      // Run BFS() at the starting Vertex
      // Get shortestPartList(starting Vertex, ending Vertex)
      // Traverse all the stack and print the Vertex name
      BFS(vertexList[s_index]);
      Stack<Vertex> s = getShortestPathList(vertexList[s_index], vertexList[u_index]);
      if (s.empty()) return;
      while (s.peek() != vertexList[u_index]) {
          System.out.print(s.pop().intKey + " -> ");
      }
      System.out.println(s.pop().intKey);
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
