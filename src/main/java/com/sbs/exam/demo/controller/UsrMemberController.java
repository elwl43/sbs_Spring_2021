package com.sbs.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.service.MemberService;
import com.sbs.exam.demo.util.Ut;
import com.sbs.exam.demo.vo.Member;
import com.sbs.exam.demo.vo.ResultData;


@Controller
public class UsrMemberController {
	
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		
		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId을(를) 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return ResultData.from("F-2", "loginPw을(를) 입력해주세요.");
		}
		if (Ut.empty(name)) {
			return ResultData.from("F-3", "name을(를) 입력해주세요.");
		}
		if (Ut.empty(nickname)) {
			return ResultData.from("F-4", "nickname을(를) 입력해주세요.");
		}
		if (Ut.empty(cellphoneNo)) {
			return ResultData.from("F-5", "cellphoneNo을(를) 입력해주세요.");
		}
		if (Ut.empty(email)) {
			return ResultData.from("F-6", "email을(를) 입력해주세요.");
		}
		// S-1
		// 회원가입이 완료되었습니다.
		ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		if (joinRd.isFail()) {
			return (ResultData) joinRd;
		}
		Member member = memberService.getMemberById(joinRd.getData1());
		
		return ResultData.newData(joinRd, "member", member);
	}

	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public ResultData doLogout(HttpSession httpSession) {
		boolean isLogined = false;

		if (httpSession.getAttribute("loginedMemberId") == null) {
			isLogined = true;
		}

		if (isLogined) {
			return ResultData.from("F-1", "이미 로그아웃 상태입니다.");
		}

		httpSession.removeAttribute("loginedMemberId");

		return ResultData.from("S-1", "로그아웃 되었습니다.");
	}
	
	@RequestMapping("/usr/member/login")
	public String showLogin(HttpSession httpSession) {

		return "usr/member/login";

	}
	
	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession httpSession, String loginId, String loginPw) {
		boolean isLogined = false;

		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}

		if (isLogined) {
			return Ut.jsHistoryBack("이미 로그인 되었습니다.");
		}

		if (Ut.empty(loginId)) {
			return Ut.jsHistoryBack("loginId를 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return Ut.jsHistoryBack("loginPw를 입력해주세요.");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack("존재하지 않는 로그인아이디 입니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}

		httpSession.setAttribute("loginedMemberId", member.getId());

		return Ut.jsReplace(Ut.f("%s님 환영합니다.", member.getNickname()),"/");
	}

}