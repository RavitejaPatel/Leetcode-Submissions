class Solution {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] bucket = new ArrayList[numCourses];
        Boolean[] isVisited = new Boolean[numCourses];
        Boolean[] recursionStack = new Boolean[numCourses];
        List<Integer> result = new ArrayList<>();
        
        // Initialize adjacency list (bucket)
        for (int i = 0; i < numCourses; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Initialize visited and recursionStack arrays
        Arrays.fill(isVisited, false);
        Arrays.fill(recursionStack, false);

        // Build the adjacency list
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            bucket[prereq].add(course);
        }

        // Run DFS for each course to detect cycles and topological sort
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                if (!dfs(bucket, i, recursionStack, isVisited, result)) {
                    return new int[0]; // If a cycle is detected, return an empty array
                }
            }
        }

        // Reverse the result list to get the correct topological order
        Collections.reverse(result);

        // Convert the result list to an array and return
        int[] arrayRes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrayRes[i] = result.get(i);
        }
        
        return arrayRes;
    }
    
    private Boolean dfs(List<Integer>[] bucket, int currNode, Boolean[] recursionStack, Boolean[] isVisited, List<Integer> result) {
        // If the node is in the recursion stack, we've detected a cycle
        if (recursionStack[currNode]) {
            return false;
        }

        // If the node is already visited, no need to process it again
        if (isVisited[currNode]) {
            return true;
        }

        // Mark the node as visited and add it to the recursion stack
        isVisited[currNode] = true;
        recursionStack[currNode] = true;

        // Explore all neighbors (dependent courses)
        List<Integer> adjList = bucket[currNode];
        for (int node : adjList) {
            if (!dfs(bucket, node, recursionStack, isVisited, result)) {
                return false; // Cycle detected
            }
        }

        // Remove the current node from the recursion stack after visiting all neighbors
        recursionStack[currNode] = false;

        // Add the current course to the result list (after processing its neighbors)
        result.add(currNode);

        return true;
    }
}