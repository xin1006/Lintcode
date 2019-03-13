public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return res;
        }
        
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        StringBuilder sb = new StringBuilder();
        helper(digits, map, sb, res);
        return res;
        
    }
    private void helper(String digits, Map<Character, char[]> map, StringBuilder sb, List<String> res) {
            if (digits.length() == sb.length()) {
                res.add(sb.toString());
                return;
            }
            
            for (char c : map.get(digits.charAt(sb.length()))) {
                sb.append(c);
                helper(digits, map, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
}
