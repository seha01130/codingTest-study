array = []
for i in range(9):
    array.append(int(input()))

array.sort()
sum = sum(array)

for i in range(len(array)):
    for j in range(i+1, len(array)):
        if sum - array[i] - array[j] == 100:
            for k in range(len(array)):
                if k == i or k == j:
                    pass
                else:
                    print(array[k])
            exit()