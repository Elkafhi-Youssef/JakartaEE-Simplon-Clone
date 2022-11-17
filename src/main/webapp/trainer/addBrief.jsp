<%@ include file="./header.jsp" %>
<h1 class="text-xl font-semibold text-red-800 text-2xl">Add new Brief</h1>
<div class="bg-gray-50 mx-auto p-6 rounded-md mt-4 border border-red-100">
  <form action="<%=url+"TrainerServlet"%>" method="post">
    <div class="flex item-center gap-3">
      <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
        <label class="text-lg px-2" for="title">Brief Title</label>
        <input type="text" required class="h-full focus:left-0 focus:outline-red-500 absolute w-full top-0 p-2 rounded-md" id="title" name="title" placeholder="Enter the brief title">
      </div>
      <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
        <label class="text-lg px-2" for="dates">Date start</label>
        <input type="text" required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="dates" name="dates" placeholder="Enter the brief date start ">
      </div>
      <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
        <label class="text-lg px-2" for="datee">Date End</label>
        <input type="text" required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="datee" name="datee" placeholder="Enter the brief date start ">
      </div>
    </div>
    <div class="flex item-center gap-3 mt-5" style="
    height: 150px;">
      <div class="border p-2  relative flex-1 overflow-hidden rounded-md w-1/2">
        <label class="text-lg px-2" for="desc">Description</label>
        <textarea  type="text" required class=" h-40 focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="desc" name="desc" placeholder="Enter description"></textarea>
      </div>
      <input hidden type="text" name="promoId" value="${promoId}" >
      <input hidden type="text" name="action" value="AddBrief">
    </div>
    <div class="flex items-center justify-end mt-4">
      <button class="hover:shadow-form rounded-md bg-red-500  hover:bg-red-700 py-3 px-8 text-center text-base font-semibold text-yellow-300 outline-none">
        Submit
      </button>
    </div>
  </form>
</div>
<%@ include file="./footer.jsp" %>

