import java.util.Arrays;

//...........  E/17/407 ................

public class HashTable {

    private Entry [] entryList; //cerating an array of entry objects
    private int capacity; //size of the hash table (N)
    private int currentSize; //current size of the hash table

    //define constructor for this class
    public HashTable(int capacity){
        this.capacity=capacity;  // capacity of the hash table (N)
        this.entryList=new Entry[capacity];  //creating a new entry list
        this.currentSize=0; //assign 0 to the current size

    }

    //function to clear the hash table
    public void clearAll(){
        this.entryList=new Entry[capacity]; //creating a new entry list
        this.currentSize=0; //assign 0 to the current size of the table
    }

    //function to get the current size of the hash table
    public int getCurrentSize(){
        return this.currentSize; //retrun the current size
    }

    //function to check whether the hash table is full or not
    public boolean isFull(){
        return currentSize==capacity; //return 1 if it is full
    }

    //function to check whether the hash table is empty or not
    public boolean isEmpty(){
        return currentSize==0; //return 1 if it is empty
    }

    //check whether a given key is already in the table or not
    public boolean containsKey(int key){
        return get(key)!=null;  //return true if it is already in the table

    }

    //defining the hash function
    private int hash1(int key){
        return key % capacity;   //h(k)=k % N
    }

    //defining the probe function to handle collisions
    private int hash2(int key,int iteration){
        return iteration*(1+ (key % (capacity-1)));  //p(k,i)=i*(1+k(N-1))
    }

    //function to insert a value to the hash table
    public void insert(int key,String value){

        if(currentSize > (capacity-1)){  //check whether the hash table is full or not
            return;  //return from the function if the hash table is full
        }

        //handling duplicate keys
        if(containsKey(key)==true){
            return ; //if the key is already in the table ,return from the inset function

        }

        Entry entryToInsert=new Entry(key,value); //create a new entry
        int h1=hash1(key); //evaluate the hash function 1

        int iteration=1; //assign 1 to the iterartion

        //handling collisions
        while(entryList[h1] != null){  //checking for an empty slot

            h1=(h1+hash2(key,iteration)) % capacity;  // ?????equation
            iteration=iteration+1; //increment the value of iteration by 1
        }

        entryList[h1]=entryToInsert; //insert the value to the hash table
        currentSize=currentSize+1; //increment the current size by 1

    }

    //function to get the entry list
    public Entry[] getEntryList(){
        return this.entryList;

    }


    //function to get a value from an entry
    public String get(int key){

        //try-catch block to handle exceptions
        try{

            int h1=hash1(key); //evaluate the hash function1
            Entry readEntry=entryList[h1]; //get the corresponding entry after hash1

            int iteration=1; //assign 1 to the variable iteration

            //handling collisions
            while(readEntry!=null && (readEntry.getKey()!=key)){

                h1=(h1+hash2(key,iteration)) % capacity;  // evaluating the new hash value
                readEntry=entryList[h1];  //get the entry after performing the probe function
                iteration=iteration+1; //increment iteration by 1

            }

            return entryList[h1].getValue(); //return the value of the corresponding entry

        }catch (NullPointerException e){

            return null; // return null, if the key is not in the hash table  
        }

    }


    //removing an item from the hash table
    public void remove(int key){

        if(!containsKey(key)){ //check whether the key is not in the list or not
            return; //return from the function if it is not in the list
        } 

        //remove the item if it is in the table

        int h1=hash1(key); //perform the hash function 1
        Entry readEntry=entryList[h1]; //get the corresponding entry

        int iteration=1; //assign 1 to the variable iteration

        //handle collisions
        while(readEntry!=null && (readEntry.getKey()!=key)){  

            h1=(h1+hash2(key,iteration)) % capacity;  // evaluating the new hash value
            readEntry=entryList[h1];  //get the corresponding entry after performing prob function
            iteration=iteration+1; //increment the iterration by 1

        }

        entryList[h1]=null; //remove the item by assigning a null value 

    }

    //function to print the content of the hash table
    public void printList(){

        //loop through the array an print the key value pairs
        Arrays.stream(entryList).forEach(entry ->{

            if (entry !=null){
                System.out.println("key :" + entry.getKey() + "  value :" +entry.getValue());
            }

        });
    }
   
}
