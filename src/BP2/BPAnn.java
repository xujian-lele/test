package BP2;

import java.util.Random;

public class BPAnn {
	private double eta;
	private int hn;
	private int on;
	private double b = 1.0;
	private double momentum = 1.0;

	private double[][] hw;
	private double[][] ow;

	private double[] ho;
	private double[] oo;

	private double[] oe;
	private double[] he;

	public double hes;
	public double oes;

	public BPAnn(double eta, int in, int hn, int on) {
		this.eta = eta;
		this.hn = hn;
		this.on = on;
		this.hw = new double[hn][in + 1];
		this.ow = new double[on][hn + 1];
		this.oe = new double[on];
		this.he = new double[hn];
		random(hw);
		random(ow);
	}

	private void random(double[][] m) {
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = r.nextDouble() * 2 - 1;
			}
		}
	}

	public double[] test(double[] x) {
		// 隐藏层的输出
		double[] ho = new double[hn];
		double[] oo = new double[on];
		forward(x, ho, hw);
		forward(ho, oo, ow);
		this.ho = ho;
		this.oo = oo;
		return oo;
	}

	private void forward(double[] in, double[] out, double[][] ws) {
		// j 第 j 个 单元的 输入权重向量
		for (int j = 0; j < ws.length; j++) {
			// ws[ j ][ 0 ] j 的偏置权重
			double sum = b * ws[j][0];
			for (int i = 0; i < in.length; i++) {
				sum += in[i] * ws[j][i + 1];
			}
			// out[j] 第 j 输出
			sum = sigmoid(sum);
			out[j] = sum;
		}
	}

	public void train(double[] in, double[] t) {
		test(in);
		calculateError(in, t);
		adjust(ho, oe, ow);
		adjust(in, he, hw);
	}

	public void calculateError(double[] in, double[] t) {
		double sum = 0;
		// 调整输出层权重
		for (int i = 0; i < oe.length; i++) {
			double o = oo[i];
			double d = t[i];
			double e = o * (1 - o) * (d - o);
			oe[i] = e;
			sum += Math.abs(e);
		}
		oes = sum;
		sum = 0;
		// 调整隐藏层权重
		for (int i = 0; i < he.length; i++) {
			double o = ho[i];
			double s = 0;
			for (int j = 0; j < oe.length; j++) {
				s += ow[j][i + 1] * oe[j];
			}
			double e = o * (1 - o) * s;
			he[i] = e;
			sum += Math.abs(e);
		}
		hes = sum;
	}

	/**
	 * @param in
	 * @param delta
	 *            误差
	 * @param ws
	 */
	private void adjust(double[] in, double[] delta, double[][] ws) {
		// i : 第 i 个输出单元
		for (int i = 0; i < delta.length; i++) {
			// j ：分量权重
			for (int j = 0; j <= in.length; j++) {
				// xi : i 单元的 输入向量 的 j 分量
				double xi = j == 0 ? b : in[j - 1];
				ws[i][j] = eta * xi * delta[i] + momentum * ws[i][j];
			}
		}
	}

	private double sigmoid(double x) {
		return 1.0 / (1.0 + Math.exp(-x));
	}


}
