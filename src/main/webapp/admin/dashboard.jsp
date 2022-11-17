<%@ include file="./header.jsp" %>
<div>
    <table class="w-full rounded-md overflow-hidden">
        <thead>
        <tr class="bg-red-200">
            <th class="p-4 font-semibold text-start">#</th>
            <th class="p-4 font-semibold text-start">Image</th>
            <th class="p-4 font-semibold text-start">Username</th>
            <th class="p-4 font-semibold text-start">Email</th>
            <th class="p-4 font-semibold text-start">Promo name</th>
            <th class="p-4 font-semibold text-start">Tainer name</th>
            <th class="p-4 font-semibold text-start">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${studentsList}">
            <tr class="h-10 even:bg-gray-50">
                <td class="p-3">${student.getStudentId()}</td>
                <td class="p-3"> <img src="<%=url%>admin/assests/student.png" class="w-11"></td>
                <td class="p-3">${student.getUsername()}</td>
                <td class="p-3">${student.getEmail()}</td>
                <c:choose>
                  <c:when test="${student.getPromosByPromoId() != null}">

                      <td class="p-3">${student.getPromosByPromoId().getPromoName()}</td>
                      <td class="p-3">${student.getPromosByPromoId().getTrainersByTrainerId().getUsername()}</td>
                  </c:when>
                  <c:otherwise>
                    <td class="p-3">------</td>
                    <td class="p-3">------</td>
                  </c:otherwise>
                </c:choose>

                <td class="p-3">
                    <div class="flex item-center ">

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