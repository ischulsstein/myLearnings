class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        num=str(x)
        n=len(num)
        for i in range(0,int(n/2)+1):
            if num[i]!=num[n-i-1]:
                return False
        return True
        