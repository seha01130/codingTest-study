#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int n, i, j, k, count = 0;
	char list[100][100];
	int alpha[26] = { 0 };

	scanf("%d", &n);

	for (i = 0; i < n; i++)
		scanf("%s", list[i], sizeof(list[i]));

	for (i = 0; i < n; i++) {
		for (j = 0; list[i][j] != '\0'; j++) {
			if (alpha[list[i][j] - 97] == 0)
				alpha[list[i][j] - 97]++;
			else {
				if (list[i][j] != list[i][j - 1]) { //alpha[list[i][j]] != alpha[list[i][j - 1]] 이렇게 써서 틀렸음.
					count++; //그룹체커가 아닌걸 count  //alpha 인덱스가 아니라 알파벳 자체를 비교해야지.
					break;
				}
			}
		}
		for (k = 0; k < 26; k++)
			alpha[k] = 0;
	}
	printf("%d", n - count);
}