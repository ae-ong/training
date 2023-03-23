package pack.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component
public class UploadFile {
	private MultipartFile file;
}
