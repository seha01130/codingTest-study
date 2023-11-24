import sys

input = sys.stdin.readline

N = int(input())
start = []
link = []
matrix = []
result = 10000000000
for i in range(N):
    matrix.append(list(map(int, input().split())))

def dfs(depth, index):
    global result

    if depth > N:
        return

    if len(start) == N//2:
        # link.clear()
        s = 0 ; l = 0
        # for i in range(N):
        #     if start.count(i+1) == 0:
        #         link.append(i+1)     
        #차이 구하자
        for i in range(N):
            for j in range(i+1, N):
                if start.count(i+1)==1 and start.count(j+1)==1:
                    s += (matrix[i][j] + matrix[j][i])
                elif start.count(i+1)==0 and start.count(j+1)==0:
                    l += (matrix[i][j] + matrix[j][i])
        sub = abs(s - l) #abs -> 절대값을 반환하는 파이썬 내장 함수
        result = min(result, sub)
        
    for i in range(index, N):
        start.append(i+1)
        dfs(depth+1, i+1)
        start.pop()

dfs(0, 0)
print(result)