package jdbcboard.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jdbcboard.constant.BoardConstant;
import jdbcboard.model.AttachFile;
import jdbcboard.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping("fileupload")
	@ResponseBody
	public String fileupload(MultipartHttpServletRequest request) {
		List<MultipartFile> files = request.getFiles("files");
		if (files.isEmpty()) {
			return "{\"message\":\"파일이 없습니다\"}";
		} else {
			try {
				for (MultipartFile file : files) {
					String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
					File dest = new File(BoardConstant.UPLOAD_DIR + fileName);
					file.transferTo(dest);

					AttachFile attachFile = new AttachFile(0, file.getOriginalFilename(), fileName, null, Integer.parseInt(request.getParameter("aid")));
					fileService.insertAttachFile(attachFile);
				}
				return "{\"message\":\"파일업로드 성공\"}";
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return "{\"message\":\"파일업로드 실패\"}";
			}
		}
	}

	@GetMapping("/filedownload/{afid}")
	public void filedownload(@PathVariable int afid, HttpServletRequest request, HttpServletResponse response) {

		AttachFile attachFile = fileService.getAttachFile(afid);

		String encodedFileName = null;
		try {
			encodedFileName = URLEncoder.encode(attachFile.getAfcname(), StandardCharsets.UTF_8.toString());
			encodedFileName = encodedFileName.replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException usee) {
			usee.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
	}

	@GetMapping("/attachfiles/{aid}")
	@ResponseBody
	public List<AttachFile> selectAttachFile(@PathVariable int aid) {
		return fileService.selectAttachFile(aid);
	}

	@DeleteMapping("/attachfiles/{afid}")
	@ResponseBody
	public Map<String, Integer> deleteAttachFile(@PathVariable int afid) {
		
		AttachFile attachFile = fileService.getAttachFile(afid);
		File file = new File(BoardConstant.UPLOAD_DIR + attachFile.getAfsname());
		if(file.exists()) {
			file.delete();
		}
		
		int result = fileService.deleteAttachFile(afid);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	
}
