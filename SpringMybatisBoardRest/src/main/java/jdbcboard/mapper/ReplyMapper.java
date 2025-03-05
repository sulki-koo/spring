package jdbcboard.mapper;

import java.util.List;

import jdbcboard.model.Reply;

@MapperMarker
public interface ReplyMapper {

	public abstract List<Reply> selectReply();

	public abstract Reply getReply(int rid);

	public abstract int insertReply(Reply reply);

	public abstract int updateReply(Reply reply);

	public abstract int deleteReply(int rid);

}
