package jdbcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.MemberDAO;
import jdbcboard.mapper.MemberMapper;
import jdbcboard.model.Member;
import jdbcboard.util.BCryptUtil;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<Member> selectMember() {
		return memberMapper.selectMember();
	}
	
	@Override
	public Member getMember(String mid) {
		return memberMapper.getMember(mid);
	}
	
	@Override
	public int insertMember(Member member) {
		member.setMpass(BCryptUtil.hashPassword(member.getMpass()));
		return memberMapper.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) {
		return memberMapper.updateMember(member);
	}
	
	@Override
	public int deleteMember(String mid) {
		return memberMapper.deleteMember(mid);
	}
	
	@Override
	public  boolean checkLogin(Member member) {
		return BCryptUtil.checkPassword(member.getMpass(), BCryptUtil.hashPassword(member.getMpass()));
	}

}