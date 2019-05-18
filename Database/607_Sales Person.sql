//也是一个很经典的连接的问题
//要查询not have，所以要用not in
# Write your MySQL query statement below

//下面的方法用到了一个嵌套子查询
select salesperson.name
from salesperson
where salesperson.sales_id not in(
    select orders.sales_id
    from orders, company
    where orders.com_id = company.com_id and company.name = 'RED'

)
