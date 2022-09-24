import java.util.Arrays;
import java.util.LinkedList;

// ............... E/17/407 .........................//

public class LinkedHashTable {

    private  LinkedList<Entry> [] linkedEntryList; //creating a linked list
    private int capacity; //size of the hash table
    private int currentSize; //curent size of thehash table

    public LinkedHashTable(int capacity){ //defining the constructor
        this.capacity=capacity;
        this.currentSize=0;

        linkedEntryList=new LinkedList[capacity];
        for(int index=0;index<capacity;index++){
            linkedEntryList[index]=new LinkedList<Entry>();
        }
    }

    //function to return the hash value
    private int hash(int key){

        return key % capacity;
    }

    //function to insert a value to the hash table
    public void insert(int key,String value){


        Entry entryToInsert=new Entry(key, value);  //create a new entry

        int h=hash(key); //evaluate the hash function

        LinkedList<Entry> column=linkedEntryList[h];  //get the correspondibg column of the hash table

        //handle duplicate entry
        for(Entry entry:column){

            //check whether the entry is already in the table or not
            if(entry.getKey()==key){
                return ; //return from the function if the entry is already in the table
            }

        }

        column.add(entryToInsert);  //add entry to the table 
        currentSize=currentSize+1; //increment the current size by 1

    }

    //fuction to get a value for the given key
    public String get(int key){

        int h=hash(key);  //evaluate the hash value

        LinkedList<Entry> column=linkedEntryList[h]; //get the corresponding column

        //loop through the each entry of the column
        for(Entry entry:column){

            if(entry.getKey()==key){ //find the corresponding key from the table
                return entry.getValue();  //return the value
            }

        }

        return null; //return null if the given key is not in the table
    }

    
    //a function to remove an item 
    public void remove(int key){

        if(get(key)==null){ //return from the function if the key is not in the table
            return;
        }

        int h=hash(key); //evaluating the hash value

        LinkedList<Entry> column=linkedEntryList[h]; //get the corresponding column

        //loop through the each entry of the column
        for(Entry entry:column){

            if(entry.getKey()==key){
                column.remove(entry); //remove the corresponding entry from the table
            }

        }

    }

    //function to check whether the table is empty or not
    public boolean isEmpty(){
        return currentSize==0;
    }

    //function to get the current size of the table
    public int getCurrentSize(){
        return this.currentSize;
    }

    //function to clear all the data in the hash table
    public void clear(){

        this.currentSize=0;  //assign 0 to the current size
        linkedEntryList=new LinkedList[capacity]; //create a new linked list

        for(int index=0;index<capacity;index++){
            linkedEntryList[index]=new LinkedList<Entry>(); //create empty entries
        }

    }

    //function to print the hash table
    public void printList(){

        //loop through the each column of the table
        Arrays.stream(linkedEntryList).forEach(column ->{

            if(column!=null){
                //loop through the each row of the table
                column.forEach(row->{

                    if(row!=null){ //print the each entry of the table
                        System.out.println("key : " + row.getKey() + " value : " + row.getValue());
                    }
                }
                    
                );
            }

        }
        );
    }
  
}
