package jdbcboard.mapper;

import java.util.List;

import jdbcboard.model.Member;

@MapperMarker
public interface MemberMapper {
	
	public abstract  List<Member> selectMember();
	
	public abstract  Member getMember(String mid);
	
	public abstract  int insertMember(Member member);
	
	public abstract  int updateMember(Member member);
	
	public abstract  int deleteMember(String mid);
	
	public abstract  boolean checkLogin(Member member);

}









