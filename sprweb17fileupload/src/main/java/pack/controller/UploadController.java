package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@Autowired
	private FileValidator fileValidator;
	
	@GetMapping("upload")
	public String abc(@ModelAttribute("uploadFile") UploadFile uploadFile) {
		return "uploadform";
	}
	
	@PostMapping("upload")
	public String submit(@ModelAttribute("uploadFile") UploadFile uploadFile, 
			Model model, BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		//업로드 된 파일 검사
		MultipartFile file = uploadFile.getFile();
		fileValidator.validate(uploadFile, result);
		String filename = file.getOriginalFilename();
		if(result.hasErrors()) {
			return "uploadform"; //에러 발생(파일을 선택하지 않음) 시 수행
		}
		
		try {
			inputStream = file.getInputStream();
			File newFile = new File("C:/work2/sprsou/sprweb17fileupload/src/main/webapp/upload/" + filename);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read =inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (Exception e) {
			System.out.println("file submit err : " + e);
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		model.addAttribute("filename", filename);
		return "uploadfile";
	}
}
