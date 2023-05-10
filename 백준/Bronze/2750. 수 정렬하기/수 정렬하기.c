#include<stdio.h>

int main(void)
{
    int i, j, size, minIndex, tmp;
    int n[1000];
    
    scanf("%d", &size);
    for (i = 0; i < size; i++)
        scanf("%d", &n[i]);
        
    for (i = 0; i < size - 1; i++){
        minIndex = i;
        for (j = i + 1; j < size; j++)
            if (n[j] < n[minIndex])
                minIndex = j;
        tmp = n[i];
        n[i] = n[minIndex];
        n[minIndex] = tmp;
    }
    
    for (i = 0; i < size; i++)
        printf("%d\n", n[i]);
}