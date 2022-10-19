<html>
<body>
<table border="1">
    <tbody>
    <#list data as item>
        <tr>
            <td>${item.name}</td> <#-- getter, not field! -->
            <td>${item.age}</td>
            <td>${item.group}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
