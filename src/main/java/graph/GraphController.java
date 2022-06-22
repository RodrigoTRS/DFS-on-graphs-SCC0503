package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;


public final class GraphController
{
    private static final Logger LOGGER = Logger.getLogger("GraphController.class");

    private AbstractGraph g;
    private TraversalStrategyInterface traversalStrategy;
    private final List<Vertex> vertices;

    private GraphController() {
        vertices = createVertexList();
    }

    private static List<Vertex> createVertexList()
    {
        List<Vertex> vertices = new ArrayList<>();
        return vertices;
    }

    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        var graphController = new GraphController();

        System.out.println("Number of vertices: ");
        int numberOfVertices = Integer.parseInt(stdin.nextLine());

        System.out.println("Enter all of the " + numberOfVertices + " vertices: ");
        for(int i = 0 ; i < numberOfVertices ; i++){
            // System.out.println("Quest " + i + ": ");
            String questName = stdin.nextLine();
            // System.out.println("Description " + i + ": ");
            String questDescription = stdin.nextLine();
            graphController.vertices.add(new Quest(questName, questDescription));
        }

        graphController.g = new DigraphMatrix(graphController.vertices);
        graphController.traversalStrategy = new DepthFirstTraversal(graphController.g);

        System.out.println("Number of edges: ");
        int numberOfEdges = Integer.parseInt(stdin.nextLine());

        System.out.println("Enter all of the " + numberOfEdges + " edges: ");
        for(int i = 0 ; i < numberOfEdges ; i++){
            // System.out.println("Source " + i + ": ");
            int source = stdin.nextInt();
            // System.out.println("Destination " + i + ": ");
            int destination = stdin.nextInt();
            graphController.g.addEdge(graphController.g.getVertices().get(source), graphController.g.getVertices().get(destination));
        }

        System.out.println("Initial vertex: ");
        int initialVertex = stdin.nextInt();

        graphController.traversalStrategy.traverseGraph(graphController.g.getVertices().get(initialVertex));
        graphController.traversalStrategy.printVisitTree();
    }
}
