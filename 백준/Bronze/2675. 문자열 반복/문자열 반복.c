#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int num, i, j, k;
	int* n;
	char str[1000][21];
	char new[1000][166];

	scanf("%d", &num);
	n = (int*)malloc(sizeof(int) * num);
	for (i = 0; i < num; i++)
		scanf("%d %s", &n[i], str[i]);

	for (i = 0; i < num; i++) {
		for (j = 0; str[i][j] != '\0'; j++) {
			for (k = 0; k < n[i]; k++) {
				new[i][n[i] * j + k] = str[i][j];
			}
		}
		new[i][n[i] * j] = '\0';
	}

	for (i = 0; i < num; i++)
		printf("%s\n", new[i]);
}