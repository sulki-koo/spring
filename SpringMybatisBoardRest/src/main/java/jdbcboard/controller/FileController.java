package jdbcboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jdbcboard.model.AttachFile;
import jdbcboard.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

	private static final String UPLOAD_DIR = "D:/embededk/uploadfiles/";
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("fileupload")
	@ResponseBody
	public String fileupload(MultipartHttpServletRequest request) {
		List<MultipartFile> files = request.getFiles("files");
		if(files.isEmpty()) {
			return "{\"message\":\"파일이 없습니다\"}";
		} else{
			try {
				for(MultipartFile file: files) {
					String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
					File dest = new File(UPLOAD_DIR + fileName);
					file.transferTo(dest);
					
					AttachFile attachFile = new AttachFile(0, file.getOriginalFilename(), fileName, null, 0);
					fileService.insertAttachFile(attachFile);
				}
				return "{\"message\":\"파일업로드 성공\"}";
			}catch(IOException ioe){
				ioe.printStackTrace();
				return "{\"message\":\"파일업로드 실패\"}";
			}
		}
	}
	
}
