#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<ctype.h>

int main(void)
{
    char str[1000001];
    int alphaCnt[26] = { 0 };
    char answer;
    int i, big = 0;

    scanf("%s", str);

    //소문자를 대문자로 변환
    for (i = 0; str[i] != '\0'; i++)
        alphaCnt[toupper(str[i])- 65]++;
    //65대신 'A'써도 됨

    for (i = 0; i < 26; i++) {
        if (alphaCnt[i] > big) {
            big = alphaCnt[i];
            answer = i + 65;
        }
        else if (alphaCnt[i] == big) //중복발견
            answer = '?';
    }
    printf("%c", answer);
}