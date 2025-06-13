function solution(n) {
    let answer = n.toString().split('').reverse();
    answer = answer.map(x => Number(x));
    return answer;
}