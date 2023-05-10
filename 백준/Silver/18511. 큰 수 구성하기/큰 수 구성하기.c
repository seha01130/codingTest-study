#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int max = 0;

int pick(int* items, int itemSize, int* bucket, int bucketSize, int k, int n)
{
	int i, lastIndex, smallest, itemIndex, sum;
	int flag = 0;

	if (k == 0) {
		sum = 0;
		for (i = 0; i < bucketSize; i++) {
			sum *= 10;
			sum += items[bucket[i]];
		}
		//printf("%d\n", sum);
		if (sum > n)
			return -1;
		if (sum <= n)
			if (sum >= max)
				max = sum;
		return 0;
	}

	lastIndex = bucketSize - k - 1;

	//if (bucketSize == k)
		smallest = 0;
	//else
		//smallest = bucket[lastIndex];

	for (itemIndex = smallest; itemIndex < itemSize; itemIndex++) {
		bucket[lastIndex + 1] = itemIndex;
		flag = pick(items, itemSize, bucket, bucketSize, k - 1, n);
		if (flag == -1)
			break;
	}
	return 0;
}

int main(void)
{
	int n, itemSize, i, bucketSize = 0;
	int itemMax = 0, semiMax = 0;
	int* bucket;
	int* items;

	scanf("%d %d", &n, &itemSize);

	int nn = n;
	while (nn != 0) {
		nn /= 10;
		bucketSize++;
	}

	bucket = (int*)malloc(sizeof(int) * bucketSize);
	items = (int*)malloc(sizeof(int) * itemSize);
	for (i = 0; i < itemSize; i++) {
		scanf("%d", &items[i]);
		if (items[i] > itemMax)
			itemMax = items[i];
	}

	for (i = 0; i < bucketSize - 1; i++) {
		semiMax *= 10;
		semiMax += itemMax;
	}
	pick(items, itemSize, bucket, bucketSize, bucketSize, n);

	printf("%d\n", (max < semiMax) ? semiMax : max);
}