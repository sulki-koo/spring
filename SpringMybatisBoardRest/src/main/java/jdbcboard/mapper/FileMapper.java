package jdbcboard.mapper;

import java.util.List;

import jdbcboard.model.AttachFile;

@MapperMarker
public interface FileMapper {
	
	public abstract List<AttachFile> selectAttachFile(int aid);
	
	public abstract AttachFile getAttachFile(int afid);

	public abstract int insertAttachFile(AttachFile attachfile);

	public abstract int deleteAttachFile(int afid);

}
