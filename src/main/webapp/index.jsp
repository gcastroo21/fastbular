<html>
<body>
<h2>Create Uni</h2>

<form action="/create-uni" method="post">

    <label>University Name</label>
    <input type="text" name="uni-name" id="uni-name" value="${param.name}">
    <input type="hidden" id="id" name="id" value="${param.id}">


    <button type="submit">Register</button>

</form>

</body>
</html>
