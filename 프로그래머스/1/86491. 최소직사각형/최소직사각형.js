/* 모든 명함 수납 가능한 가로와 세로의 최소 길이의 곱을 구하는 문제
[w, h] 순서로 입력되어있는데 그거에 상관없이 [큰 숫자, 작은 숫자] 순으로 재정렬하고
모든 배열을 순회하면서 [0]중에 가장 큰 숫자 * [1]중에 가장 큰 숫자 가 답이다!
*/

function solution(sizes) {
    // [큰숫자, 작은숫자] 순으로 재정렬
    let sorted = sizes.map(([w, h]) => w < h ? [h, w] : [w, h]);
    
    console.log(sorted);
    // 큰숫자중에가장큰숫자 * 작은숫자중에가장큰숫자
    let max = [0, 0];
    sorted.forEach(([w, h]) => {
        if (max[0] < w){
            max[0] = w;
        }
        if (max[1] < h){
            max[1] = h;
        }
    });
    
    return max[0] * max[1];
}