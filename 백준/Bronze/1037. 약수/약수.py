n = int(input())
divList = list(map(int, input().split()))
divList.sort()
#print(divList)

if n == 1:
    print(divList[0]**2)
else:
    print(divList[0]*divList[n-1])