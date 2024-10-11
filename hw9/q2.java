public class HashTable {
    String[] arr;
    int size;
    int capacity;
    
    // Hashing parameters
    int p; // Big Prime (for PolyHash())
    int x; // Small number (for PolyHash())
    
    public HashTable(int cap, int p, int x){ 
        // create an string array with cap size 
        arr = new String[cap];
        this.capacity = cap; //set capacity of this class to be cap value
        this.p = p; //set p of this class to be p value
        this.x = x; //set x of this class to be x value
    }
    
    public void addString(String s){
        // Insert the string at that index that no one occupy
        // You should call getIndex()
        int index = getIndex(s); //initialize index value by index value of getIndex function
        arr[index] = s; //change value of array index index to s value 
    }
    
    // This function has 2 roles
    // [1] Find an empty space to push the string object
    // [2] Find location of the string
    // The algorithm is followed
    // 1. Hash the string and get the index
    // 2. If the arr[index] is empty, then return index
    // 3. If the arr[index] equals the string, then also return index
    // 4. Perform the quadratic probing and repeat 2.-3. until found the location
    public int getIndex(String s){
        int index = polyHash(s, p, x); //initialize index value as hash value from polyHash function 
        
        for (int i = 0; i < capacity; i++) { //create a loop that change index value 
            index = (index + i) % capacity; //change indeex value to be (index plus i ) mod capacity 
            if (arr[index] == null || arr[index] == s) return index; //if index of array is null or is same as string s return index
        }
        return 0; // Fix this
    }
    
    // Check the slide for the pseudocode
    // If you want to access a char of string s at index i, use s.charAt(i)
    // If you want to get the ASCII code of char c, use (int)c
    public static int polyHash(String s, int p, int x){ //function that hash string 
        int hash = 0; //initialize hash value to be 0 
        // Do something
        for (int i = s.length()-1; i >= 0; i--) { //create loop that change hash value until i equal s length - 1
            hash = (hash * x + (int) s.charAt(i)) % p; //change hash value to be as the hash formula 
        }
        return hash; 
    }
    
    // This is editable testcase, no need to edit
    public static void test1(){
        int p = 1100101;    // Big Prime    (Hash key1)
        int x = 1001;       // Small number (Hash key2)
        HashTable table = new HashTable(16, p, x);  
        String[] names = {"a", "b", "c", "A", "B", "BA", "BBA", "aaa", "aaaaa", "0","1","11","111", "abcdABCD01234" }; 
        for (int i=0; i<names.length; i++)
            System.out.println("HashCode of '" + names[i] + "' is "+HashTable.polyHash(names[i], p, x));
    }
    
    // This is editable testcase, no need to edit
    public static void test2(){
        int p = 1100101;    // Big Prime    (Hash key1)
        int x = 1001;       // Small number (Hash key2)
        HashTable table = new HashTable(16, p, x); 
        String[] names = {"a", "b", "c", "A", "B", "BA", "BBA", "aaa", "aaaaa", "0","1","11","111", "abcdABCD01234" };

        for (int i=0; i<names.length; i++){
            table.addString(names[i]);
            System.out.println("Index of '" + names[i] + "' is "+table.getIndex(names[i]));
        }
    }
    
    public static void test3(){
        int p = 1100101;   // Big Prime    (Hash key1)
        int x = 101;       // Small number (Hash key2)
        HashTable table = new HashTable(16, p, x);
        String[] names = { "Abraham","Andrew","Benjamin","Claudia","Gabriel","Esther","Martha","Rebecca","Moses","Timothy"};
        for (int i=0; i<names.length; i++)
            System.out.println("HashCode of " + names[i] + " is "+HashTable.polyHash(names[i], p, x));
        
        for (int i=0; i<names.length; i++){
            table.addString(names[i]);
            System.out.println("Index of " + names[i] + " is "+table.getIndex(names[i]));
        }
    }
}
