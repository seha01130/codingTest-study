import sys

num = sys.stdin.readline().strip() #153 1~9(9번) 10~99(90번) 100~153(주어진수 - 100 + 1)
numLen = int(len(num)) #3
sum = 0

for i in range(1, numLen + 1): 
    if i < numLen:
        sum += (10**(i-1)) * 9 * i
        #print(sum)
    else: 
        sum += (int(num) - (10**(i-1)) + 1) * i
        print(sum)