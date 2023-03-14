package other;

import java.io.FileWriter;

public class OutFileInterImpl implements OutFileInter{
	private String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void outFile(String msg) {
		//msg를 파일로 출력
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(msg);
			writer.close();
			System.out.println("파일 저장 완료");
		} catch (Exception e) {
			System.out.println("outFile err : " + e);
		}
	}
}
