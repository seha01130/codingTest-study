#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int n, i, j, k, length, count, score;
	char str[80];
	int* p;

	scanf("%d", &n);
	p = (int*)malloc(sizeof(int) * n);

	for (i = 0; i < n; i++) {
		score = 0;
		scanf("%s", str);
		length = strlen(str);
		for (j = 0; j < length; j++) {
			count = 0;
			if (str[j] == 'O') {
				count++;
				for (k = j - 1; k >= 0; k--) {
					if (str[k] == 'O')
						count++;
					else
						break;
				}
			}
			score += count;
		}
		p[i] = score;
	}
	for (i = 0; i < n; i++)
		printf("%d\n", p[i]);
}