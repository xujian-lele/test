package BP2;

public class Test {
	public static void main(String[] args){
		BPAnn bp = new BPAnn(0.3, 5, 20, 2);
		double[] in = {1,2,3,4,5};
		double[] out = {10,20} ;

		bp.train(in, out);
		System.out.println();
	}

}
