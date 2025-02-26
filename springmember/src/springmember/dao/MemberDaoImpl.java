package springmember.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmember.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Member> selectMember() {
		String sql = " select * from springmember ";
		return jdbcTemplate.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("mid"), rs.getString("mname"), rs.getString("mgender"), rs.getString("mcity"));
				return member;
			}
		});
	}

	@Override
	public Member getMember(String mid) {
		String sql = " select * from springmember where mid=? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {mid}, new RowMapper<Member>(){
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("mid"), rs.getString("mname"), rs.getString("mgender"), rs.getString("mcity"));
				return member;
			}
		});
	}

	@Override
	public int insertMember(Member member) {
		String sql = " insert into springmember values (?, ?, ?, ?) ";
		int result = this.jdbcTemplate.update(sql.toString(), member.getMid(), member.getMname(), member.getMgender(), member.getMcity());
		return result;
	}

	@Override
	public int updateMember(Member member) {
		String sql = " update springmember set mname=?, mgender=?, mcity=? where mid=? ";
		int result = this.jdbcTemplate.update(sql.toString(), member.getMname(), member.getMgender(), member.getMcity(), member.getMid());
		return result;
	}

	@Override
	public int deleteMember(Member member) {
		String sql = " delete springmember where mid=? ";
		int result = this.jdbcTemplate.update(sql.toString(), member.getMid());
		return result;
	}

}
