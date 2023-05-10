#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int pick(int items[], int itemSize, int bucket[], int bucketSize, int k, int m, int max)
{
	int i, smallest, lastIndex, itemIndex, sum = 0;
	if (k == 0) {
		for (i = 0; i < bucketSize; i++)
			sum += items[bucket[i]];
		if (sum <= m && sum > max)
			max = sum;
		return max;
	}
	lastIndex = bucketSize - k - 1;
	if (bucketSize == k)
		smallest = 0;
	else
		smallest = bucket[lastIndex] + 1;
	for (itemIndex = smallest; itemIndex < itemSize; itemIndex++) {
		bucket[lastIndex + 1] = itemIndex;
		max = pick(items, itemSize, bucket, bucketSize, k - 1, m, max);
	}
	return max;
}

int main(void)
{
	int n, m, i,max; //n은 카드의 갯수 m은 숫자
	int* items;
	int bucket[3];
	int itemSize, bucketSize;

	scanf("%d %d", &n, &m);
	items = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &items[i]);
	itemSize = n;
	bucketSize = 3;

	max = pick(items, itemSize, bucket, bucketSize, bucketSize, m, 0);
	printf("%d\n", max);
	return 0;
}