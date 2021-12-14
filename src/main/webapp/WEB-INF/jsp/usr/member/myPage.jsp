<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="마이페이지" />

<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">
    <form class="table-box-type-1">
      <table>
        <colgroup>
          <col width="200">
        </colgroup>
        <tbody>
          <tr>
            <th>로그인 아이디</th>
            <td>${rq.loginedMember.loginId }</td>
          </tr>
          <tr>
            <th>이름</th>
            <td>${rq.loginedMember.name }</td>
          </tr>
          <tr>
            <th>닉네임</th>
            <td>${rq.loginedMember.nickname }</td>
          </tr>
          <tr>
            <th>이메일</th>
            <td>${rq.loginedMember.email }</td>
          </tr>
          <tr>
            <th>전화번호</th>
            <td>${rq.loginedMember.cellphoneNo }</td>
          </tr>
        </tbody>
      </table>
    </form>

    <div class="btns mt-2">
      <a href="../member/checkPassword" class="btn btn-outline">회원정보수정</a>
      <button class="btn btn-outline" type="button"
        onclick="history.back();">뒤로가기</button>

    </div>
  </div>
</section>
<%@ include file="../common/foot.jspf"%> 