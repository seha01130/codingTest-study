M, N = map(int, input().split())

for n in range(M,N+1):
        have = 0
        if n > 1:
            for i in range(2, int(n**0.5)+1):
                if n % i == 0:
                    have += 1
                    break
            if have == 0:
                print(n)