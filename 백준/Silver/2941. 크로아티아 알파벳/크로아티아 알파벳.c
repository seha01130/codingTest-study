#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int main(void)
{
    char str[101];
    int length, i = 0;

    scanf("%s", str);

    length = strlen(str);

    for (i = 0; str[i] != '\0'; i++) {
        if (str[i] == 'j' && (str[i - 1] == 'l' || str[i - 1] == 'n'))
            length--;
        if (str[i] == '=' && str[i - 1] == 'z' && str[i - 2] == 'd')
            length --;
        if (str[i] == '=' || str[i] == '-')
            length--;
    }

    printf("%d", length);
}