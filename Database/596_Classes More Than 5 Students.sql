//也是很经典，很基础的题
//注意题目的要求：The students should not be counted duplicate in each course.
//因为有上面的要求，count里面要用distinct
# Write your MySQL query statement below
select class
from courses
group by class
having count(distinct student) >= 5;