#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int fac(int num)
{
    if (num == 0)
        return 1;
    else{
        if (num == 1)
            return 1;
        else
            return num * fac(num - 1);        
    }

}

int main(void)
{
    int num;
    scanf("%d", &num);
    printf("%d", fac(num));
}