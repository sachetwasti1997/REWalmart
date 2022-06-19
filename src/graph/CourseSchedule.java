package graph;

import java.util.*;

public class CourseSchedule {

    Map<Integer, List<Integer>> graph;

    public void adjList(int[][] pre){
        for(int i = 0; i < pre.length; i++){
            if(!graph.containsKey(pre[i][0])){
                graph.put(pre[i][0], new ArrayList<>());
            }
            graph.get(pre[i][0]).add(pre[i][1]);
        }
    }

    public boolean hasCycle(int node, Set<Integer>visited, Set<Integer> isBeingVisited){
        visited.add(node);
        isBeingVisited.add(node);
        if(graph.get(node) != null){
            for(Integer i: graph.get(node)){
                if(!visited.contains(i) ){
                    hasCycle(i, visited, isBeingVisited);
                }
                else if(isBeingVisited.contains(i)){
                    return true;
                }
            }
        }
        isBeingVisited.remove(node);
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>(numCourses);
        adjList(prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> isBeingVisited = new HashSet<>();
        return !hasCycle(prerequisites[0][0], visited, isBeingVisited);
    }

}
