import java.util.Scanner;

import graph.DepthFirstTraversal;
import graph.DigraphMatrix;
import graph.GraphController;
import graph.Quest;

public class QuestGraphDFT {
    public static void main(String[] args)
    {

        // Inicialização do Scanner que será utilizado para ler a
        // entrada padrão.
        Scanner stdin = new Scanner(System.in);


        // Instanciação do controlador do gráfo.
        var graphController = new GraphController();


        // Solicita para o usuário a entrada de um inteiro representando
        // o número de vértices no gráfo e as atribui para a variável
        // numberOfVertices.
        System.out.println("Number of vertices: ");
        int numberOfVertices = Integer.parseInt(stdin.nextLine());


        // Solicita a entrada do nome e descrição de todas as quests,
        // e as adiciona como instância na lista de vértices do
        // controlador do gráfo.
        System.out.println("Enter all of the " + numberOfVertices + " vertices: ");
        for(int i = 0 ; i < numberOfVertices ; i++){

            String questName = stdin.nextLine();
            String questDescription = stdin.nextLine();

            graphController.vertices.add(new Quest(questName, questDescription));
        }


        // Após a adição das quests na lista do controlador do gráfo,
        // essa variável é utilizada para inicializar a matriz do
        // dígrafo.
        graphController.g = new DigraphMatrix(graphController.vertices);


        // Inicialização da estratégia de travessia do gráfo como uma
        // instância da busca em produndidade.
        graphController.traversalStrategy = new DepthFirstTraversal(graphController.g);


        // Solicita para o usuário a entrada de um inteiro representando
        // o número de arestas no gráfo e as atribui para a variável
        // numberOfEdges.
        System.out.println("Number of edges: ");
        int numberOfEdges = Integer.parseInt(stdin.nextLine());


        // Solicita a entrada e o destino de todas as arestas,
        // e as adiciona no gráfo através do método addEdge da
        // matriz do dígrafo.
        System.out.println("Enter all of the " + numberOfEdges + " edges: ");
        for(int i = 0 ; i < numberOfEdges ; i++){

            int source = stdin.nextInt();
            int destination = stdin.nextInt();

            graphController.g.addEdge(
                graphController.g.getVertices().get(source),
                graphController.g.getVertices().get(destination));
        }


        // Solicita para o usuário a entrada de um inteiro representando
        // o ID do vértice inicial da buscao e atribui para a variável
        // initialVertex.
        System.out.println("Initial vertex: ");
        int initialVertex = stdin.nextInt();


        // Realiza a busca em profundidade apartir do vértice inicial.
        graphController.traversalStrategy.traverseGraph(
            graphController.g.getVertices().get(initialVertex)
        );

        // Fechamento da instância do scanner
        stdin.close();
    }
}
