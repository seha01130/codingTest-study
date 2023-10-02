max = 1000000

M = [0 for i in range(max+1)] #누적합 g(x)를 담는 메모
m = [0 for i in range(max+1)] #해당 값의 약수의 합 f(x)를 담는 메모

for i in range(1,max+1):
    j = 1
    while i * j <= max:
        m[i*j] += i
        j += 1
    M[i] = M[i-1] + m[i]

n = int(input())
divList = list()
for i in range(n):
    a = int(input())
    divList.append(a)
for i in divList:
    print(M[i])