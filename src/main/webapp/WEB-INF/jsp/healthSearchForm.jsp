<html>
  <head>
    <title>Search medecine and disease information</title>
    <style>
      body {
        background-color: #ffffff;
      }
      form {
        width: 400px;
        margin: auto;
        margin-top: 250px;
      }
      input {
        padding: 4px 10px;
		border: 2px solid #ccc;
        font-size: 16px;
      }
      .search {
        width: 75%;
      }
      .submit {
        width: 70px;
        background-color: #1c87c9;
        color: #ffffff;
      }
    </style>
  </head>
  <body>
    <form method="post" action="searchMedicine"" >
      <input type="text" name="searchText" class="search" placeholder="You can search by drug name or disease">
      <input type="submit" name="submit" class="submit" value="Search">
    </form>
  </body>
</html>