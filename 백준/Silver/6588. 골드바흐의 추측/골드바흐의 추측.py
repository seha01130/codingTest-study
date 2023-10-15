import sys

def primeList(n):
    list = [True for i in range(n+1)]
    list[0] = False
    list[1] = False

    for i in range(2, int(n**0.5)+1):
        if list[i] == True:
            for j in range(2*i, n+1, i):
                list[j] = False
    #list 1~n까지 소수인 수에만 True가 들어있음

    return list


def goldBach(list, nums):
    for n in nums:
        for firstNum in range(2,n+1):
            if list[firstNum] == True:
                if list[n - firstNum] == True:
                    print("%d = %d + %d" %(n, firstNum, n-firstNum))
                    break
            if firstNum == n+1:
                print("Goldbach's conjecture is wrong.")


nums = []
while(True):
    a = int(sys.stdin.readline())
    if a == 0:
        break
    nums.append(a)

list = primeList(1000000)
goldBach(list, nums)
