# june03_2025
The problem that i solved today in leetcode

1.You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:

status[i] is 1 if the ith box is open and 0 if the ith box is closed,
candies[i] is the number of candies in the ith box,
keys[i] is a list of the labels of the boxes you can open after opening the ith box.
containedBoxes[i] is a list of the boxes you found inside the ith box.
You are given an integer array initialBoxes that contains the labels of the boxes you initially have. You can take all the candies in any open box and you can use the keys in it to open new boxes and you also can use the boxes you find in it.

Return the maximum number of candies you can get following the rules above.

Code:
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candy=0;
        Queue<Integer> q=new LinkedList<>();
        for(int x:initialBoxes)
            q.add(x);
        while(!q.isEmpty())
        {
            int x=q.poll();
            if(candies[x]==0) continue;
            if(status[x]==1)
            {
                candy+=candies[x];
                candies[x]=0;
            }
            else
            {
                status[x]=-1;
                continue;
            }
            for(int a:keys[x])
            {
                if(status[a]==-1)
                {
                    status[a]=1;
                    q.add(a);
                }
                if(status[a]==0)
                    status[a]=1;
            }
            for(int a:containedBoxes[x])
            {
                if(candies[a]>0)
                    q.add(a);
            }
        }
        return candy;
    }
}
