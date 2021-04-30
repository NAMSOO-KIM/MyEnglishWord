package mvc.service;


import java.util.List;

import mvc.models.MemberDAO;
import mvc.models.MemberDAOImpl;
import mvc.models.MemberDTO;


public class MemberServiceImpl implements MemberService {

	private static final MemberService memberService = new MemberServiceImpl();
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
	
	private MemberServiceImpl() {
		
	}
	
	public static MemberService getInstance() {
		return memberService;
	}
	
	
	@Override
	public void insertMember(MemberDTO memberDTO) throws Exception {

		memberDAO.insertMember(memberDTO);
		
	}


	@Override
	public MemberDTO getDetail(long no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int loginMember(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		
		int result=memberDAO.loginMember(memberDTO);
		return result;
	}

	@Override
	public List<MemberDTO> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}