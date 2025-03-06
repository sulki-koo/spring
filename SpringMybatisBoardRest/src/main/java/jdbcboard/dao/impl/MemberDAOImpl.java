package jdbcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdbcboard.dao.MemberDAO;
import jdbcboard.mapper.MemberMapper;
import jdbcboard.model.Member;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<Member> selectMember() {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		List<Member> memberList = sqlSession.selectList("member.selectMember");
//		sqlSession.close();
		return memberMapper.selectMember();
	}
	
	@Override
	public Member getMember(String mid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		Member member = sqlSession.selectOne("member.getMember", mid);
//		sqlSession.close();		
		return memberMapper.getMember(mid);
	}
	
	@Override
	public int insertMember(Member member) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.insert("member.insertMember", member);
//		sqlSession.commit();
//		sqlSession.close();		
		return memberMapper.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.update("member.updateMember", member);
//		sqlSession.close();		
		return memberMapper.updateMember(member);
	}
	
	@Override
	public int deleteMember(String mid) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		int result = sqlSession.delete("member.deleteMember", mid);
//		sqlSession.commit();
//		sqlSession.close();		
		return memberMapper.deleteMember(mid);
	}
	
	@Override
	public  boolean checkLogin(Member member) {
//		SqlSession sqlSession = SqlMapUtil.getSqlSession();
//		Member member = new Member(mid, null, mpass, null, null, null, null);
//		boolean result = (int)(SqlMapUtil.getSqlSession()
//				.selectOne("member.checkloginMember", member))>0 ? true : false;
//		sqlSession.close();	
//		member = new Member(member.getMid(), null, member.getMpass(), null, null, null, null);
		return memberMapper.checkLogin(member);
	}

}