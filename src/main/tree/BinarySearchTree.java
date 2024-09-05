package tree;

import estrut.Tree;

public class BinarySearchTree implements Tree{
    public Node raiz;

    public BinarySearchTree(){
        this.raiz = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        
    }

    @Override
    public int minimo() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia");
        }
        Node current = raiz;
        while (current.esqNode != null) {
            current = current.esqNode;
        }
        return current.valor;
    }

    @Override
    public int maximo() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia");
        }
        Node current = raiz;
        while (current.dirNode != null) {
            current = current.dirNode;
        }
        return current.valor;
    }

    @Override
    public void insereElemento(int valor) {
        raiz = insereElementoRecursivo(raiz, valor);
    }

    private Node insereElementoRecursivo(Node current, int valor) {
        if (current == null) {
            return new Node(valor, null, null);
        }

        if (valor < current.valor) {
            current.esqNode = insereElementoRecursivo(current.esqNode, valor);
        } else if (valor > current.valor) {
            current.dirNode = insereElementoRecursivo(current.dirNode, valor);
        }
        return current;
    }

    @Override
    public void remove(int valor) {
        raiz = removeElementoRecursivo(raiz, valor);
    }

    private Node removeElementoRecursivo(Node current, int valor) {
        if (current == null) {
            return null;
        }

        if (valor == current.valor) {
            if (current.esqNode == null && current.dirNode == null) {
                return null;
            }
            if (current.esqNode == null) {
                return current.dirNode;
            }
            if (current.dirNode == null) {
                return current.esqNode;
            }
            int menorValorDireita = findMin(current.dirNode);
            current.valor = menorValorDireita;
            current.dirNode = removeElementoRecursivo(current.dirNode, menorValorDireita);
            return current;

        }

        if (valor < current.valor) {
            current.esqNode = removeElementoRecursivo(current.esqNode, valor);
        } else {
            current.dirNode = removeElementoRecursivo(current.dirNode, valor);
        }

        return current;
    }

    @Override
    public int[] preOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] emOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] posOrdem() {
        return new int[]{1,2};
    }

}