<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<table class="table table-hover" id="tb1">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
					<td><input type="checkbox" id="checkAll"><button id="del" class="btn btn-danger">Delete</button></td>
				</tr>
				<c:forEach items="${list}" var="mo" varStatus="i">
				<tr>
					<td id="id${i.index}">${mo.id}</td>
					<td><a href="">${mo.name}</a></td>
					<td>${mo.phone}</td>
					<td>${mo.email}</td>
					<td class="chk"><input type="checkbox" name="del" title="id${i.index}" id="${mo.id}" class="check"></td>
				</tr>
				</c:forEach>
				
			
			</table>
			
 			<div>
				<ul class="pagination">
					<c:if test="${pager.curBlock gt 1}">
					<li><a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
					</c:if>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						
						<li><a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
					<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
					</c:if>
				</ul>
				
			</div> 