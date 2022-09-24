
//............  E number : E/17/407


import java.util.ArrayList;
import java.util.Arrays;


public class TC_DFS {

    private int vertices; //number of vertices in the graph

    
    private int [][] transitive_closure; // an array to store transitive closure of the graph

    private ArrayList<Integer> [] adjacencyList; // array list to store adjacency list

    @SuppressWarnings("unchecked")
    // a method to initialize the adjacency list
    private void initAdjList(){

        // create a new object from the arraylist
        adjacencyList=new ArrayList[vertices]; 

        // loop through the number of vertices
        for(int index=0 ; index < vertices ; index++){

            adjacencyList[index]=new ArrayList<>(); // create an empty array list to store the connected vertices

        }

    }



    // constructor of the class
    public TC_DFS(int vertices){

        this.vertices=vertices; //initialize the number of vertices
        this.transitive_closure=new int [this.vertices][this.vertices]; // initialze an array

        initAdjList(); //initialize the adjacency list
    }



    // a method to add an edge from source_vertex to destination_vertex
    public void addEdge(int source_vertex,int destination_vertex){

        // add destination_vertex to source_vertex's list 
        adjacencyList[source_vertex].add(destination_vertex);
    }



    // a recursive DFS travesal method
    //finds all reachable vertices for vertex 'source_vertex'
    public void DFS(int source_vertex , int destination_vertex){


        //mark reachability from  source to destination vertex as true

        if(source_vertex == destination_vertex){  // check whether the source and destination vertices are same or not

            //checking for the self- loops in the graph
            if(adjacencyList[destination_vertex].contains(destination_vertex)){

                // assign 1 to the array 'tc' , if there is a self-loop
                transitive_closure[source_vertex][destination_vertex]=1;

            }else{

                // if there is not a self-loop , assign 0 to the array tc
                transitive_closure[source_vertex][destination_vertex]=0;

            }


        }else{

            // assign 1 to the array tc , if source and destination vertices are not same
            transitive_closure[source_vertex][destination_vertex]=1;
        }


        // a loop to find the all reachable vertices through destination_vertex
        for(int adjacency_vertex : adjacencyList[destination_vertex]){

            if( transitive_closure[source_vertex][adjacency_vertex] == 0){

                DFS(source_vertex , adjacency_vertex);

            }
        }



    }

    //  a method to find the transitive closure of the graph
    public void transitiveClosure(){

        // loop through the number of vertices in the graph
        for(int index=0 ; index < vertices ; index++){

            //invoke DFS recursively , to find the transitive closures of the graph
            DFS(index , index);
        }

        // a loop to print the transitive closure of the graph
        for(int index=0 ; index < vertices ; index++){

             //print 1 if it satisfies the transitive closure
            System.out.println(Arrays.toString(transitive_closure[index]));
           
        }
    }


    public static void main (String [] args){

        TC_DFS graph = new TC_DFS(4); //create a graph with 4 vertices

        // add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Transitive closure matrix is" );

        //print the transitive closure of the graph
        graph.transitiveClosure();
    
    }

    
}


