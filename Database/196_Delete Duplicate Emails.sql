# Write your MySQL query statement below
//注意理解delete这个操作
//delte p1.*表明第对p1这个表进行操作，其他的逻辑和select是一样的
//这也是一个经典的题目，去除重复的元组
//?这个还是要再理解一下
DELETE p1.*
FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND
p1.Id > p2.Id