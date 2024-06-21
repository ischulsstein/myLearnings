class Solution {
    public Boolean canPlaceBalls(int x, int[] positions, int m){
        int ballsPlaced=1;
        int prevBallPos = positions[0];
        for(int i=0;i<positions.length && ballsPlaced <= m;i++)
        {
            if(positions[i]-prevBallPos>=x)
            {
                ballsPlaced++;
                prevBallPos = positions[i];
            }
            if(ballsPlaced>=m)
            {
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int n = position.length;
        int high = (position[n-1]-position[0])/(m-1);
        int answer = 1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(canPlaceBalls(mid, position, m))
            {
                answer = mid;
                low=mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return answer;
    }
}