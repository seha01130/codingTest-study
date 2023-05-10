#include<stdio.h>

int main(void)
{
    char str[1000001];
    char delimiters[] = " ";
    int count = 0;
    char *token;

    gets(str);

    token = strtok(str, delimiters);
    while (token != NULL) {
        count++;
        token = strtok(NULL, delimiters);
    }
    printf("%d", count);
}