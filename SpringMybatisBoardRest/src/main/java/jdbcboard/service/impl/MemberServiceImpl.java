package jdbcboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcboard.dao.MemberDAO;
import jdbcboard.dao.impl.MemberDAOImpl;
import jdbcboard.model.Member;
import jdbcboard.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<Member> selectMember() {
		return memberDAO.selectMember();
	}
	
	@Override
	public Member getMember(String mid) {
		return memberDAO.getMember(mid);
	}
	
	@Override
	public int insertMember(Member member) {
		return memberDAO.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) {
		return memberDAO.updateMember(member);
	}
	
	@Override
	public int deleteMember(String mid) {
		return memberDAO.deleteMember(mid);
	}
	
	@Override
	public boolean checkLogin(Member member) {
		return memberDAO.checkLogin(member);
	}

}
