def isPrime(n):
    if n == 1:
        return False
    for i in range(2,n):
        if n % i == 0:
            return False
    return True

num = int(input())
count = 0

numList = list(map(int, input().split()))

for n in numList:
    if isPrime(n) == True:
        count += 1
print(count)