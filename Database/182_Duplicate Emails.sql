//自己写的
//注意：要给表换名，要加distinct
# Write your MySQL query statement below
select distinct Person1.Email
from Person Person1, Person Person2
where Person1.Email = Person2.Email and Person1.Id <> Person2.Id