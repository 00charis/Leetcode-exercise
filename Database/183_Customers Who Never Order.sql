//使用not in
//参考本科ppt，分层结构查询，where子句中的集合谓词
# Write your MySQL query statement below
select Customers.Name Customers
from Customers 
where Customers.Id not in(
    select CustomerId
    from Orders
);


