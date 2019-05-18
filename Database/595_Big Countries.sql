//v1
//思路：在WHERE子句中，可以使用NOT、AND与OR这三个逻辑运算符构造出复杂的查询条件，称之为布尔表达式
//在WHERE子句中，可以使用NOT、AND与OR这三个逻辑运算符构造出复杂的查询条件，称之为布尔表达式

SELECT
    name, population, area
FROM
    world
WHERE
    area > 3000000 OR population > 25000000
;

//v2
//子查询之间的并、交、差运算
//union, intersect, except
SELECT
    name, population, area
FROM
    world
WHERE
    area > 3000000

UNION

SELECT
    name, population, area
FROM
    world
WHERE
    population > 25000000
;