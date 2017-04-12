/**
 * @author TangBin
 * @version V1.0
 * @date 12/04/2017 3:29 PM
 */
public class Sort2_6HeapSort {
    private void sink(Comparable[] a,int k, int length) {
        while (k * 2 <= length) {
            int j = k * 2;
            if (j < length && less(a, j, j + 1)) j++;
            if (!less(a,k, j))
                break;
            exch(a,k, j);
            k = j;
        }
    }

    public void sort(Comparable[] a){
        int N=a.length;
        for(int k=N/2;k>=1;k--)
            sink(a,k,N);
        while(N>1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private boolean less(Comparable[] pq, int i, int j){
        i=i-1;
        j=j-1;
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(Comparable[] pq,int i, int j){
        i=i-1;
        j=j-1;
        Comparable t = pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    public static void main(String... args){
        Sort2_6HeapSort hs = new Sort2_6HeapSort();
        Integer[] a = new Integer[]{12,3,1};
        hs.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }
}
