//学习在统计语句中使用select函数
//而且可以同时使用多个统计函数：min(abs())
# Write your MySQL query statement below
select min(abs(P1.x - P2.x)) shortest
from point P1, point P2
where P1.x <> P2.x;