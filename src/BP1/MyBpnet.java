package BP1;

import java.math.BigDecimal;

public class MyBpnet {

	public static void main(String args[]) {
		double saminn[] = { 5.887, 5.893, 5.561, 5.839, 5.569, 5.881, 6.284,
				5.576 };// 神经元输入，输入神经元数目为8
		double maxmin[] = new double[2];// 求训练数据最大值和最小值
		maxmin = maxmin(saminn);

		double samin[] = preprocess(maxmin[0], maxmin[1], saminn);// 输入做归一化处理，归一化公式
																	// x'=(x-min)/(max-x)
		double samoutt[] = { 5.887, 5.893, 5.561, 5.839, 5.569, 5.881, 6.284,
				5.576 };// 用原输入数据作为神经元输出来训练网络
		double maxminout[] = maxmin(samoutt);
		double samout[] = preprocess(maxminout[0], maxminout[1], samoutt);// 输出做归一化处理

		int times = 10000;// 训练次数
		double rate = 0.2;// 学习率
		int in = samin.length;// 输入神经元个数
		int out = samout.length;// 输出神经元个数
		double h = Math.sqrt((0.43 * in * out) + 0.12 * out * out + 2.54 * in
				+ 0.77 * out + 0.35) + 0.51;// 按文献上公式求隐含层个数
		BigDecimal b = new BigDecimal(h).setScale(0, BigDecimal.ROUND_HALF_UP);
		int hidN = (int) b.intValue();

		BP bp = new BP(in, hidN, out, times, rate);// 创建BP神经网络
		bp.train(samin, samout);// 利用BP神经网络进行训练
		for (int i = 0; i < hidN; i++) {// 输出训练后网络输入层到隐含层权值和阈值
			for (int j = 0; j < in; j++) {
				System.out.println("输入层到隐含层权值阈值：      " + bp.wyh[i][j] + "   ");
			}
			System.out.println();
		}
		for (int i = 0; i < out; i++) {// 输出训练后隐含层到输出层权值和阈值
			for (int j = 0; j < hidN; j++) {
				System.out.println("隐含层到输出层权值阈值：      " + bp.wyo[i][j]);
			}
			System.out.println();
		}
		double testinn[] = { 5.974, 5.963, 5.465, 5.895, 5.469, 5.641, 5.997,
				5.723 };// 测试数据
		double test[] = maxmin(testinn);
		double testin[] = preprocess(test[0], test[1], testinn);// 测试数据做归一化处理
		double testoutt[] = new double[testin.length];// 测试输入输出数据个数一样
		testoutt = bp.getResult(testin);
		double testout[] = revprocess(test[0], test[1], testoutt);// 网络输出结果做反归一化处理
		for (int i = 0; i < testout.length; i++) {
			System.out.println("测试数据输出：       " + testout[i] + "  ");
		}
		System.out.println();

	}

	/** 求最大值最小值 **/
	public static double[] maxmin(double[] saminn) {
		double a[] = new double[2];
		double max = saminn[0], min = saminn[0];
		for (int i = 1; i < saminn.length; i++) {
			if (max < saminn[i])
				max = saminn[i];
			if (min > saminn[i])
				min = saminn[i];
		}
		a[0] = max;
		a[1] = min;
		return a;

	}

	/** 归一化处理 **/
	public static double[] preprocess(double max, double min, double[] saminn) {
		// System.out.println(max+" "+min);
		double samin[] = new double[saminn.length];
		for (int i = 0; i < samin.length; i++) {
			samin[i] = (saminn[i] - min) / (max - min);
			// System.out.println(samin[i]);
		}
		return samin;

	}

	/** 反归一化处理 **/
	public static double[] revprocess(double max, double min, double[] testoutt) {
		double testout[] = new double[testoutt.length];
		for (int i = 0; i < testout.length; i++) {
			testout[i] = testoutt[i] * (max - min) + min;
		}
		return testout;
	}

}
