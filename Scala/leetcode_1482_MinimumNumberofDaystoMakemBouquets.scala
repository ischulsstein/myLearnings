object Solution {
    def minDays(bloomDay: Array[Int], m: Int, k: Int): Int = {
        var boundryConst = 0
        if (m*k> bloomDay.length || m> bloomDay.length || k> bloomDay.length) {
            boundryConst= -1
            boundryConst
        } else {
            def boquets (days: Int): Boolean = {
                var flowers = 0
                var runs = 0
                var retTr = false
                var retFal = true
                for (d <- bloomDay) {
                    if  (d <= days) {
                        flowers += 1
                    } else {
                        flowers=0
                    }
                    if (flowers >= k) {
                        runs += 1
                        flowers = 0
                    }
                }
                runs >= m
            }
            var low = 1
            var high = bloomDay.max

            while (low<high) {
                var mid: Int = (high + low)/2

                if (boquets(mid)){
                    high= mid
                } else {
                    low = mid + 1
                }
            }
            low
        }
    }
}