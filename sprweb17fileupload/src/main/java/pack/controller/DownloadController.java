package pack.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadController {
	@PostMapping("download")
	@ResponseBody
	public byte[] downProcess(HttpServletResponse response, 
			@RequestParam String filename) throws Exception{
		System.out.println(filename);
		
		File file = new File("C:/work2/sprsou/sprweb17fileupload/src/main/webapp/upload/" + filename);
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(), "iso_8859_1");
		
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		return bytes;
	}
}
