/**
 * Simple sorting algorithms and their performance 
 * Reg: E/17/407
 *
 */
import java.util.Scanner; // import the Scanner class 

public class Sort {

    private static Scanner input1;




	//create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the sorting worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/


    //implementing buble_sort algorithm 
    static void buble_sort(int [] data)  {
    	
    	boolean swaps=false; //variable to check for the availability of swaps
    	
    	for(int position=0;position<data.length && !swaps ;position++) { //loop through the array
    		
    		swaps=true; //assign true to variable swap
    		
    		for(int index=data.length-1;index>position;index--) { //loop through the array
    			
    			if(data[index]<data[index-1]) { //check whether the previous item is larger than the current item or not
    				
    				//swap elements
    				swap(data,index,index-1);
    				swaps=false; //assign false to variable swap
    				
    			}
    		}
    	}
    	
    }
    
    
    //implementing selection sort algorithm
    static void selection_sort(int [] data) {
    	
    	for(int position=0;position<data.length;position++) { //loop through the array
    		
    		int indexOfSmallest=position;  // assign current position as the index of smallest element
    		
    		for(int index=position+1;index<data.length;index++) { //loop though the list 
    			
    			if(data[index]<data[indexOfSmallest]) {  //checking for the  smallest element
    				
    				indexOfSmallest=index; //get the index of the smallest element
    			}
    		}
    		
    		//swap smallest element with the current element
    		swap(data,position,indexOfSmallest);
    		
    	}
    }

    
    //implementing insertion sort algorithm
    static void insertion_sort(int [] data) {
	
    	for(int position=1;position<data.length;position++) {  //loop through the array (unsorted part)
    		
    		for(int index=0;index<=position;index++) { //loop through the array (sorted part)
    			
    			if(data[position]<data[index]) { //checking for smaller elements
    				
    				//swap elements
    				swap(data,position,index);
    			}
    		}
    	}
    	
    }

		       
		
    
     public static void main(String [] args) {
	// create arrays of different size populate with data
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc.
    	
    	
    	 //get array size from the user
    	input1 = new Scanner(System.in);
    	System.out.printf("Enter array size = "); 
    	int size = input1.nextInt();  
    	System.out.println();
    	

    	int [] data_array0,data_array1,data_array2,data_array3,data_array4,data_array5; //arrays to store data
    	long start_time; //variables to store time
    	long end_time;
    	float time;
    
   //........................................BUBBLE SORT.......................................................//
    	
    	    //testing bubble sort for the best case
    	System.out.println("Buble Sort : best case : size ="+size);
    	data_array0=create_best_data(size); //populate array with best data
    	
    	start_time = System.nanoTime(); //get the start time in nano seconds
    	buble_sort(data_array0); //invoke function buble sort
    	end_time = System.nanoTime(); //get the end  time in nano seconds
    	time = (end_time - start_time)/1000F ;  // evaluate time taken to sort the array in micro seconds
    	System.out.println("time taken to sort in micro_seconds  "+ time);
    	
    	System.out.println("sorted ? "+isSorted(data_array0)); //check array is sorted or not
    	System.out.println( );
    	
    	
        //testing bubble sort for the worst case
    	System.out.println("Buble Sort : worst case : size ="+size);
    	data_array1=create_worst_data(size); //populate the array with worst data
    	
    	start_time = System.nanoTime();
    	buble_sort(data_array1); //invoke buble sort function
    	end_time = System.nanoTime();
    	time = (end_time - start_time)/1000F ; // evaluate time taken to sort the array in micro seconds
    	System.out.println("time taken to sort in micro_seconds  "+ time);
    	
    	System.out.println("sorted ? "+isSorted(data_array1));
    	System.out.println( );  
  
    //...................................SELECTION SORT................................................................//
    	
        //testing selection sort for the best case
    	System.out.println("Selection Sort : best case : size ="+size);
    	data_array2=create_best_data(size); //populate array with best data
    	
    	start_time = System.nanoTime();
    	selection_sort(data_array2); //invoke function selection sort
    	end_time = System.nanoTime();
    	time = (end_time - start_time)/1000F ; // evaluate time taken to sort the array in micro seconds
    	System.out.println("time taken to sort in micro_seconds  "+ time);
    	
    	System.out.println("sorted ? "+isSorted(data_array2));
    	System.out.println( );
    	
    	
    	//testing selection sort for the worst case
    	System.out.println("Selection Sort : worst case : size ="+size);
    	data_array3=create_worst_data(size); //populate array with worst data
    	
    	start_time = System.nanoTime();
    	selection_sort(data_array3); //invoke function selection sort
    	end_time = System.nanoTime();
    	time = (end_time - start_time)/1000F ; //evaluate time taken to sort the array in micro seconds
    	System.out.println("time taken to sort in micro_seconds  "+ time);
    	
    	System.out.println("sorted ? "+isSorted(data_array3));
    	System.out.println( );
    	
    //................................................INSERTION SORT...................................................//
    	
    	//testing insertion sort for the best case
    	System.out.println("Insertion Sort : best case : size ="+size);
    	data_array4=create_best_data(size); //populate array with best data
    	
    	start_time = System.nanoTime();
    	insertion_sort(data_array4); //invoke function insertion sort
    	end_time = System.nanoTime();
    	time = (end_time - start_time)/1000F ; // evaluate time taken to sort the array in micro seconds
    	System.out.println("time taken to sort in micro_seconds  "+ time);
    	
    	System.out.println("sorted ? "+isSorted(data_array4));
    	System.out.println( );
    	
    	
    	//testing insertion sort  for the worst case
    	System.out.println("Insertion Sort : worst case : size ="+size);
    	data_array5=create_worst_data(size); //populate array with worst data
    	
    	start_time = System.nanoTime();
    	insertion_sort(data_array5); //invoke function insertion sort
    	end_time = System.nanoTime();
    	time = (end_time - start_time)/1000F ;  // evaluate time taken to sort the array in micro seconds
    	System.out.println("time taken to sort in micro_seconds  "+ time);
    	
    	System.out.println("sorted ? "+isSorted(data_array5));
    	System.out.println( );
    	
    	
    }
}