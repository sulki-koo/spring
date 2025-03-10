package jdbcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcboard.dao.FileDAO;
import jdbcboard.model.AttachFile;
import jdbcboard.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO fileDAO;

	@Override
	public List<AttachFile> selectAttachFile(int aid) {
		return fileDAO.selectAttachFile(aid);
	}

	@Override
	public int insertAttachFile(AttachFile attachfile) {
		return fileDAO.insertAttachFile(attachfile);
	}

	@Override
	public int deleteAttachFile(int afid) {
		return fileDAO.deleteAttachFile(afid);
	}

}
