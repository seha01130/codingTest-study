def dfs(depth, index):
    if depth == 6:
        print(*result)
        return
    
    for i in range(index, k):
        result.append(S[i])
        dfs(depth+1, i+1)
        result.pop()

while True:
    elements = list(map(int, input().split()))
    k = elements[0]
    S = elements[1:]
    if k == 0:
        exit()
    result = []
    dfs(0, 0)
    print()