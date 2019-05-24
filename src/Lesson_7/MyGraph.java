package Lesson_7;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyGraph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjLists;

    public MyGraph (int vertexCount){
        if (vertexCount < 0){
            throw new IllegalArgumentException("Number of vertexes can not be negative");
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge (int v1, int v2){
        if (v1 < 0 || v2 < 0 || v1 > vertexCount - 1 || v2 > vertexCount - 1) {
            throw new IllegalArgumentException("Vertex number can not be negative or bigger than vertexCount");
        }
        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
        edgeCount++;
    }

    public LinkedList<Integer> adjList (int v){
        if (v < 0 || v > vertexCount - 1) {
            throw new IllegalArgumentException("Vertex count can not be negative or bigger than vertexCount");
        }
        return adjLists[v];
    }

}
