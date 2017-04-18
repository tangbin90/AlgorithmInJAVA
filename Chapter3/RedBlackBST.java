import java.util.NoSuchElementException;

/**
 * @author TangBin
 * @version V1.0
 * @date 14/04/2017 1:22 PM
 */
public class RedBlackBST<Key extends Comparable<Key>,Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node{
        Key key;
        Value val;
        Node left, right;
        boolean color;
        int N;
        Node(Key key ,Value v, int N, boolean color){
            this.key = key;
            this.val = v;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        return x.color==RED;
    }

    private int size(Node node){
        return node.N;
    }

    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N=h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }

    Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left)+size(h.right)+1;
        return x;
    }

    private void flipColors(Node h){
        h.color=!h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public Node put(Node h, Key key, Value val){
        if(h==null)
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if(cmp<0)h.left = put(h.left, key, val);
        else if(cmp>0)h.right = put(h.right, key, val);
        else h.val = val;

        if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right)) flipColors(h);

        h.N = size(h.left)+size(h.right)+1;
        return h;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }



}
