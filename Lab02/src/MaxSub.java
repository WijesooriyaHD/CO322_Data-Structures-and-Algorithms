import java.util.Random;


/*            E/17/407             */


class MaxSub { 

    static int MAX_NUM = 200; 
    

    static int [] generate(int howmany) { 
	int [] data = new int[howmany]; 
	Random randomGenerator = new Random();
	for(int i=0; i<howmany; i++) 
	    data[i] = randomGenerator.nextInt(MAX_NUM) - (MAX_NUM/2); 
	return data; 
    }

    static void show(int []data, int s, int e) { 
	for(int i=s; i<e; i++) 
	    System.out.print(data[i] + " "); 
	System.out.println(); 
    }	


    static int findMaxSub(int [] data) { 
	// find the MaxSub array sum and return 
    	
    
    				// Brute-force method 
    	
    	int size = data.length; //get the size of the given array
    	int maximumSubArraySum = Integer.MIN_VALUE; //get the minimum possible value for integers in java
    	 
    	for (int left = 0; left< size; left++) { //loop through the array
    		int currentSum = 0; //assign 0 to variable sum
    		
    		for (int right = left; right< size; right++) { //loop through the array from left to right
    			currentSum =currentSum+ data[right];  //add elements in the array data to current sum
    			
    			if (currentSum> maximumSubArraySum) { //check whether the current sum is grater than to maximum sub array sum
    				maximumSubArraySum = currentSum; //assign current sum to maximum sub array sum
    	        }
    	    }
    	}
    	    
    	return maximumSubArraySum; // return the maximum sub array sum 
    	
    	//time complexity of the above method : O(n^2)
    	
    	
    
    /*
    	
    	
    	//method 2 - time complexity:O(n)
    	
    	int size=data.length; //get the size of the input array
    	int []values=new int[size]; //create an array to store some values
    	
    	int maxSum=data[0]; //assign data[0] to variable maxsum
    	values[0]=data[0]; //assign data[0] to variable values[0]
    	
    	for(int index=1;index<size;index++) { //loop through the given array
    		
    		values[index]=Math.max(data[index], data[index]+values[index-1]); //append values to the array 'values'
    		maxSum=Math.max(maxSum,values[index]); //get the maximum sum
    		
    	}
    	
    	return maxSum; //return the maximum sub array sum         */
    	
	
    }



	
	

    public static void main(String [] args) { 
	// try it with a known array first
	// then use a random array and see it works 
 
	
	int [] data = {1, 12, -129, 192, 2, 10, -19, 25, -200, 91, 10};
	findMaxSub(data);
	System.out.println("Max sum = " + findMaxSub(data)); 


	data = generate(100); 
	System.out.println("Max sum = " + findMaxSub(data)); 

	
    }
}