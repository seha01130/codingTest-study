#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int a, b, i, count, newA = 0, newB = 0;
	char aList[3], bList[3];

	scanf("%d", &a);
	scanf("%d", &b);

	for (i = 0; i < 3; i++) {
		aList[i] = a % 10;
		a /= 10;
	}
	for (i = 0; i < 3; i++) {
		bList[i] = b % 10;
		b /= 10;
	}

	count = 1;
	for (i =2; i >= 0; i--) {
		newA += aList[i] * count;
		count *= 10;
	}
	count = 1;
	for (i = 2; i >= 0; i--) {
		newB += bList[i] * count;
		count *= 10;
	}

	if (newA > newB)
		printf("%d\n", newA);
	else
		printf("%d\n", newB);
}
