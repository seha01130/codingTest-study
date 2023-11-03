num = int(input())
input_array = list(map(int, input().split()))

for i in range(num - 1, 0, -1):
    if input_array[i - 1] > input_array[i]:
        for j in range(num - 1, 0, -1):
            if input_array[i - 1] > input_array[j]:
                input_array[i - 1], input_array[j] = input_array[j], input_array[i - 1]
                input_array = input_array[:i] + sorted(input_array[i:],reverse=True)
                print(*input_array)
                exit()
print(-1)