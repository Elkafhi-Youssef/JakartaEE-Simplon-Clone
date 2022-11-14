<aside class="w-64 flex-2 min-h-screen bg-red-200" aria-label="Sidebar">
  <div class="overflow-y-auto py-3 px-3 bg-red-200 rounded dark:bg-gray-800">
    <a href="#" class="flex items-center mb-5 mr-10 h-16 justify-center  rounded-md drop-shadow-md">
      <div class="w-24">
        <img src="<%=url%>admin/assests/simplon.png" class="w-full">
      </div>
    </a>
    <ul class="space-y-2">
      <li>
        <a href="<%=url%>DashboardServlet" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg aria-hidden="true" class="w-6 h-6 text-blue-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z"></path><path d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z"></path></svg>
          <span class="ml-3">Dashboard</span>
        </a>
      </li>
      <li>
        <a href="<%=url%>PromoServlet/Promos" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="M4.26 10.147a60.436 60.436 0 00-.491 6.347A48.627 48.627 0 0112 20.904a48.627 48.627 0 018.232-4.41 60.46 60.46 0 00-.491-6.347m-15.482 0a50.57 50.57 0 00-2.658-.813A59.905 59.905 0 0112 3.493a59.902 59.902 0 0110.399 5.84c-.896.248-1.783.52-2.658.814m-15.482 0A50.697 50.697 0 0112 13.489a50.702 50.702 0 017.74-3.342M6.75 15a.75.75 0 100-1.5.75.75 0 000 1.5zm0 0v-3.675A55.378 55.378 0 0112 8.443m-7.007 11.55A5.981 5.981 0 006.75 15.75v-1.5" />
          </svg>

          <span class="flex-1 ml-3 whitespace-nowrap">Promos</span>
        </a>
      </li>
      <li>
        <a href="<%=url%>TrainerServlet/Trainers" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="M15 19.128a9.38 9.38 0 002.625.372 9.337 9.337 0 004.121-.952 4.125 4.125 0 00-7.533-2.493M15 19.128v-.003c0-1.113-.285-2.16-.786-3.07M15 19.128v.106A12.318 12.318 0 018.624 21c-2.331 0-4.512-.645-6.374-1.766l-.001-.109a6.375 6.375 0 0111.964-3.07M12 6.375a3.375 3.375 0 11-6.75 0 3.375 3.375 0 016.75 0zm8.25 2.25a2.625 2.625 0 11-5.25 0 2.625 2.625 0 015.25 0z" />
          </svg>
          <span class="flex-1 ml-3 whitespace-nowrap">Trainers</span>
        </a>
      </li>
      <li>
        <a href="<%=url%>PromoServlet/AddPromo" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg xmlns="http://www.w3.org/2000/svg" class="flex-shrink-0 w-6 h-6 text-blue-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.2.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zM200 344V280H136c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V168c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H248v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z"/></svg>
          <span class="flex-1 ml-3 whitespace-nowrap">Add promo</span>
        </a>
      </li>
      <li>
        <a href="<%=url+"StudentServlet"%>" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg width="25" class="flex-shrink-0 w-6 h-6 text-blue-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512"><!--! Font Awesome Pro 6.2.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M352 128c0 70.7-57.3 128-128 128s-128-57.3-128-128S153.3 0 224 0s128 57.3 128 128zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3zM504 312V248H440c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V136c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H552v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z"/></svg>
          <span class="flex-1 ml-3 whitespace-nowrap">Add Student</span>
        </a>
      </li>
      <li>
        <a href="<%=url%>TrainerServlet/AddTrainer" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg width="25" class="flex-shrink-0 w-6 h-6 text-blue-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512"><!--! Font Awesome Pro 6.2.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M352 128c0 70.7-57.3 128-128 128s-128-57.3-128-128S153.3 0 224 0s128 57.3 128 128zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3zM504 312V248H440c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V136c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H552v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z"/></svg>
          <span class="flex-1 ml-3 whitespace-nowrap">Add Trainer</span>
        </a>
      </li>
      <li>
        <a href="<%=url%>TrainerServlet/AssignTrainer" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg width="25" class="flex-shrink-0 w-6 h-6 text-blue-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512"><!--! Font Awesome Pro 6.2.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M352 128c0 70.7-57.3 128-128 128s-128-57.3-128-128S153.3 0 224 0s128 57.3 128 128zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3zM504 312V248H440c-13.3 0-24-10.7-24-24s10.7-24 24-24h64V136c0-13.3 10.7-24 24-24s24 10.7 24 24v64h64c13.3 0 24 10.7 24 24s-10.7 24-24 24H552v64c0 13.3-10.7 24-24 24s-24-10.7-24-24z"/></svg>
          <span class="flex-1 ml-3 whitespace-nowrap">Assign Trainer</span>
        </a>
      </li>
      <li>
          <a href="<%=url%>LogoutServlet" class="flex items-center p-2 text-base font-normal text-blue-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
          <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-blue-900 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z" clip-rule="evenodd"></path></svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Log out</span>
          </a>
      </li>
    </ul>
  </div>
</aside>