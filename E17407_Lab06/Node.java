
// E number : E/17/407  ........................

import java.util.Comparator;

 class Node implements Comparator<Node> {
     //member variables of the class
    public int node;
    public int cost;

    //constructor1
    public Node(){}
    
    //constructor2
    public Node(int node ,int cost){

        this.node=node;
        this.cost=cost;


    }

    //a method to comapare the cost's of two nodes
    @Override
    public int compare(Node node1 ,Node node2){

        if(node1.cost < node2.cost){
            return -1;
        }

        if(node1.cost > node2.cost){
            return 1;
        }

        return 0;
    }

}
