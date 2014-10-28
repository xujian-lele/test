package BP1;

public class BP {

	double wyh[][], wyo[][];// 权值，最后一行为阈值
	int hidN;// 隐含层单元个数
	int inN;// 输入单元个数
	int outN;// 输出单元个数
	int times;// 迭代次数
	double rate;// 学习率
	boolean trained = false;// 保证测试前先训练

	BP(int inN, int hidN, int outN, int times, double rate) {// 构造函数
		this.inN = inN;
		this.outN = outN;
		this.hidN = hidN;
		this.rate = rate;
		this.times = times;
	}

	public void train(double inData[], double outData[]) {// 网络训练
		double err = 0;// 总体误差
		int count = times;
		double temphid[] = new double[hidN];// 保存隐含层输出
		double tempout[] = new double[outN];// 保存输出层输出
		double errout[] = new double[outN];// 输出层各神经元误差
		double errhid[] = new double[hidN];// 隐含层各神经元误差

		wyh = new double[hidN][inN + 1];// 最后一行为隐含层阈值

		for (int i = 0; i < hidN; i++) {
			for (int j = 0; j <= inN; j++) {
				wyh[i][j] = Math.random() - 0.5;// 初始化权值和阈值
				// System.out.println(wyh[i][j]);
			}
		}
		// System.out.println();
		wyo = new double[outN][hidN + 1];// 最后一行为计算输出的阈值
		for (int i = 0; i < outN; i++) {
			for (int j = 0; j <= hidN; j++) {
				wyo[i][j] = Math.random() - 0.5;// 初始化权值和阈值
				// System.out.println(wyo[i][j]);
			}
		}
		while ((count--) > 0) {
			for (int i = 0; i < hidN; i++) {// 遍历每个隐含单元的结果
				temphid[i] = 0;
				for (int j = 0; j < inN; j++) {
					temphid[i] += wyh[i][j] * inData[j];
				}
				temphid[i] += wyh[i][inN];
				temphid[i] = 1.0 / (1 + Math.exp(-temphid[i]));
				// System.out.println(temphid[i]);
			}

			for (int i = 0; i < outN; i++) {// 计算每个输出层单元的结果
				tempout[i] = 0;
				for (int j = 0; j < hidN; j++) {
					tempout[i] += wyo[i][j] * temphid[j];
				}
				tempout[i] += wyo[i][hidN];
				tempout[i] = 1.0 / (1 + Math.exp(-tempout[i]));
			}
			// 每个输出单元的计算误差
			for (int i = 0; i < outN; ++i) {
				errout[i] = tempout[i] * (1 - tempout[i])
						* (outData[i] - tempout[i]);
				err += Math.pow((outData[i] - tempout[i]), 2);
			}
			err = err / 2;// 最终误差计算
			// 计算每个隐含层单元的误差
			double errh = 0;
			for (int i = 0; i < hidN; i++) {
				for (int j = 0; j < outN; j++) {
					errh += errout[j] * wyo[j][i];
				}
				errhid[i] = temphid[i] * (1 - temphid[i]) * errh;
			}

			// 改变输出层权值
			for (int i = 0; i < outN; i++) {
				for (int j = 0; j < hidN; j++) {
					wyo[i][j] += rate * temphid[j] * errout[i];
				}
				wyo[i][hidN] += rate * errout[i];// 改变阈值
			}

			// 改变隐含层权值和阈值
			for (int i = 0; i < hidN; i++) {
				for (int j = 0; j < inN; j++) {
					wyh[i][j] += rate * inData[j] * errhid[i];
				}
				wyh[i][inN] += rate * errhid[i];
			}
			if (err < 0.0001)
				break;

		}

		System.out.println("训练次数：" + count + "   ，训练误差" + err);
		trained = true;
	}

	public double[] getResult(double inData[]) {// 得到测试数据的输出
		double temphid[] = new double[hidN];// 隐含层个数暂时不变
		double tempout[] = new double[inData.length];// 测试数据输入多少个输出就多少个
		if (trained == false)
			return null;
		for (int i = 0; i < hidN; i++) {
			temphid[i] = 0;
			for (int j = 0; j < inData.length; j++) {
				temphid[i] += wyh[i][j] * inData[j];
			}
			temphid[i] += wyh[i][inData.length];
			temphid[i] = 1.0 / (1 + Math.exp(-temphid[i]));
		}
		for (int i = 0; i < tempout.length; i++) {
			tempout[i] = 0;
			for (int j = 0; j < hidN; j++) {
				tempout[i] += wyo[i][j] * temphid[j];
			}
			tempout[i] += wyo[i][hidN];
			tempout[i] = 1 / (1 + Math.exp(-tempout[i]));// 测试数据的输出
		}
		return tempout;// 返回测网络输出的测试结果
	}

}
