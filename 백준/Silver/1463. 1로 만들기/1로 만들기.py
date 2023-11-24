X = int(input())
count = [0 for i in range(X+1)]  # 각 인덱스에 1을 만들기위한 연산 횟수를 저장
count[1] = 0 # 1이 1을 만들기 위한 연산 횟수는 0 

for i in range(2, X + 1):
    count[i] = count[i - 1] + 1  # 1빼는 방법!! 바로 그 전 수의 횟수에 +1만 해주면 됨

    if i % 3 == 0:
        count[i] = min(count[i], count[i // 3] + 1)  # 1빼는 방법과, 3으로 나누는 방법 중 더 적은 횟수. i가 6이라면 i가 2일때의 횟수 +1
    if i % 2 == 0:
        count[i] = min(count[i], count[i // 2] + 1)  # 1빼는 방법과, 2로 나누는 방법 중 더 적은 횟수

print(count[X])