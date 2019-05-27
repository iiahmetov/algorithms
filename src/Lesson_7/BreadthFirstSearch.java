package Lesson_7;

import java.util.LinkedList;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distanceTo;
    private int source;
    private int inf = Integer.MAX_VALUE;

    public BreadthFirstSearch (MyGraph g, int source){
        if (source < 0){
            throw new IllegalArgumentException();
        }
        if (source > g.getVertexCount() - 1) {
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        distanceTo = new int[g.getVertexCount()];
        for (int i = 0; i < g.getVertexCount(); i++) {
            distanceTo[i] = inf;
        }
        bfs(g, source);
    }

    private void bfs (MyGraph g, int source){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(source);
        marked[source] = true;
        distanceTo[source] = 0;
        while (!queue.isEmpty()) {
            int currentVertex = queue.removeFirst();
            for (int w:
                 g.adjList(currentVertex)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = currentVertex;
                    distanceTo[w] = distanceTo[currentVertex] + 1;
                    queue.addLast(w);
                }
            }
        }
    }

    public int distanceTo(int dist){
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist > marked.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return distanceTo[dist];
    }

    public boolean hasPathTo (int dist) {
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist > marked.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return marked[dist];
    }

    public LinkedList<Integer> pathTo (int dist){
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist > marked.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int currentVertex = dist;
        while (currentVertex != source) {
            stack.push(currentVertex);
            currentVertex = edgeTo[currentVertex];
        }
        return stack;
    }


}
