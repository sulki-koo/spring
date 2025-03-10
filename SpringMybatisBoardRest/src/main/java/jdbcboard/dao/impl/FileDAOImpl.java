package jdbcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.FileDAO;
import jdbcboard.mapper.FileMapper;
import jdbcboard.model.AttachFile;

@Repository("fileDAO")
public class FileDAOImpl implements FileDAO {

	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public List<AttachFile> selectAttachFile(int aid) {
		return fileMapper.selectAttachFile(aid);
	}

	@Override
	public int insertAttachFile(AttachFile attachfile) {
		return fileMapper.insertAttachFile(attachfile);
	}

	@Override
	public int deleteAttachFile(int afid) {
		return fileMapper.deleteAttachFile(afid);
	}

}
