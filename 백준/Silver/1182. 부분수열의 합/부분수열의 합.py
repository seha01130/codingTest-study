def dfs(depth, index):
    global count
    
    if 0 < depth <= N:
        if sum(result) == S:
            count += 1
        if depth == N:
            return
        
    for i in range(index, N):
        result.append(numList[i])
        dfs(depth+1, i+1)
        result.pop()

N, S = map(int, input().split())
numList = list(map(int, input().split()))
result = []
count = 0
dfs(0, 0)
print(count)