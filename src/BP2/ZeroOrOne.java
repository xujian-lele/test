package BP2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZeroOrOne {
	public static void main(String[] args){
		BP bp = new BP(1, 20, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd	HH:mm:ss");
		String start = sdf.format(new Date());
		System.out.println("正在训练....");
		while(bp.optErrSum==0 || bp.optErrSum>0.000000001){
			
			for(float i=0;i<0.4;i=(float) (i+0.001)){
				double[] trainData = new double[1];
				trainData[0] = i*0.001;
				double[] target = new double[1];
				target[0] = 0;
				bp.train(trainData, target);
			}
			
			for(float i=1;i>0.6;i=(float) (i-0.01)){
				double[] trainData = new double[1];
				trainData[0] = 1-0.01*i;
				double[] target = new double[1];
				target[0] = 1;
				bp.train(trainData, target);
			}
			
			System.out.println("opterror:	"+bp.optErrSum+"	hidErrSum:	"+bp.hidErrSum);
		}

		String end = sdf.format(new Date());
		System.out.println("训练开始时间：	"+start);
		System.out.println("训练结束时间：	"+end);

		
		System.out.println("训练完毕，请输入一个小数，判定该数是1还是0");
		while(true){
			byte[] in = new byte[10];
			try {
				System.in.read(in);
				if(in.toString().trim().equalsIgnoreCase("exit")){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double input = Double.parseDouble(new String(in).trim());
			double[] inData = new double[1];
			inData[0] = input;
			double[] result = bp.test(inData);
			
			if(Math.abs(result[0])<0.5){
				System.out.println(result[0]+"	该数是0");
			}
			
			else 
				System.out.println(result[0]+"	该数是1");
		}

	}
}
