import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 17/04/2017 9:54 AM
 */
public class SeparateChainingHashST<Key, Value> {
    private int N; //键值对总数
    private int M; //散列表大小,即数组的大小

    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(){
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i=0;i<M;i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)%M;
    }

    public Value get(Key key){
       return (Value) st[hash(key)].get(key);
    }

    public void put(Key key,Value val){
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys(){
        List<Key> keys = new LinkedList<Key>();

        for(int i=0;i<M;i++) {
            Iterable<Key> ik = st[i].keys();
            while(ik.iterator().hasNext()){
                Key key = ik.iterator().next();
                keys.add(key);
            }
        }
        return keys;
    }

}
