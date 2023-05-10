#include<stdio.h>
//
int d(int n)
{
    int sum = n;
    while (n > 0){
       sum += n % 10;
       n /= 10;
    }
    return sum; //sum이 곧 본래수에 각자리수 더한 수
}
int main(void)
{
    int num[10035] = {0}; //나올수있는가장큰수가 d(9999)=10035;
    int i;        //전부 0으로 초기화
    
    for (i = 1; i <= 10000; i++)
        num[d(i)]++;//셀프넘버가 아닌 수를 인덱스로 갖고있는 배열을 ++
                    //셀프넘버는 그대로 0.
    for (i = 1; i <= 10000; i++)
        if (num[i] == 0) //셀프넘버면
            printf("%d\n", i);
}