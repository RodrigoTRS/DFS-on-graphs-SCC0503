package graph;

import java.util.List;

public class DigraphMatrix extends AbstractGraph
{
    private Edge[][] adjacencyMatrix;

    public DigraphMatrix(List<Vertex> vertices)
    {
        super(vertices);
        initializeAdjacencyMatrix();
    }

    public DigraphMatrix()
    {
        super();
    }

    @Override
    public void addVertex(Vertex vertex)
    {
        super.addVertex(vertex);
        expandAdjacencyMatrix();
    }

    private void initializeAdjacencyMatrix()
    {
        setAdjacencyMatrix(new Edge[getNumberOfVertices()][getNumberOfVertices()]);
        for (var i = 0; i < getNumberOfVertices(); i++)
        {
            for (var j = 0; j < getNumberOfVertices(); j++)
            {
                getAdjacencyMatrix()[i][j] = null;
            }
        }
    }

    private void expandAdjacencyMatrix()
    {
        var newAdjacencyMatrix = new Edge[getNumberOfVertices()][getNumberOfVertices()];
        System.arraycopy(adjacencyMatrix, 0, newAdjacencyMatrix, 0, getNumberOfVertices()-1);
        for (var i = 0; i < (getNumberOfVertices()-1); i++)
        {
            System.arraycopy(adjacencyMatrix[i], 0, newAdjacencyMatrix[i], 0, getNumberOfVertices()-1);
            newAdjacencyMatrix[i][getNumberOfVertices()-1] = null;
            newAdjacencyMatrix[getNumberOfVertices()-1][i] = null;
        }
        newAdjacencyMatrix[getNumberOfVertices()-1][getNumberOfVertices()-1] = null;
    }

    @Override
    public void addEdge(Vertex source, Vertex destination)
    {
        if(!edgeExists(source, destination))
        {
            getAdjacencyMatrix()[getVertices().indexOf(source)][getVertices().indexOf(destination)] = new Edge();
        }
    }

    @Override
    public void removeEdge(Vertex source, Vertex destination)
    {
        int sourceIndex = getVertices().indexOf(source);
        int destinationIndex = getVertices().indexOf(destination);
        if(edgeExists(source, destination))
        {
            getAdjacencyMatrix()[sourceIndex][destinationIndex] = null;
        }
    }

    @Override
    public boolean edgeExists(Vertex source, Vertex destination)
    {
        int sourceIndex = getVertices().indexOf(source);
        int destinationIndex = getVertices().indexOf(destination);
        return getAdjacencyMatrix()[sourceIndex][destinationIndex] != null;
    }

    @Override
    public boolean hasAnyEdge(Vertex vertex)
    {
        int vertexIndex = getVertices().indexOf(vertex);
        for (var i = 0; i < getNumberOfVertices(); i++)
        {
            if(getAdjacencyMatrix()[vertexIndex][i] != null)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vertex getFirstConnectedVertex(Vertex vertex)
    {
        if(!hasAnyEdge(vertex))
        {
            return null;
        }
        else
        {
            var currentVertexIndex = 0;
            Vertex connected;
            do
            {
                connected = getVertices().get(currentVertexIndex++);
            }while(!edgeExists(vertex, connected));
            return connected;
        }
    }

    @Override
    public Vertex getNextConnectedVertex(Vertex source, Vertex currentConnection)
    {
        Vertex newConnection;
        for (int i = getVertices().indexOf(currentConnection)+1; i < getNumberOfVertices(); i++)
        {
            newConnection = getVertices().get(i);
            if(edgeExists(source, newConnection))
            {
                return newConnection;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        var s = new StringBuilder();
        for (var i = 0; i < getNumberOfVertices(); i++)
        {
            s.append(i).append(": ");
            for (var j = 0; j < getNumberOfVertices(); ++j)
            {
                if(edgeExists(getVertices().get(i), getVertices().get(j)))
                {
                    s.append("");
                }
                else
                {
                    s.append(0.0 + " ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public Edge[][] getAdjacencyMatrix()
    {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(Edge[][] adjacencyMatrix)
    {
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
