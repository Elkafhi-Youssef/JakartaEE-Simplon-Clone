<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 12/11/2022
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String url=application.getInitParameter("url");
%>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="//unpkg.com/alpinejs" defer></script>
    <title>Login Admin</title>
</head>
<body>
<div class="w-screen">

    <section class="h-screen">
        <div class="mx-auto px-6 py-12 h-full w-full max-w-[550px]">
            <div class="flex justify-center flex-col items-center h-full text-gray-800 border border-red-300 bg-red-100 p-5 rounded-md h-[60%]">
                <div class="w-44 border rounded-md">
                    <h1 class=" text-3xl text-red-600  "><img src="<%=url%>admin/assests/simplon.png" class="w-full"></h1>
                </div>
                <div class="w-full mt-10">
                    <form action="<%=url%>AdminServlet" method="post">
                        <!-- Email input -->
                        <div class="mb-6">
                            <input name="email" type="email" placeholder="Enter you email..."
                                   class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-red-600 focus:outline-none" />
                        </div>

                        <!-- Password input -->
                        <div class="mb-6">
                            <input name="password" type="password" placeholder="Enter your password..."
                                   class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" />
                        </div>
                        <input type="hidden" name="action" value="loginAdmin"/>


                        <button type="submit"
                                class="inline-block mt-4 px-7 py-3 bg-red-600 text-white font-medium text-sm leading-snug uppercase rounded shadow-md hover:bg-red-700 hover:shadow-lg focus:bg-red-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-red-800 active:shadow-lg transition duration-150 ease-in-out w-full"
                                data-mdb-ripple="true" data-mdb-ripple-color="light">
                            Login
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
