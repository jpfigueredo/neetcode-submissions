class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false; 
        }

        Map<Character, Integer> sMap = new HashMap();
        Map<Character, Integer> tMap = new HashMap();
        
        for(Character c: s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for(Character c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if(sMap.size() != tMap.size()){
            return false;
        }

        /*
        Input: s = "racecar", t = "carrace"

        sMap = [[r,2],[a,2],[c,2],[e,1]]
        tMap = [[c,2],[a,2],[r,2],[e,1]]

        */
        for(Character key : sMap.keySet()){
            if(!sMap.get(key).equals(tMap.get(key))){
                return false;
            }
        }
        return true;
    }
}