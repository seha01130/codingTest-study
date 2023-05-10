#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int putNum(int* p, int num)
{
    int i;
    for (i = 0; num > 0; i++){
        *p++ = num % 10;
        num /= 10;
    }
    return i;
}
int IsEqualDifference(int array[], int size)
{
    int i, j = 0;
    int a[size - 1];//숫자의 차이를 넣음
    //size - 1인 이유 배열이 3개면 계산은 2번
    
    if (size < 3)//두자리수까지는 모든 수가 등차수열
        return 1;
    
    for (i = 0; i < size - 1; i++)
        a[j++] = array[i] - array[i + 1];
    for (i = 0; i < size - 2; i++)
        if (a[i] != a[i + 1])
            return 0;
    return 1;
}
int main(void)
{
    int n[3];
    int i, num, arrayNum, total = 0;
    
    //printf("1000보다 작거나 같은 자연수 입력: ");
    scanf("%d", &num);
    for (i = 1; i <= num; i++) {
        arrayNum = putNum(&n, i);
        if (IsEqualDifference(n, arrayNum)) //true면
            total++;
    }
    printf("%d", total);
}