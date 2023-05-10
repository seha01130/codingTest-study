#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int pibo(int num)
{
    
    if (num > 2)
        return pibo(num - 2) + pibo(num - 1);
    else {
        if (num == 0)
            return 0;
        else if (num == 1 || num == 2)
            return 1;
    }
}

int main(void)
{
    int num;
    scanf("%d", &num);

    printf("%d", pibo(num));
}