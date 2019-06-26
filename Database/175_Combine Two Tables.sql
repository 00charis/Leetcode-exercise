-- use left join
select p.FirstName, p.LastName, a.City, a.State
from Person AS p left join Address AS a
on p.PersonId = a.PersonId 