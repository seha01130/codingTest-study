/* 모든 명함 수납 가능한 가로와 세로의 최소 길이의 곱을 구하는 문제
[w, h] 순서로 입력되어있는데 그거에 상관없이 [큰 숫자, 작은 숫자] 순으로 재정렬하고
모든 배열을 순회하면서 [0]중에 가장 큰 숫자 * [1]중에 가장 큰 숫자 가 답이다!
*/

function solution(sizes) {
    // [큰숫자. 작은숫자] 순으로 재정렬
    for (let i = 0; i < sizes.length; i++){
        let pair = sizes[i];
        if (pair[0] < pair[1]){
            let tmp = pair[0];
            pair[0] = pair[1];
            pair[1] = tmp;
        }
    }
    console.log(sizes);
    // 큰숫자중에가장큰숫자 * 작은숫자중에가장큰숫자
    let aBig = 0, bBig = 0;
    for (let [a, b] of sizes){
        if (a > aBig){
            aBig = a;
        }
        if (b > bBig){
            bBig = b;
        }
    }
    return aBig * bBig;
}