package mvc.service;

import java.util.List;


import mvc.models.WordDTO;

public interface WordService {
	
	void insertWord(WordDTO wordDTO) throws Exception;

	List<WordDTO> getWordList() throws Exception;

	void updateWord(WordDTO wordDTO) throws Exception;
	
	void deleteWord(WordDTO wordDTO) throws Exception;
	
	List<WordDTO> getWordList(String user_id) throws Exception;
	
	String getWordCount() throws Exception;
	
}
