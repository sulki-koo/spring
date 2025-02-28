package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Member;

public interface MemberService {
	
	default List<Member> selectMember() { return null; }
	
	default Member getMember(String mid) { return null; }
	
	default int insertMember(Member member) { return 0; }
	
	default int updateMember(Member member) { return 0; }
	
	default int deleteMember(String mid) { return 0; }
	
	default boolean checkLogin(String mid, String mpass) { return false; }

}









