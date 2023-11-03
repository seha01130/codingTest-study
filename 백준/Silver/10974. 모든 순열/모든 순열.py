import sys
sys.setrecursionlimit(100001)

num = int(input())
data = [i for i in range(1, num+1)]
lastList = sorted(data, reverse=True)

def permuFun(list):
    print(*list)
    if list == lastList:
        exit()
    
    for i in range(num-1, 0, -1):
        if list[i - 1] < list[i]:
            for j in range(num - 1, 0, -1):
                if list[i - 1] < list[j]:
                    list[i - 1], list[j] = list[j], list[i - 1]
                    list = list[:i] + sorted(list[i:])
                    permuFun(list)

permuFun(data)