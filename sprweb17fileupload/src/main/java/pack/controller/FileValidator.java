package pack.controller;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator{ //파일 유효성 검사
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UploadFile file = (UploadFile)target;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", null);
		}
	}
}
