import java.util.Comparator;
import java.util.List;
import edu.princeton.cs.algs4.StdOut;


public class Comparator {

	public Comparator() {
		// TODO Auto-generated constructor stub
	}
    private static Object[] aux;
    private static void merge(Object[] a,int lo,int mid,int hi,Comparator comparator){
    	for (int i = lo; i <=hi; i++) {
    		aux[i]=a[i];
		}
    	int i=lo,j=mid+1;
    	for (int k = lo; k <= hi; k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(a[i],a[j])) a[k]=aux[i++];
			else a[k]=aux[j++];
		}
    }
    private static void sort(Object[] a ,Comparator comparator){
    	int n=a.length;
    	for(int sz=1;sz<n;sz=sz*2){
    		for(int lo=0;lo<n-sz;lo+= sz+sz )
    			merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1),comparator);
    	}
    }
    private static boolean less(Object v,Object w,Comparator c){
    	return c.less(v, w, c);
    }
    private static void show(Object[] a){
    	for (int i = 0; i < a.length; i++) {
		StdOut.println(a[i]+" ");
		}
    }
	/**
	 * @param args
	 */
    public class Student{
    	public static final Comparator<Student> BY_NAME =new  ByName();
    	public static final Comparator<Student> BY_SECTION = new BySection();
    	private final String name;
    	private final int section;
    }
    private static class ByName implements Comparator <Student>{
    	public int compare(Student v,Student w){
    		return v.name.compareTo(w.name);
    	}
    }
    public static class BySection implements Comparator<Student>{
    	public int compare(Student v, Student w){
    		return v.section-w.section;
    	}
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
