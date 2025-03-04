package springmvc3.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import springmvc3.model.UploadFile;

@Controller
@RequestMapping("/fileupload")
public class FileuploadController {

	@GetMapping(value = "/fileuploadForm.do")
	public String fileuploadForm() {
		return "/fileuploadForm";
	}

	@PostMapping(value = "/fileuploadProc.do")
	public String fileuploadProc(UploadFile uploadFile, Model model) throws IOException {
		MultipartFile multipartFile = uploadFile.getUploadFile();

		if (!multipartFile.isEmpty()) {
			String originalFileName = multipartFile.getOriginalFilename();
			model.addAttribute("title", uploadFile.getTitle());
			model.addAttribute("originalFileName", originalFileName);
			model.addAttribute("fileSize", multipartFile.getSize());
			multipartFile.transferTo(new File("D:/embededk/uploadfiles/" + originalFileName));
		}
		return "/fileuploadResult";
	}

}
