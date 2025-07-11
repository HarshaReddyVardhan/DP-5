// Using recursion and memo table



class Solution {
    HashSet<String> set;
    HashMap<Integer , Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.map = new HashMap<>();
        return helper(s,0);
    }

    private boolean helper(String s, int pivot){
        // base
        if(pivot == s.length()) return true;
        // memo table
        if(map.containsKey(pivot))
            return map.get(pivot);
        // logic
        for(int i=pivot;i<s.length();++i){
            String substr = s.substring(pivot,i+1);
            if(set.contains(substr) && helper(s,i+1)){
                map.put(pivot , true);
                return true;
            }
        }
        map.put(pivot,false);
        return false;
    }
}
