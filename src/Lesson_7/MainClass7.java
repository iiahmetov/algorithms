package Lesson_7;

public class MainClass7 {
    public static void main(String[] args) {
//        MyGraph graph = new MyGraph(6);
//        graph.addEdge(0, 2);
//        graph.addEdge(0, 1);
//        graph.addEdge(1, 2);
//        graph.addEdge(5, 3);
//        graph.addEdge(4, 1);
//        graph.addEdge(1, 3);
//        System.out.println(graph.getEdgeCount());
//        System.out.println(graph.adjList(1));

//        MyGraph graph = new MyGraph(13);
//        graph.addEdge(0, 6);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(5, 3);
//        graph.addEdge(5, 4);
//        graph.addEdge(5, 0);
//        graph.addEdge(6, 4);
//        graph.addEdge(3, 4);
//
//        graph.addEdge(7, 8);
//
//        graph.addEdge(9, 10);
//        graph.addEdge(9, 12);
//        graph.addEdge(9, 11);
//        graph.addEdge(11, 12);
//
//        DepthFirstPaths dfs = new DepthFirstPaths(graph, 0);
//
//        System.out.println(dfs.hasPathTo(5));
//        System.out.println(dfs.hasPathTo(7));
//        System.out.println(dfs.hasPathTo(12));
//        if (dfs.hasPathTo(5)) {
//            System.out.println(dfs.pathTo(5));
//        }

//        MyGraph graph = new MyGraph(6);
//        graph.addEdge(0, 2);
//        graph.addEdge(0, 1);
//        graph.addEdge(1, 2);
//        graph.addEdge(3, 5);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 2);
//        graph.addEdge(4, 2);
//        graph.addEdge(5, 0);
//
//        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
//
//        System.out.println(bfs.hasPathTo(3));
//        System.out.println(bfs.pathTo(3));
//        System.out.println(bfs.distanceTo(3));

        MyGraph graph = new MyGraph(10);
        graph.addEdge(0, 7);
        graph.addEdge(0, 5);
        graph.addEdge(0, 8);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 9);
        graph.addEdge(2, 7);
        graph.addEdge(3, 6);
        graph.addEdge(4, 3);
        graph.addEdge(4, 8);
        graph.addEdge(5, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 4);
        graph.addEdge(6, 0);
        graph.addEdge(7, 9);
        graph.addEdge(8, 6);
        graph.addEdge(9, 1);
        graph.addEdge(9, 3);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        System.out.println(bfs.hasPathTo(1));
        System.out.println(bfs.pathTo(1));
        System.out.println(bfs.distanceTo(1));

//        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 1);
//        System.out.println(bfs.hasPathTo(8));
//        System.out.println(bfs.pathTo(8));
//        System.out.println(bfs.distanceTo(8));

    }
}
