<%@ include file="./header.jsp" %>
<%@ page import="com.simplon.jakartaeeclonesimplon.dao.entity.Promos" %>
<%@ page import="java.util.List" %>
<div>
  <table class="w-full rounded-md overflow-hidden">
    <thead>
    <tr class="bg-red-200">
      <th class="p-4 font-semibold text-start">#</th>
      <th class="p-4 font-semibold text-start">Image</th>
      <th class="p-4 font-semibold text-start">Username</th>
      <th class="p-4 font-semibold text-start">Email</th>
<%--      <th class="p-4 font-semibold text-start">Promo name</th>--%>
      <th class="p-4 font-semibold text-start">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="trainer" items="${trainersList}">
      <tr class="h-10 even:bg-gray-50">
        <td class="p-3">${trainer.getTrainerId()}</td>
        <td class="p-3"> <img src="<%=url%>admin/assests/student.png" class="w-11"></td>
        <td class="p-3">${trainer.getUsername()}</td>
        <td class="p-3">${trainer.getEmail()}</td>
<%--        <c:choose>--%>
<%--          <c:when test="${trainer.getPromosByTrainerId().size()> 0}">--%>
<%--          --%>
<%--            <td class="p-3">${((List<Promos>)(trainer.getPromosByTrainerId())).get(0).getPromoName()}</td>--%>
<%--          </c:when>--%>
<%--          <c:otherwise>--%>
<%--            <td class="p-3">ma3andox</td>--%>
<%--          </c:otherwise>--%>
<%--        </c:choose>--%>


        <td class="p-3">
          <div class="flex item-center ">
            <form action="<%=url+"market-admin/promotion"%>" method="post" class="m-0">
              <button name="promotion-id" value="${trainer.getTrainerId()}" class="w-4 mr-2 text-blue-600 transform hover:text-purple-500 hover:scale-110">
                <i class="fa-solid fa-eye"></i>
              </button>
            </form>
            <form class="m-0">
              <button type="button" class="w-4 mr-2 text-green-600 transform hover:text-purple-500 hover:scale-110">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
            </form>
            <form class="m-0">
              <button type="button" class="w-4 mr-2 text-red-600 transform hover:text-purple-500 hover:scale-110 disabled">
                <i class="fa-solid fa-trash-can"></i>
              </button>
            </form>
          </div>
        </td>

      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="./footer.jsp" %>
