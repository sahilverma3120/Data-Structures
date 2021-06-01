/*1. You are given a graph.
2. You are required to find and print all connected components of the graph.*/
//https://www.pepcoding.com/resources/online-java-foundation/graphs/gcc-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[vtces];  
      for(int v = 0; v< vtces; v++){
          if(visited[v] == false){
              ArrayList<Integer> comp = new ArrayList<>();
              drawTreeAndGenerator(graph,v,comp,visited);
              comps.add(comp);
          }
      }
     
      System.out.println(comps);
   }

public static void drawTreeAndGenerator(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
visited[src] = true;
comp.add(src);
for(Edge e: graph[src]){
if(visited[e.nbr] == false){
    drawTreeAndGenerator(graph,e.nbr,comp,visited);
}

}
}
}
