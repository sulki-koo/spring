package jdbcboard.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapUtil {
	
	private static final String SQLMAPCONFIG = "jdbcboard/conf/sqlMapConfig.xml";
	private static Reader reader = null;
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			reader = Resources.getResourceAsReader(SQLMAPCONFIG);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
} // class
	
	
	
	
	
	
	
	
	
	
	
