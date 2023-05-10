#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int main(void)
{
    int num, n, flag = 0, count = 0, n1, n2, sum, connect = 0;
    scanf("%d", &num);
    n = num;
    
    while (flag == 0){
        n1 = num / 10;
        n2 = num % 10;
        sum = n1 + n2;    
        connect = n2 * 10 + sum % 10;
        count++;
        if (n == connect)
            break;
        num = connect;
    }
    printf("%d\n", count);
}