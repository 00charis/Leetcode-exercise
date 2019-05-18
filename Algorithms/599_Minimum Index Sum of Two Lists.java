// Time Complexity: 
// O(l1 + l2)

// Space Complexity: Space for HashMap
// O(l1 * x)


class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        
        for(int i = 0; i < list1.length; i++) {
                map1.put(list1[i], i);
        }
        
        List<String> ret = new ArrayList<>();
        int retSum = Integer.MAX_VALUE;
        
        for(int i = 0; i < list2.length; i++) {
                String curr = list2[i];
                if(map1.containsKey(curr)) {
                    if(map1.get(curr) + i == retSum) {
                        ret.add(curr);
                    }
                    
                    if(map1.get(curr) + i < retSum) {
                        retSum = map1.get(curr) + i;
                        ret.clear();
                        ret.add(curr);
                    }
                }
        }
        return  ret.toArray(new String[ret.size()]);
    }
}