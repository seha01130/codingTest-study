#include<stdio.h>

int main()
{
    int i, sec = 0;
    char str[15];
    
    scanf("%s", str);
    
    for (i = 0; i <= str[i] != '\0'; i++){
        if ('A' <= str[i] && str[i] <= 'C')
            sec += 3;
        else if ('D' <= str[i] && str[i] <= 'F')
            sec += 4;
        else if ('G' <= str[i] && str[i] <= 'I')
            sec += 5;
        else if ('J' <= str[i] && str[i] <= 'L')
            sec += 6;
        else if ('M' <= str[i] && str[i] <= 'O')
            sec += 7;
        else if ('P' <= str[i] && str[i] <= 'S')
            sec += 8;
        else if ('T' <= str[i] && str[i] <= 'V')
            sec += 9;
        else if ('W' <= str[i] && str[i] <= 'Z')
            sec += 10;
    }
    printf("%d", sec);
}