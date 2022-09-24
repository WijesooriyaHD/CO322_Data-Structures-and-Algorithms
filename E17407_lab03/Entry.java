
//............ E/17/407 ..................

public class Entry{   //creating the class entry 

    //define some attributes
    private int key;
    private String value;

    //define the constructor
    public Entry(int key,String value){
        this.key=key;
        this.value=value;
    }

    //function to get the key of an entry
    public int getKey(){
        return key;
    }

    //function to get the value of an entry
    public String getValue(){
        return value;
    }

}