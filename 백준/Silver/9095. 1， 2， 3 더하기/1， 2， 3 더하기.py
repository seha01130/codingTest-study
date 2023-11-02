import sys

num = int(sys.stdin.readline())
M = [0 for _ in range(12)]
M[1] = 1; M[2] = 2; M[3] = 4
answer = list()

def find(n):
    if M[n] != 0:
        return M[n]
    M[n] = find(n-1) + find(n-2) + find(n-3)
    return M[n]

for i in range(num):
    n = int(sys.stdin.readline())
    M[n] = find(n)
    answer.append(M[n])

for ans in answer:
    print(ans)
