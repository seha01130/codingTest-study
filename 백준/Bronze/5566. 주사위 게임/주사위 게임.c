#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int num, mum, i, count = 0;
	int me = 1;
	int* n;
	int* m;

	scanf("%d %d", &num, &mum);
	n = (int*)malloc(sizeof(int) * (num + 1));
	m = (int*)malloc(sizeof(int) * (mum + 1)); // + 1을 해야하나?

	for (i = 1; i <= num; i++) 
		scanf("%d", &n[i]);
	for (i = 1; i <= mum; i++) 
		scanf("%d", &m[i]);
	
	for (i = 1; me < num; i++) {
		me += m[i];
		me += n[me];
		count++;
	}
	printf("%d\n", count);
}