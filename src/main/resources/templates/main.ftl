<!DOCTYPE html>
<html lang="en">
<head>
    <title>ICI</title>
    <meta charset="UTF-8">
</head>
<body>

    <div>
        <form method="post">
            <div><input type="text" name="inn" placeholder="ИНН - 10 цифр"/></div>
            <div><input type="text" name="ogrn" placeholder="ОГРН - 13 цифр"/></div>
            <div><input type="text" name="name" placeholder="Наименование"/></div>
            <div><input type="text" name="city" placeholder="Город"/></div>
            <div><input type="text" name="street" placeholder="Улица"/></div>
            <div><input type="text" name="building" placeholder="Дом"/></div>
            <button type="submit">Добавить организацию</button>
        </form>
    </div>
    <div>
        <div>Фильтр</div>
        <form method="post" action="search">
            <div><input type="text" name="inn" placeholder="ИНН - 10 цифр"></div>
            <div><input type="text" name="ogrn" placeholder="ОГРН - 13 цифр" /></div>
            <div>По наименованию и адресу</div>
            <div><input type="text" name="name" placeholder="Наименование" /></div>
            <div><input type="text" name="city" placeholder="Город" /></div>
            <div><input type="text" name="street" placeholder="Улица"/></div>
            <div><input type="text" name="building" placeholder="Дом" /></div>
            <button type="submit">Найти хоть что-нибудь</button>
        </form>
    </div>
    <div>Информация о страховых организациях</div>
    <table border="1">
        <thead>
        <tr>
            <th>ИНН</th>
            <th>ОРГН</th>
            <th>Наименование</th>
            <th>Адрес</th>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <#list companies as company>
            <tr>
                <td>${company.inn}</td>
                <td>${company.ogrn}</td>
                <td>${company.name}</td>
                <td>${company.city}, ${company.street} ${company.building}</td>
                <td>
                    <form method="post" action="delete">
                        <button type="submit" name="id" value="${company.id}">Удалить</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</body>
</html>