public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
     
     private Map<Integer,Integer> map = new HashMap<>();
     
     
    public void add(int number) {
        // write your code here
        if (map.get(number) == null) {
            map.put(number, 1);
        }else {
            map.put(number, map.get(number) + 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ///返回此映射中包含的映射关系的 Set 视图。.Entry表示映射关系
            if (map.get(value - entry.getKey()) != null) {
                if (value - entry.getKey() == entry.getKey()) {
                        return entry.getValue() > 1;
                    }
                    return true;
            }
        }
        return false;
    }
}