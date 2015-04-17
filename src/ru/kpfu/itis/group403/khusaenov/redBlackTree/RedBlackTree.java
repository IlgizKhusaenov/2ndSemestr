package ru.kpfu.itis.group403.khusaenov.redBlackTree;

public class RedBlackTree<K extends Comparable<K>, V> {

    private Node root;
    private enum Color {
        RED,
        BLACK
    }

    private class Node {
        K key;
        V value;

        Node leftChild;
        Node rightChild;

        Color color;

        public Node(V value, K key, Color color) {
            this.value = value;
            this.key = key;
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Color getColor() {
            return color;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }
    }

    private Node turnLeft(Node node) {
        Node buff = node.rightChild;
        node.rightChild = buff.leftChild;
        buff.leftChild = node;
        buff.color = node.color;
        node.color = Color.RED;
        return buff;
    }

    private Node turnRight(Node node) {
        Node buff = node.leftChild;
        node.leftChild = buff.rightChild;
        buff.rightChild = node;
        buff.color = node.color;
        node.color = Color.RED;
        return buff;
    }

    private void changeColors(Node node) {
        node.rightChild.color = node.color;
        node.color = node.leftChild.color;
        node.leftChild.color = node.rightChild.color;
    }

    public void put(K key, V value){

        root = put(root,key,value);
        root.color = Color.BLACK;
    }

    public V get(K key){

        return get(root,key);
    }

    private V get(Node node, K key){

        if (node == null){
            return null;
        }

        int diff = key.compareTo(node.key);

        if (diff < 0){
            return get(node.leftChild,key);
        }
        if (diff > 0){
            return get(node.rightChild,key);
        }
        return node.value;

    }

    private Node put(Node node, K key, V value){
        if (node == null){
            return new Node(value, key, Color.RED);
        }
        int diff = key.compareTo(node.key);
        if (diff < 0){
            node.leftChild = put(node.leftChild, key, value);
        }else if (diff > 0){
            node.rightChild = put(node.rightChild,key,value);
        }else {
            node.value = value;
        }

        if (isRed(node.rightChild) && !isRed(node.leftChild)){
            node = turnLeft(node);
        }
        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild)){
            node = turnRight(node);
        }
        if (isRed(node.leftChild) && isRed(node.rightChild)){
            changeColors(node);
        }

        return node;
    }


    private boolean isRed(Node node) {
        return node != null && node.color.equals(Color.RED);
    }
}
