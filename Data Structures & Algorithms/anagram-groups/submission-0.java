class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        List<String> element = new ArrayList();
        if (strs.length == 1) {
            element.add(strs[0]);
            result.add(element);
            return result;
        }

        Map<String, List<String>> map = new HashMap<>(); 

        for(String match: strs){
            char[] charArray = match.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(match);
            
        }
        return new ArrayList<>(map.values());
    }
}
