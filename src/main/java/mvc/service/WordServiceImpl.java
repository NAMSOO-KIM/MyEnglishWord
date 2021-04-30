package mvc.service;


import java.util.List;

import mvc.models.MemberDAO;
import mvc.models.MemberDAOImpl;
import mvc.models.MemberDTO;
import mvc.models.WordDAO;
import mvc.models.WordDAOImpl;
import mvc.models.WordDTO;


public class WordServiceImpl implements WordService {

	private static final WordService wordService = new WordServiceImpl();
	private WordDAO wordDAO = WordDAOImpl.getInstance();
	
	private WordServiceImpl() {
		
	}
	
	public static WordService getInstance() {
		return wordService;
	}
	//단어 등록
	@Override
	public void insertWord(WordDTO wordDTO) throws Exception {

		wordDAO.insertWord(wordDTO);
	}

	@Override
	public List<WordDTO> getWordList() throws Exception {
		// TODO Auto-generated method stub
		return wordDAO.getWordList();
		
	}

	@Override
	public void updateWord(WordDTO wordDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWord(WordDTO wordDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<WordDTO> getWordList(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return wordDAO.getWordList(user_id);
	
	}
	
	@Override
	public String getWordCount() throws Exception {
		// TODO Auto-generated method stub
		return wordDAO.getWordCount();
	}

}