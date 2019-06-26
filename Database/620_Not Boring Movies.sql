-- very basic
# Write your MySQL query statement below
SELECT * FROM cinema AS c
WHERE c.id % 2 = 1 AND c.description != 'boring'
ORDER BY c.rating DESC

