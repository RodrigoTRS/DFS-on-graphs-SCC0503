package graph;

public class Edge
{
    private Vertex destination;

    public Edge(Vertex destination)
    {
        this.destination = destination;
    }

    public Edge()
    {
        this.destination = null;
    }


    public Vertex getDestination()
    {
        return destination;
    }

    public final void setDestination(Vertex destination)
    {
        this.destination = destination;
    }
}
