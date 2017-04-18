import java.util.IllegalFormatException;

/**
 * @author TangBin
 * @version V1.0
 * @date 13/04/2017 9:38 AM
 */
@SuppressWarnings("unchecked")
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N=0;

    public BinarySearchST(int capacity){
        keys=(Key[]) new Comparable[capacity];
        vals=(Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i=rank(key);
        if(i<N && keys[i].compareTo(key)==0){
            return vals[i];
        }else
            return null;
    }

    public int rank(Key key){
        return rank(key, 0, N-1);
    }

    private int rank(Key key, int lo, int hi){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int cmp=keys[mid].compareTo(key);
            if(cmp<0) lo=mid+1;
            else if(cmp>0) hi=mid-1;
            else return mid;
        }
        return lo;
    }

    private void resize(int capacity){
        assert capacity>N;
        Key[] tempk = (Key[])new Comparable[capacity];
        Value[] tempv = (Value[])new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        if(key==null) throw new IllegalArgumentException("argument to ceiling() is null");
        int i=rank(key);
        if(i>=N) return null;
        return keys[i];
    }

    public Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        int i=rank(key);
        if(i==0) return null;
        if(i<N&&keys[i].compareTo(key)==0) return keys[i];
        return keys[i-1];
    }

    public void delete(Key key){
        if(key==null) throw new IllegalArgumentException("argument to delete() is null");
        int i=rank(key);
        if(i==N||keys[i].compareTo(key)!=0)
            return;
        for(int cnt=i;cnt<N;cnt++){
            keys[cnt]=keys[cnt+1];
            vals[cnt]=vals[cnt+1];
            N--;
        }
        if(N>=0&&N<=keys.length/4)
            resize(keys.length/4);
    }


    boolean isEmpty(){
        return N==0;
    }

    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }
        if (N == keys.length) resize(2*keys.length);

        int i = rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            vals[i]=val;
            return;
        }

        for (int j = N; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;

    }



}
