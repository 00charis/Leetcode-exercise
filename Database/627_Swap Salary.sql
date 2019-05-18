//学习一个新的语法：
//update set case when else end
# Write your MySQL query statement below
update salary
set sex = 
    case sex
    when 'm' then 'f'
    else 'm'
    end