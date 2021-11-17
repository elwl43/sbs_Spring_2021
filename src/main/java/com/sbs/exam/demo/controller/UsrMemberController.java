package com.sbs.exam.demo.controller;

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

		return ResultData.newData(joinRd, member);

	}

}