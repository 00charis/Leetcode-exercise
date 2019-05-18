# Write your MySQL query statement below
//这个题目用left join做
//1)既有on，又有where，on描述的是连接的条件
//2)where 描述的是选择的条件
//3)用到了 is null
select name,bonus
from Employee left join Bonus
    on Employee.empId = Bonus.empId 
where bonus < 1000 or bonus is null;