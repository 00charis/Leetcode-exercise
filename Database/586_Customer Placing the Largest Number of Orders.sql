//In MySQL, the LIMIT clause can be used to constrain the number of rows returned by the SELECT statement.
//这个题目也是很基础的，用到了关键词limit
# Write your MySQL query statement below
select customer_number
from orders
group by customer_number
order by count(*) desc
limit 1;