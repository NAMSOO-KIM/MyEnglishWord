package mvc.models;

import java.sql.SQLException;
import java.util.List;

public interface WordDAO {
	
	
	// wordList 모든 단어 출력
	List<WordDTO> getWordList() throws SQLException;


	// 나만의 단어만 출력
	List<WordDTO> getWordList(String user_id) throws SQLException;
	
	int updateWord(WordDTO wordDTO) throws SQLException;
	
	int deleteWord(WordDTO wordDTO) throws SQLException;

	void insertWord(WordDTO wordDTO) throws SQLException;
	
	int allDeleteWord(WordDTO wordDTO) throws SQLException;
	
	String getWordCount() throws SQLException;
}
