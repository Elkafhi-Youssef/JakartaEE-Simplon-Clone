<%@ include file="./header.jsp" %>
<h1 class="text-xl font-semibold text-blue-800 text-2xl">Add New Promo</h1>
<div class="bg-gray-50 mx-auto p-6 rounded-md mt-4 border border-blue-100">
  <form action="<%=url+"AdminServlet"%>" method="post">
    <div class="flex item-center gap-3">
      <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
        <label class="text-lg px-2" for="promoname">Promo Name</label>
        <input required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="promoname" name="promoname" placeholder="Enter Promo Name">
      </div>
      <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
        <label class="text-lg px-2" for="created_on">Promo Year </label>
        <input required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="created_on" name="created_on" placeholder="Enter Year of creation (2020/2021)">
      </div>
    </div>

    <input type="text" name="action" value="addPromo">
    <div class="flex items-center justify-end mt-4">
      <button class="hover:shadow-form rounded-md bg-red-500  hover:bg-red-700 py-3 px-8 text-center text-base font-semibold text-yellow-300 outline-none">
        Submit
      </button>
    </div>
  </form>
</div>
<%@ include file="./footer.jsp" %>

