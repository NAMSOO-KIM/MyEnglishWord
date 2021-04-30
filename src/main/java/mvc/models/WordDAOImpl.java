package mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WordDAOImpl implements WordDAO {

	private DataSource dataSource;
	private static final WordDAO wordDAO = new WordDAOImpl();
	private WordDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyWordWeb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static WordDAO getInstance() {
		return wordDAO;
	}

	// 단어 등록(크롤링으로 등록)
	@Override
	public void insertWord(WordDTO wordDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO word(id, member_id, question, answer) ");
		sql.append("VALUES(seq_word.nextval, ?, ?, ?) ");
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			
			ps.setString(1, wordDTO.getMember_id());
			ps.setString(2, wordDTO.getQuestion());
			ps.setString(3, wordDTO.getAnswer());
			ps.executeUpdate();
			
		}
	}

	// 단어 목록 조회
	@Override
	public List<WordDTO> getWordList() throws SQLException {
		StringBuffer sql = new StringBuffer();
		/*
		sql.append("select w.english , w.answer, w.regdate, m.name ");
		sql.append("FROM member m ");
		sql.append("INNER JOIN word w on w.member_id = m.id; ");
		*/
	
		sql.append("select question, answer ");
		sql.append("FROM word ");
		
		List<WordDTO> list = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					WordDTO wordDTO = new WordDTO();
					//wordDTO.setMember_id(rs.getString("member_id"));
					wordDTO.setQuestion(rs.getString("question"));
					wordDTO.setAnswer(rs.getString("answer"));
					list.add(wordDTO);
				}
			}
		} 
		return list;
		
	}
	
	@Override
	public List<WordDTO> getWordList(String user_id) throws SQLException {
		StringBuffer sql = new StringBuffer();
		/*
		sql.append("select w.english , w.answer, w.regdate, m.name ");
		sql.append("FROM member m ");
		sql.append("INNER JOIN word w on w.member_id = m.id; ");
		*/
	
		sql.append("select id, user_id, question, answer ");
		sql.append("FROM word ");
		sql.append("where member_id = ? ");
		
		
		List<WordDTO> list = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			  ps.setString(1,user_id);
			  
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					
					WordDTO wordDTO = new WordDTO();
					wordDTO.setId(rs.getLong("id"));
					wordDTO.setMember_id(rs.getString("member_id"));
					wordDTO.setQuestion(rs.getString("question"));
					wordDTO.setAnswer(rs.getString("answer"));
					list.add(wordDTO);
				}
			}
		} 
		return list;
		
	}
	
	

	// 단어 수정
	@Override
	public int updateWord(WordDTO wordDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
		
	}

	// 단어 삭제
	@Override
	public int deleteWord(WordDTO wordDTO) throws SQLException {
		// TODO Auto-generated method stub
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE t_board  ");
		sql.append("WHERE member_id=?");
		
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			//to-do
			//pstmt.setLong(1, wordDTO.getId());
			return pstmt.executeUpdate();
		
		}
		
	}
	@Override
	public int allDeleteWord(WordDTO wordDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE   ");
		sql.append("FROM WORD; ");
		
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			//to-do
			//pstmt.setLong(1, wordDTO.getId());
			return pstmt.executeUpdate();
		
		}
		
	}
	
	@Override
	public String getWordCount() throws SQLException {

		StringBuffer sql = new StringBuffer();
		sql.append("select count(*)  ");
		sql.append("FROM WORD ");
		
		String row_count="" ;
		try (Connection conn = dataSource.getConnection();
				 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					row_count = rs.getString(1);
					
				}
			}
		} 
		return row_count;
		
	}
}
	
