//在WHERE子句中，可以使用NOT、AND与OR这三个逻辑运算符构造出复杂的查询条件，称之为布尔表达式
//注意，is null 要做单独的判断
# Write your MySQL query statement below
select name
from customer
where referee_id <> 2 or referee_id is null;
