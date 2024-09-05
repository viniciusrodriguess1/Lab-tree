package tree;

public class Node {
    int valor;
    Node esqNode;
    Node dirNode;

    public Node(int valor,Node esqNode,Node dirNode){
        this.dirNode = dirNode;
        this.esqNode = esqNode;
        this.valor = valor;
    }
}
