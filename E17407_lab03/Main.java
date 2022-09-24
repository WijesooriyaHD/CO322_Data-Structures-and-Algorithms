
// ........  E/17/407 ................

public class Main {

    public static void main(String [] args){

        // ...............   Task 1 : Hash Table using double-hashing .......................//
       
        System.out.println("Tak1: Double hashing - hash table");

        HashTable hashtable=new HashTable(13); //creating a new hash table, capacity=13

        hashtable.insert(0, "value 0");  //insert some entries to hash table
        hashtable.insert(4, "value 4"); 
        hashtable.insert(8, "value 8");
        hashtable.insert(10, "value 10"); 
        hashtable.insert(17, "value 17"); 
        hashtable.insert(21, "value 21");


        hashtable.remove(10); //remove 10 from the hash table

        hashtable.printList(); //print the hash table

        System.out.println(" "); //print a new line




        //.................. Task 2 : Hash Table using separate chaining ........................//

        System.out.println("Task2: Hash table that uses separate chaining");

        LinkedHashTable linkedHashTable=new LinkedHashTable(13); //number of slots = 13

        linkedHashTable.insert(1,"value 1"); //insert some values
        linkedHashTable.insert(2,"value 2");
        linkedHashTable.insert(3,"value 3");
        linkedHashTable.insert(5,"value 5");
        linkedHashTable.insert(10,"value 10");
        linkedHashTable.insert(14,"value 14");
        linkedHashTable.insert(28,"value 28");
        linkedHashTable.insert(96,"value 96");
        linkedHashTable.insert(559,"value 559");

        
        linkedHashTable.remove(5); //remove value 5
        
        linkedHashTable.printList(); //print the hash table



    }

    
}
