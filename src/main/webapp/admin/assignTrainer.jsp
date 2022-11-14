<%@ include file="./header.jsp" %>
<h1 class="text-xl font-semibold text-blue-800 text-2xl">Assign Trainer To Promo</h1>
<div class="bg-red-50 mx-auto p-6 rounded-md mt-4 border border-red-100">
  <form action="<%=url+"AdminServlet"%>" method="post">
    <div class="flex item-center gap-3">
      <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
        <label class="text-lg px-2" for="promo">Promos</label>
        <select  class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="promo" name="promo">

        <option selected value=""> click to select promo </option>
        <option  value="US">United States</option>
            <c:forEach var="promo" items="${promosList}">
                <option  value="${promo.getPromoId()}">${promo.getPromoId()} - ${promo.getPromoName()}</option>
            </c:forEach>
        </select>
      </div>
        <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
            <label class="text-lg px-2" for="trainer">Trainers</label>
            <select  class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="trainer" name="trainer" >
                <option selected value=""> click to select trainer </option>
                <c:forEach var="trainer" items="${trainersList}">
                    <option  value="${trainer.getTrainerId()}">${trainer.getTrainerId()} - ${trainer.getUsername()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
      <input hidden type="text" name="action" value="AssignTrainer">
      <div class="flex items-center justify-end mt-4">
      <button class="hover:shadow-form rounded-md bg-red-500  hover:bg-red-700 py-3 px-8 text-center text-base font-semibold text-yellow-300 outline-none">
        Submit
      </button>
    </div>
  </form>
</div>
<%@ include file="./footer.jsp" %>

