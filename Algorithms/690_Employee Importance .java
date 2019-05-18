//看题目的要求：One employee has at most one direct leader and may have several subordinates. 这是一个树形结构
//下面是dfs的做法，有点像求subtree sum

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    Map<Integer, Employee> map;//这个map的索引结构非常重要，通过id找到对象
	public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee employee: employees) {
        		map.put(employee.id, employee);
        }
        return dfs(id);
    }
	
	private int dfs(int id) {
		Employee curr = map.get(id);
		int ret = curr.importance;
		for(int sub : curr.subordinates) {
			ret += dfs(sub);
		}
		return ret;
	}
}