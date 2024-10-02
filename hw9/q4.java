import java.util.LinkedList;


@SuppressWarnings("unchecked") 
public class HashGraph extends Graph{
    
    int p; // Big Prime (for PolyHash())
    int x; // Small number (for PolyHash())
    
    public HashGraph(int cap, int p, int x){
        super(cap);
        this.p = p;
        this.x = x;
    }
    
    public static int polyHash(String s, int p, int x){
        int hash = 0;
        for (int i=s.length()-1; i>=0; i--){
            hash = (hash*x + (int)s.charAt(i))%p;
        }
        return hash;
    }
    
    public int getListIndex(String s){
        int index = HashGraph.polyHash(s,p,x) % cap;
        if (vertexList[index] == null || vertexList[index].strKey.equals(s))
            return index;
        
        for (int k=1; k<cap; k++){
            index = (index + k) % cap;
            if (vertexList[index] == null || vertexList[index].strKey.equals(s))
                return index;
        }
        return index;
    }

    public void addVertex(String key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to rehash");
            return;
        }
        int index = getListIndex(key);
        vertexList[index] = new Vertex(key); // an Array of list contains many Lists
        adjacencyList[index] = new LinkedList(); // Add list object to the adjacency list
        size++;
    }
    
    public void addEdge(String source, String destination){
        int u = getListIndex(source);
        int v = getListIndex(destination);
        super.addEdge(u, v);
    }
    
    // This function is complete, no need to edit
    public void showVertexList(){
        for (int i=0; i<vertexList.length; i++){
            if (vertexList[i]!=null)
                System.out.println("vertexList["+i+"] contains "+vertexList[i].strKey);
            else
                System.out.println("vertexList["+i+"] null");
        }
    }

    public void Explore(Vertex v){
        
      // Mark this vertex for visited
      v.visited = true;
      // Stamp the current cc number to this vertex (ccNum)
      v.ccNum = cc;
      
      // Print vertex
      
      System.out.printf("%s[%d]", v.strKey, cc);
      
      
      // Extract the list of all vertices that are connected to Vertex v
      
      // Traverse all the list check if anyone are already visited or not
      // If no, then explore the vertex
      int index = getListIndex(v.strKey);
      LinkedList<Integer> adj = adjacencyList[index];
      for (int i = 0; i < adj.size(); i++) {
          Vertex vertex = vertexList[adj.get(i)];
          if (!vertex.visited) {
              System.out.print(" -> ");
              Explore(vertex);
          }
      }

  }
  
  public void DFS(){
      
      // Set cc (connected component number) to 1
      cc = 1;
      // Check all vertices if they are visited or not
      // If no, then explore the vertex, then increase cc by 1
      for (int i = 0; i < cap; i++) {
          if (vertexList[i] != null) {
              if (!vertexList[i].visited) {
                  Explore(vertexList[i]);
                  cc++;
                  System.out.println();
              }
          }
      }
  }

    public static HashGraph constructGraph3() {
        int p = 101111; // Big Prime (Hash key1)
        int x = 101;    // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x); 
        String[] cities = new String[]{"Dublin", "Edinburgh", "Manchester", 
            "Copenhagen", "Lisbon", "London", "Berlin", "Prague", "Madrid", 
            "Paris", "Vienna", "Budapest", "Geneva", "Milan", "Zurich", "Rome"};
        for (int i=0; i<16; i++){
            graph.addVertex(cities[i]);
        }
                
        graph.addEdge("Dublin", "Edinburgh");
        graph.addEdge("Dublin", "London");                
        graph.addEdge("Dublin", "Lisbon");
        graph.addEdge("Edinburgh", "Manchester");
        graph.addEdge("Manchester", "London");
        graph.addEdge("Manchester", "Copenhagen");
        graph.addEdge("Copenhagen", "Berlin");
        graph.addEdge("Lisbon", "Madrid");
        graph.addEdge("London", "Paris");
        graph.addEdge("Berlin", "Prague");
        graph.addEdge("Berlin", "Vienna");
        graph.addEdge("Berlin", "Paris");
        graph.addEdge("Prague", "Zurich");
        graph.addEdge("Madrid", "Paris");
        graph.addEdge("Madrid", "Milan");
        graph.addEdge("Madrid", "Geneva");
        graph.addEdge("Vienna", "Zurich");
        graph.addEdge("Budapest", "Rome");
        graph.addEdge("Milan", "Zurich");
        graph.addEdge("Zurich", "Rome");

        return graph;
    }

    public static HashGraph constructGraph4() {
        int p = 101111; // Big Prime (Hash key1)
        int x = 101;    // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x); 
        String[] cities = new String[]{"Liu Bei", "Liu Shi", "Liu Shan", 
            "Liu Liang", "Sun Jian", "Sun Ce", "Sun Quan", "Sun Liang", "Sun Xiu", 
            "Sun Hao", "Cao Cao", "Cao Pi", "Cao Rui", "Cao Fang", "Cao Mao", "Cao Huan"};
        for (int i=0; i<16; i++){
            graph.addVertex(cities[i]);
        }
        
        graph.addEdge("Liu Bei", "Liu Shi");
        graph.addEdge("Liu Bei", "Liu Shan");
        graph.addEdge("Liu Liang", "Liu Shan");
        graph.addEdge("Sun Jian", "Sun Ce");
        graph.addEdge("Sun Jian", "Sun Quan");
        graph.addEdge("Sun Quan", "Sun Ce");
        graph.addEdge("Sun Quan", "Sun Liang");
        graph.addEdge("Sun Liang", "Sun Xiu");
        graph.addEdge("Sun Xiu", "Sun Hao");
        graph.addEdge("Cao Cao", "Cao Pi");
        graph.addEdge("Cao Cao", "Cao Rui");
        graph.addEdge("Cao Cao", "Cao Fang");
        graph.addEdge("Cao Pi", "Cao Rui");
        graph.addEdge("Cao Rui", "Cao Fang");
        graph.addEdge("Cao Pi", "Cao Fang");
        graph.addEdge("Cao Fang", "Cao Mao");
        graph.addEdge("Cao Fang", "Cao Huan");
        graph.addEdge("Cao Mao", "Cao Huan");

        return graph;
    }
}
