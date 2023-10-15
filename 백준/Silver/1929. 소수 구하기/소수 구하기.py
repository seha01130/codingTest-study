M, N = map(int, input().split())
N += 1
arr = [True] * (N)
arr[1] = False

for i in range(2, int(N**0.5)+1):
    if arr[i] == True:
        for j in range(2*i, N, i):
            arr[j] = False

for i in range(M, N):
    if arr[i] == True:
        print(i)