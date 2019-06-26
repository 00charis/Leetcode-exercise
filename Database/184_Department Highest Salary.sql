-- use dense_rank() function
SELECT d1.Name AS Department,
e1.Name AS Employee,
e1.Salary
 FROM (
SELECT e.Name, 
e.Salary,
e.DepartmentID,
DENSE_RANK() OVER (PARTITION BY e.DepartmentID ORDER BY Salary DESC) AS s_rank
FROM Employee AS e ) AS e1 JOIN Department AS d1
ON e1.DepartmentID = d1.ID
WHERE e1.s_rank = 1

