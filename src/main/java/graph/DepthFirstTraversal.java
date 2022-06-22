package graph;

public class DepthFirstTraversal extends TraversalStrategyInterface
{
    // Definição da propriedade que salvará todo os vértices
    // para posteriormente fazer a impressão
    StringBuilder traversedPath;

    // Instancia o StringBuilder, além de receber o grafo
    // e "enviá-lo para cima" através do supper, para que
    // o grafo receba a operação da busca em produndiade
    public DepthFirstTraversal(AbstractGraph g)
    {
        super(g);
        traversedPath = new StringBuilder();
    }

    @Override
    // Recebe o vértice inicial da busca, chama a chamada recursiva
    // de busca em produndidade e imprime o caminho realizado
    public void traverseGraph(Vertex source)
    {
        depthFirstTraversalRecursion(source);
        printPath();
    }

    private void depthFirstTraversalRecursion(Vertex source)
    {
        // Marca o vértice recebido por parâmetro como visitado
        markVertexAsVisited(getGraph().getVertices().indexOf(source));

        // Adiciona uma mudança de linha ao StringBuilder
        traversedPath.append(source).append('\n');

        // Adiciona ao caminho o vértice visitado
        addToPath(source);

        // Tentar pegar o primero vértice conectado, caso ele exista, atribui
        // a variável adjacentVertex um valor diferente de null
        var adjacentVertex = getGraph().getFirstConnectedVertex(source);

        while(adjacentVertex != null)
        {
            // Seleciona o indice do próximo vértice adjacente
            int adjacentVertexIndex = getGraph().getVertices().indexOf(adjacentVertex);

            // Caso o próximo vértice ainda não tenha sido visitado, chama a recursão
            if(!hasVertexBeenVisited(adjacentVertexIndex)) {
                depthFirstTraversalRecursion(adjacentVertex);
            }

            // Caso o próximo vértice já tenha sido visitado, visita um vértice vizinho
            adjacentVertex = getGraph().getNextConnectedVertex(source, adjacentVertex);
        }
    }
}
