<%@ include file="./header.jsp" %>
<div>
    <table class="w-full rounded-md overflow-hidden">
        <thead>
        <tr class="bg-red-200">
            <th class="p-4 font-semibold text-start">#</th>
            <th class="p-4 font-semibold text-start">Promo Name</th>
            <th class="p-4 font-semibold text-start">Promo Year</th>
            <th class="p-4 font-semibold text-start">Promo Trainer</th>
            <th class="p-4 font-semibold text-start">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${promosList}">
            <tr class="h-10 even:bg-gray-50">
                <td class="p-3">${p.getPromoId()}</td>
                <td class="p-3">${p.getPromoName()}</td>
                <td class="p-3">${p.getCreatedOn()}</td>
                            <c:choose>
                              <c:when test="${p.getTrainersByTrainerId().getUsername() != null}">
                                  <td class="p-3">${p.getTrainersByTrainerId().getUsername()}</td>
                              </c:when>
                              <c:otherwise>
                                <td class="p-3">-----</td>
                              </c:otherwise>
                            </c:choose>

                <td class="p-3">
                    <div class="flex item-center ">
                        <form action="<%=url+"market-admin/promotion"%>" method="post" class="m-0">
                            <button name="promotion-id" value="${p.getPromoId()}" class="w-4 mr-2 text-blue-600 transform hover:text-purple-500 hover:scale-110">
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

