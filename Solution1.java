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