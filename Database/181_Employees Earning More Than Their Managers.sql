//这个也是自己写的
//但是要注意看题目的要求：也要给返回的属性换名，属性换名的方法和表换名的方法一样。
# Write your MySQL query statement below
select Employee.Name Employee
from Employee
    inner join Employee Manager
    on Employee.ManagerId = Manager.Id
where Employee.Salary > Manager.Salary;