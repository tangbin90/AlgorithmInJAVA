import edu.princeton.cs.algs4.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 13/04/2017 2:21 PM
 */
public class BST <Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x==null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){
        Node node=x;
        while(node!=null){
            if(node.key.compareTo(key)==0)
                return node.val;
            else if(node.key.compareTo(key)>0)
                node = node.left;
            else
                node=node.right;
        }
        return null;
    }
    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x==null){
            Node node = new Node(key,val,1);
            return node;
        }

        int cmp = x.key.compareTo(key);
        if(cmp<0) put(x.right,key,val);
        else if(cmp>0) put(x.left,key,val);
        else x.val=val;

        x.N=size(x.left)+size(x.right)+1;
        return x;

    }

    private Node put1(Node x, Key key, Value val){
        if(key==null) return x;
        Node node = new Node(key, val, 1);
        if(x==null)
            return node;

        Node pre=null;
        Node cur=x;
        while(cur!=null){
            if(cur.key.compareTo(node.key)>0){
                pre=cur;
                cur=cur.left;
                cur.N+=1;
            }else if(cur.key.compareTo(node.key)<0){
                pre=cur;
                cur=cur.right;
                cur.N+=1;
            }else{
                cur.val=val;
                return x;
            }
        }
        if(pre.key.compareTo(node.key)>0)
            pre.left=node;
        else
            pre.right=node;

        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x=floor(root, key);
        if(x==null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        else if(cmp<0) return floor(x.left,key);
        Node t=floor(x.right, key);
        if(t!=null) return t;
        else return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }

    private Node select(Node x, int k){
        //返回排名为K的节点
        if(x==null) return null;
        int t=size(x.left);
        if(t>k) return select(x.left,k);
        else if(t<k) return select(x.right,k-t-1);
        else return x;
    }

    public int rank(Key key){
        return rank(key, root);
    }

    private int rank(Key key, Node x){
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return rank(key, x.left);
        else if(cmp>0) return 1+size(x.left)+rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin(){
        deleteMin(root);
    }

    private Node deleteMin(Node node){
        if(node.left==null) return node.right;
        node.left = deleteMin(node.left);
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    private void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x==null) return null;
        int cmp = x.key.compareTo(key);
        if(cmp>0)x.left=delete(x.left,key);
        else if(cmp<0)x.right=delete(x.right,key);
        else{
            if(x.right==null) return x.left;
            if(x.left==null) return x.right;
            Node t=x;
            x = min(t.right);
            x.right=deleteMin(t.right);
            x.left=t.left;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if(x==null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo<0) keys(x.left, queue, lo, hi);
        if(cmplo<=0&& cmphi>=0) queue.enqueue(x.key);
        if(cmphi>0) keys(x.right, queue, lo, hi);
    }

}
