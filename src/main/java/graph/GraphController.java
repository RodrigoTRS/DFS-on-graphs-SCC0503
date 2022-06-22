package graph;

import java.util.ArrayList;
import java.util.List;

public final class GraphController
{
    // As propriedades dessa classe são os elementos fundamentais
    // para a utilização do gráfo, definindo as peças para seleção
    // da estrutura de dados do gráfo, da estratégia de travessia, e
    // também a lista de vértices que é utilizada para instânciar a
    // estrutura de dados.
    public AbstractGraph g;
    public TraversalStrategyInterface traversalStrategy;
    public final List<Vertex> vertices;

    // Construtor da classe GrphController, que chama a função
    // createVertexList 
    public GraphController() {
        vertices = createVertexList();
    }

    // A função está retornando uma ArrayList para a
    // Lista de vertices que é um atributo da classe
    private static List<Vertex> createVertexList()
    {
        return new ArrayList<>();
    }
}
