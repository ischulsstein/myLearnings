class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        def canPlaceBalls(x, positions, m):
            prevPos=positions[0]
            balls = 1
            for p in positions[1:]:
                if p - prevPos >= x: 
                    balls += 1
                    prevPos = p
                if balls == m:
                    return True
            return False
        
        position.sort()
        low = 1
        n = len(position)
        high = math.ceil(position[n-1]/ (m-1))
        answer = 0

        while (low <= high):
            mid = int((low + high)// 2)
            if canPlaceBalls(mid, position, m):
                low = mid + 1
                answer = mid
            else:
                high = mid - 1
        
        return answer

        
        