/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
             
        Map<Integer,List<Integer>> pre=new LinkedHashMap<>();
        for(int[] i: prerequisites){
            List<Integer> l=pre.getOrDefault(i[1],new ArrayList<>());
            l.add(i[0]);
            pre.put(i[1],l);
        }
        
        boolean visited[]=new boolean[numCourses];
        boolean rec[] =new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(isCyclic(i,visited,rec,pre)){
                return new int[0];
            }
        }
        
        Stack<Integer> s=new Stack<>();
        visited=new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
                topologicalSort(i,pre,visited,s);
        }
        
        int i=0;
        int[] result=new int[numCourses];
        while(!s.isEmpty()){
            result[i++]=s.pop();
        }
        
        return result;
    }
    
    public void topologicalSort(int node,Map<Integer,List<Integer>> pre,boolean[] visited, Stack<Integer> s){
        visited[node]=true;
        
        for(int i:pre.getOrDefault(node,new ArrayList<>())){
            if(!visited[i])
                topologicalSort(i,pre,visited,s);
        }
        
        s.push(node);
    }
    
    public boolean isCyclic(int node,boolean[] visited,boolean[] rec,Map<Integer,List<Integer>> pre){
        if(!visited[node]){
            visited[node]=true;
            rec[node]=true;
            
            for(int i:pre.getOrDefault(node,new ArrayList<>())){
                if(!visited[i] && isCyclic(i,visited,rec,pre)){
                    return true;
                }
                else if(rec[i]){
                    return true;
                }
            }
            
        }
        
        rec[node]=false;
        return false;
    }
}
