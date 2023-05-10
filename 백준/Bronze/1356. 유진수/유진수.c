#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//문자열은 항상 char로 받는다! 코딩북마크 에 int형 배열에 문자열 담을 수 있음? 봐.
int main(void)
{
	char num[11];
	int length, i, j, k, first, second, flag = 0;

	scanf("%s", num, sizeof(num));
	length = strlen(num);
	//printf("%d\n", length);

	for (i = 0; i < length - 1; i++) { //i = 1부터 시작이 아니라 0부터 시작임.
		first = 1; second = 1;
		for (j = 0; j <= i; j++) {
			first *= (num[j] - '0'); //문자 0 은 숫자로 48이다! 48을 빼도 됨.
		}
		for (k = i + 1; k < length; k++) {
			second *= (num[k] - '0'); //num에는 문자가 들어가있어. 그걸 그냥 곱해버리니까 아스키코드값이 곱해져서 결과가 안나오지.
		}							  //문자를 숫자로 바꿔줘야지!
		if (first == second) {
			flag = 1;
			break;
		}
	}
	if (flag == 1)
		printf("YES\n");
	else
		printf("NO\n");
}