import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 12/04/2017 11:49 PM
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key, Value val){
        for(Node x = first; x!= null; x = x.next)
            if(key.equals(x.key)){
                x.val=val;
                return;
            }
        first=new Node(key,val,first);

    }

    public int size(){
        Node node = first;
        int length = 0;
        while(node!=null){
            node=node.next;
            length++;
        }
        return length;
    }

    public void delete(Key key){
        Node node=first;

        if(first.key.equals(key))
            first=node.next;

        while(node.next!=null){

            if(node.next.key.equals(key)){
                node.next=node.next.next;
                return;
            }
            node=node.next;
        }
    }

    public Iterable<Key> keys(){
        return keys(this.first);
    }

    public Iterable<Key> keys(Node head){
        List<Key> keys = new LinkedList<Key>();
        Node node = head;
        while(node!=null){
            keys.add(node.key);
        }
        return keys;
    }




}
