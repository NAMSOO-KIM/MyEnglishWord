package mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CrawlerDAOImpl implements CrawlerDAO {
	private DataSource dataSource;
	private static final CrawlerDAO crawlerDAO = new CrawlerDAOImpl();
	
	private CrawlerDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyWordWeb");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CrawlerDAO getInstance() {
		return crawlerDAO;
	}
	
	// 크롤링으로 데이터 삽입
	@Override
	public void insertWord(WordDTO wordDTO) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO word(id, member_id, question, answer) ");
		sql.append("VALUES(seq_word.nextval, ?, ? , ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){

			ps.setString(1, wordDTO.getMember_id());
			ps.setString(2, wordDTO.getQuestion());
			ps.setString(3, wordDTO.getAnswer());
			
			ps.executeUpdate();
			
		}
	}

}

