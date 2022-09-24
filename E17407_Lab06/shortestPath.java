
//  E number : E/17/407 ..............................


import java.util.*;

public class shortestPath{

    //declare member variables
    private int distance[];
    private Set<Integer> settled;
    private PriorityQueue <Node> pq;
    private int vertices;
    List <List<Node>> adj;

    //constructor of this class
    public shortestPath(int vertices){

        //initialize member variables
        this.vertices=vertices;
        distance=new int [vertices];
        settled=new HashSet<Integer>();
        pq=new PriorityQueue<Node>(vertices ,new Node());

    }

    // method to implement the dijkstra's algorithm
    public void dijkstraAlgo(List<List<Node>> adj ,int src){

        this.adj=adj;  //initialize the adjecency list

        for(int element=0; element < vertices ; element++){
            //loop through every node and assign destance as a very larage number
            
            distance[element]=Integer.MAX_VALUE;

        }

        //add source vertex to the priority queue
        pq.add(new Node(src,0));
        //assign 0 to the distance of the source vertex
        distance[src]=0;

        //runs untill the all vertices are visited from the source vertex
        while (settled.size() != vertices){

            //if prority queue is empty then return
            if(pq.isEmpty()){
                return;
            }

            //remove the minimum distance node from the priority queue
            int u=pq.remove().node;

            
            if(settled.contains(u)){
                continue;
            }

            //adding the node whose distance is finalized
            settled.add(u);

            //we don't have to call the function Neighbours 
            // if u is already in the settled set
            Neighbours(u);
        }



    }

    // a method to process the all neighbours of the passed nodes
    private void Neighbours(int u){
        //initialize some variables
        int edgeDistance,newDistance=-1;

        //a loop to get the all the neighbours of the 
        // current vertex V
        for(int index=0 ; index<adj.get(u).size() ; index++){

            Node v= adj.get(u).get(index);

            // if the current node is not settled
            if(!settled.contains(v.node)){
                edgeDistance=v.cost; //get the distance 
                newDistance=distance[u]+edgeDistance; //get the new distance from the source vertex to v

                if(newDistance < distance[v.node]){
                    //if the new distance is cheaper in cost, update the distance
                    distance[v.node]=newDistance;


                }
                //add the current vertex to the priorityqueue
                pq.add(new Node(v.node , distance[v.node]));


            }


        }

    }

     public static void main(String[] args) {

        int vertices=12;  // initialize the number of vertices
        //initialize the source vertices
        int source0=0;
        int source1=1;
        
        //create an adjecency list
        List<List<Node>> adj= new ArrayList<List<Node>>();

        //initialize the adjecency list
        for(int i=0;i<vertices;i++){
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // initialze the graph
        adj.get(0).add(new Node(8,5));
        adj.get(0).add(new Node(2,1));

        adj.get(1).add(new Node(3,6));

        adj.get(2).add(new Node(11,2));
        adj.get(2).add(new Node(10,7));
        adj.get(2).add(new Node(3,11));
        adj.get(2).add(new Node(5,10));

        adj.get(3).add(new Node(4,9));
        adj.get(3).add(new Node(9,4));
        
        adj.get(4).add(new Node(1,10));
        adj.get(4).add(new Node(7,1));
        adj.get(4).add(new Node(5,4));

        adj.get(5).add(new Node(7,7));
        adj.get(5).add(new Node(0,3));
        

        adj.get(6).add(new Node(4,2));

        adj.get(7).add(new Node(6,12));

        adj.get(8).add(new Node(7,7));

        adj.get(9).add(new Node(1,12));

        adj.get(10).add(new Node(3,5));

        //Dijsktra's algorithem for vertex S0
        shortestPath dsp0 =new shortestPath(vertices);
        dsp0.dijkstraAlgo(adj, source0);

        //Dijsktra's algorithem for vertex S1
        shortestPath dsp1 =new shortestPath(vertices);
        dsp1.dijkstraAlgo(adj, source1);

        Boolean src0=true; // a control variable

        // loop to run Dijsktra's algorithem for vertex S1 ans S0
        for(int counter=0;counter<2;counter++){

            System.out.println("the shortest path from node");
            
            for(int counter1=0 ; counter1< vertices;counter1++){
                
                if(src0){
                    // if the source vertex is S0
                    System.out.println(source0 + " to " + counter1 + " is " + dsp0.distance[counter1]);

                    if(counter1==vertices-1){
                        src0=false;
                    }

                }else{

                    //if source vertex is S1
                    System.out.println(source1 + " to " + counter1 + " is " + dsp1.distance[counter1]);

                    

                }
            
            }

        }

        
        System.out.println("Suppliers for the nodes :");
        
        //loop through the all vertices of the graph
        for(int index=0 ; index<vertices ; index++){ 

            if(dsp0.distance[index] < dsp1.distance[index]){

                //if the distance to the current vertex from S0 is less than the distance from S1

                System.out.println("S0 is the supplier for node D" +index+". cost = " +dsp0.distance[index]);

            }else if (dsp0.distance[index] > dsp1.distance[index]){
                 //if the distance to the current vertex from S1 is less than the distance from S0
                System.out.println("S1 is the supplier for node D" +index+". cost = " +dsp1.distance[index]);

            }else{
                //current vertex has the same distance from S0 and S1
                System.out.println("Both S0 and S1 can be used as the supplier for node D" 
                +index +". cost = " +dsp0.distance[index]);

                


            }



        }

        

        
    }





}