//参考solution
//这个题目的意思很清楚了，就是应该应该用左外连接
select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId //on说明了如何连接
;