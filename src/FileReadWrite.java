import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileReadWrite {
	public FileReadWrite(){
		System.out.println(this.getClass().getResource("/").getPath());
	}
	
	public static void main(String[] args) throws IOException {
		String pathin = "./src/1";
		String pathout = "./src/2";
//		FileReadWrite frw=new FileReadWrite();
//		pathin = frw.getClass().getResource("/").getPath()+"1";
//		pathout = frw.getClass().getResource("/").getPath()+"2";
		
		// TODO Auto-generated method stub
		File f = new File(pathin);
		FileInputStream fis = new FileInputStream(f);
		
		File f1 = new File(pathout);
		FileOutputStream fo = new FileOutputStream(f1);
		
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo,"utf-8"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String s=br.readLine();
			while(s.length()>0){
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				sb.append("	名词");
				sb.append("\n");
				bw.write(sb.toString());
				bw.flush();
				s=br.readLine();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
