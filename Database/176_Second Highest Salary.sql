//这个其实是一个很经典的题，要查第二大的值
//参考本科的课件：3_2 p86
//注意，不能在where语句中直接使用统计函数，要使用子查询
# Write your MySQL query statement below
select max(Employee1.Salary) SecondHighestSalary
from Employee Employee1
where Employee1.Salary < ALL
    (select max(Employee2.Salary)
     from Employee Employee2)