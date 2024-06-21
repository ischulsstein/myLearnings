object Solution {
    def maxDistance(position: Array[Int], m: Int): Int = {
        var sortedPos = position.sorted
        var low: Int = 1
        val n: Int= sortedPos.length
        var high: Int = (sortedPos(n-1) - sortedPos(0))/ (m-1)
        var answer: Int = 0

        while (low <= high) {
            var mid: Int = low + (high - low)/2
            if (canPlaceBalls(mid, sortedPos, m)){
                answer = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        answer
    }
    def canPlaceBalls(x: Int, positions: Array[Int], m: Int): Boolean = {
        var ballsPlaced: Int = 1
        var prevBall: Int = positions(0)

        for (p <- 1 until positions.length){
            if ((positions(p) - prevBall) >= x) {
                ballsPlaced += 1
                prevBall = positions(p)
            }
        }
        ballsPlaced >= m
    }
}