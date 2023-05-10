#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int Rev(int a)
{
	int reverse = 0;
	while (a != 0) {
		reverse *= 10;
		reverse += a % 10;
		a /= 10;
	}
	return reverse;
}

int main(void)
{
	int x, y, reverseSum;

	scanf("%d %d", &x, &y);
	reverseSum = Rev(x) + Rev(y);
	printf("%d\n", Rev(reverseSum));
}