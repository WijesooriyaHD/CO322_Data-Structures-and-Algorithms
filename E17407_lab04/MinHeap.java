


//....................... E/17/407 .................

public class MinHeap {


    //declare member variables of this class
    private int[] Heap; //create an array to store the elements of the min heap
    private int size;   // number of elements
    private int maxsize; // maximum size (elements) of the array


    // root node of the tree minheap = FRONT
    private static final int FRONT=0; 


    //defining the constructor of the class MinHeap
    public MinHeap(int maxsize){

        this.maxsize=maxsize;
        this.size=0;

        Heap=new int[this.maxsize];
    }


    //a method to return the position of the parenet node of the current position
    private int parent (int position){

        return (position-1)/2;  //return the position of the parent node in the array

    }


    //a method to return the position of the left child of the current node
    private int leftChild(int position){

        return (2*position)+1; //return the position of the left child

    }

    // a method to return thr right child of the current node
    private int rightChild(int position){

        return (2*position)+2;  // return the position of the right child
    }


    // this method returns true if the current node is a leaf 
    private boolean isLeaf(int position){


        // leaf - a node with degree 0 (no subtrees)
        if(position > (size/2)-1 && position <= size-1){ //condition for a node to be a leaf

            return true; //return true if it is a leaf

        }

        return false; //retrun false if it is not a leaf

    }

    // a method to swap two node of the heap
    // is used when inserting or deleting a node
    // fpos,spos - positions of the elements that need to be swaped
    private void swap(int fpos,int spos){

        int tmp; //a temperary variable

        //swap elements
        tmp=Heap[fpos];

        Heap[fpos]=Heap[spos];
        Heap[spos]=tmp;

    }


    //a method to convert the binary tree to a heap data structure
    private void minHeapify(int position){

        //check whether the node is a leaf or not
        if(!isLeaf(position)){

            // if the node is not a leaf the following code part will be executed

            //check whether if  the given node is grater than any of its child
            if(Heap[position]> Heap[leftChild(position)] || Heap[position]>Heap[rightChild(position)]){

                if(Heap[leftChild(position)] < Heap[rightChild(position)]){ //check whether the right child is grater tahn the left child

                    //swap the current node with the left child
                    swap(position,leftChild(position));
                    minHeapify(leftChild(position)); //heapify the left child

                }else{

                    //swap the current node with the right child
                    swap(position,rightChild(position));
                    minHeapify(rightChild(position)); //heapify the right child
                }

            }
        }

    }


// a method to insert a node to minheap data structure
    public void insert(int element){

        //check whether the size is grater than maxsize or not
        // (array is full or not)
        if(size>=maxsize){

            // if array is full ,then return
            return; 
        }

        // add the new element at the next position at the bottom of the heap
        Heap[size]=element;  
        
        int current=size; //assign size to current

        //check the condition for heap data structure
        while(Heap[current] < Heap[parent(current)]){

            // if the new element is less than its parent node, swap elements
            // ( bubble the elements up by swaping it, with its parenet )
            swap(current,parent(current)); //swap elements
            current=parent(current);

        }


        size++; //increment size by 1
    }


    // a method to remove and return the minimum element from the heap
    //only the root can be removed from a heap
    public int remove(){

        int popped=Heap[FRONT]; //get the fisrt element in the array (root of the heap)

        //replace the root from the last value of the last level of the heap   
        Heap[FRONT]=Heap[size-1]; 

        // swap the root node untill it reaches to the correct position
        minHeapify(FRONT);

        size--; //decrement size by 1

        return popped; //return the minimum element
    }



    //a method to print the content of the heap
    public void printAll(){

        // loop through the minheap data structure
        for(int index=0;index<=(size/2)-1;index++){

            if(size==(2*index+2)){ //no right child
            //print the parent node ,left child and right child
                System.out.print("PARENT : " + Heap[index]
                                        
                                    + " LEFT CHILD : " + Heap[2*index+1]);
                                    
            }else{

                System.out.print("PARENT : " + Heap[index]
                                        
                + " LEFT CHILD : " + Heap[2*index+1]
                + " RIGHT CHILD : "+ Heap[2*index+2]);
            }


            System.out.println(); //print a new line
        }



    }


   
    /*
   // a method to sort a data set using heap
    public void sort(){

       int length=size;

       //loop though the array 
        for(int index=0;index<length;index++){
 
            // pop elements in the heap  one by one 
            System.out.print(remove());
            System.out.print(" ");
            
        }
    }

 */
    
    


    public static void main(String [] arg){

        //print a msg
        System.out.println("The Min Heap is ");

        MinHeap minHeap=new MinHeap(15); //create an object and name it as minheap

        //custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        //print all element of the heap
       minHeap.printAll();

        //remove the minimum value from the heap ,and print it
       System.out.println("The Min val is " + minHeap.remove());



       System.out.println("After removing the min value ");
       minHeap.printAll();

    }


    



    
}
