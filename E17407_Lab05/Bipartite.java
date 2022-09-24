
//...........   E number : E/17/407  .................................

import java.util.*;
//import java.lang.*;
//import java.io.*;

class Bipartite{

    
    final static int vertices=5;  //number of vertices

    // define a class to represent the constant variables (colours used to colour the vertices)
    enum Color{

        WHITE, RED, BLACK
    }


    //create an empty array to store the colours assigned to all vertices
    public static Color []coloursArray = new Color[vertices];
    
    
   //return true if the given graph  is bipartite
   //used BFS  (Breadth First Search) graph travesal method
    boolean isBipartite (int graph[][],int source){
        

        // vertex number = index of the elements in the array
        // colourArray[index] = WHITE ; (no colour is assigned to vertex 'index')
        // used two colours to check whether the graph is bipartite or not (used RED and BLACK)


        for(int index=0 ; index < vertices ; index++){ //loop through the array 'coloursArray'

            coloursArray[index]=Color.WHITE; // at the begining ,assign WHITE colour to all the vertices

        }

        coloursArray[source]=Color.RED; //assign RED colour to the source vertex

        
        //create a queue of vertex numbers using linked list - (queue - FIFO data structure)
        // then enqueue source vertex for BFS traversal
        LinkedList <Integer> queue = new LinkedList <Integer> ();

        queue.add(source); // add source vetrex to the queue


        // run if the queue is not empty
        while(queue.size() != 0){

            //dequeue a vertex from the queue
            int source_vetrex = queue.poll();

            // checking for self loops
            if(graph[source_vetrex][source_vetrex] == 1){  //garph[v][v]=1 -> self -loop
  
                // if there is a self-loop , then it is not a bipartite graph
                return false;  
            }

            // a loop to find non-coloured adjacent vertices
            for(int destination_vertex=0 ; destination_vertex < vertices ; destination_vertex++){


                // an edge exists from source_vertex to destination_vertex and the destination_vertex is not coloured
                if( graph[source_vetrex][destination_vertex] == 1 && coloursArray[destination_vertex] == Color.WHITE){
                    
                    if(coloursArray[source_vetrex] == Color.RED) {
                    
                     //if the source vertex is red , then assign black to the destination vertex
                       coloursArray[destination_vertex]=Color.BLACK;

                    }else if (coloursArray[source_vetrex] == Color.BLACK) {

                     // if the source vertex is black , then assign red to the destination vertex
                       coloursArray[destination_vertex]=Color.RED;
                    
                    }
                    
                    
                    queue.add(destination_vertex); // add destination_vertex to queue


                }else if (graph[source_vetrex][destination_vertex] == 1 && (coloursArray[source_vetrex] == coloursArray[destination_vertex])){

                    // an edge from source_vertex to destination_vertex exists 
                    // and those vertices are coloured in same colour,then return false
                    //(not a bipartite graph)
                    return false;


                }


            }
        }

        // all adjacent vertices can be coloured with an alternate colour
        // bipartite graph - (return true)
        return true;

    }



    // a method to print the colours of the vertices
    void printVertexColours(){

        System.out.print("Colours of the vertices : ");

        //loop throgh the array 'coloursArray'
        for(int index=0; index<vertices ;index++){

            System.out.print(coloursArray[index]);

            if(index != vertices-1){

                System.out.print(',');

            }
        }

        System.out.println( );
    }



    //main method to test the code
    public static void main (String [] args){
        

        // adjacency matrix representaion of the graph 
        int graph1[][] = { {0,1,0,1},
                          {1,0,1,0},
                          {0,1,0,1},
                          {1,0,1,0},  };

        int graph2[][] = {{ 0, 1, 0, 1,0 },
                          { 1, 0, 1, 1 ,0},
                          { 0, 1, 0,0, 1 },
                          { 1, 1, 0, 0,1 },
                          { 0, 0, 1, 1,0 }};
                          
          


        //create a new object from the class 'Bipartite'
        Bipartite bg = new Bipartite();  
        Bipartite bg2 = new Bipartite(); 

        
    //    if( bg.isBipartite(graph1, 0)){

        /*    //print the colours of the vertices
            bg.printVertexColours();

            */

            // if the graph is a bipartite garph , then print Yes
    //       System.out.println("A bipartite graph : graph1");
          
    //    }else{

            // if the graph is not  a bipartite garph , then print No
    //        System.out.println("Not a bipartite graph : graph1");

    //    }



        if( bg2.isBipartite(graph2, 0)){

            /*    //print the colours of the vertices
                bg.printVertexColours();
    
                */
    
                // if the graph is a bipartite garph , then print Yes
                System.out.println("A bipartite graph : graph2");
              
        }else{
    
                // if the graph is not  a bipartite garph , then print No
                System.out.println("Not a bipartite graph : graph2");
    
       }




    }

}