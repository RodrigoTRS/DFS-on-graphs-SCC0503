package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public abstract class TraversalStrategyInterface
{
    private static final Logger LOGGER = Logger.getLogger("TravestalStrategyInterface.class");
    private AbstractGraph graph;
    private boolean[] visitedVertices;
    private float[] distanceToVertices;
    private int[] predecessorVertexIndices;
    private int[] successorVertexIndices;
    private List<Vertex> traversalPath;


    public void markVertexAsVisited(int vertexIndex)
    {
        visitedVertices[vertexIndex] = true;
    }

    public boolean hasVertexBeenVisited(int vertexIndex)
    {
        return visitedVertices[vertexIndex];
    }

    protected TraversalStrategyInterface(AbstractGraph graph)
    {
        this.graph = graph;
        visitedVertices = new boolean[graph.getNumberOfVertices()];
        Arrays.fill(visitedVertices, false);
        distanceToVertices = new float[graph.getNumberOfVertices()];
        Arrays.fill(distanceToVertices, Float.POSITIVE_INFINITY);
        predecessorVertexIndices = new int[graph.getNumberOfVertices()];
        Arrays.fill(predecessorVertexIndices, -1);
        successorVertexIndices = new int[graph.getNumberOfVertices()];
        Arrays.fill(successorVertexIndices, -1);
        traversalPath = new LinkedList<>();
    }

    public abstract void traverseGraph(Vertex source);

    public AbstractGraph getGraph()
    {
        return graph;
    }

    protected void printPath()
    {
        var visitedPath = new StringBuilder();
        for (Vertex vertex : traversalPath)
        {
            visitedPath.append(vertex);
        }
        var traversalPathString = visitedPath.toString();
        System.out.println(traversalPathString);
    }

    public void addToPath(Vertex vertex)
    {
        traversalPath.add(vertex);
    }

    public void printVisitTree()
    {
        var treeStringBuilder = new StringBuilder();

        treeStringBuilder.append('\n');

        for (var i = 0; i < getGraph().getNumberOfVertices(); i++)
        {
            treeStringBuilder.append(getGraph().getVertices().get(i).getName());
            treeStringBuilder.append("\n");
        }
        var treeString = treeStringBuilder.toString();
        LOGGER.info(treeString);
    }
}
