#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int main(void)
{
    int A, B, C;
    int cnt;

    scanf("%d %d %d", &A, &B, &C);

    if (B >= C)
        cnt = -1;
    else
        cnt = (A / (C - B)) + 1;

        printf("%d", cnt);
}