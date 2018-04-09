Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.



class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer>[] Bucket = new List[nums.length+1];
        
        for(int x:nums)
        {
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        for(int key:hm.keySet())
        {
            int freq = hm.get(key);
            if(Bucket[freq] == null) {
                Bucket[freq]= new ArrayList<>();
            }
            Bucket[freq].add(key);
        }
        
        for(int pos= Bucket.length-1; pos>0 && res.size()<k;pos--)
        {
            if(Bucket[pos]!=null)
            res.addAll(Bucket[pos]);
        }
        return res.subList(0,k);
    }
}
