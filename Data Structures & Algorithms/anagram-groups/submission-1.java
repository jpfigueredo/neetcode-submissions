class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); 
        if (strs.length == 1) {
            List<List<String>> result = new ArrayList();
            List<String> element = new ArrayList();
            element.add(strs[0]);
            result.add(element);
            return result;
        }

        for(String match: strs){
            char[] charArray = match.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(match);
            
        }
        return new ArrayList<>(map.values());
    }
}
