function solution(n) {
    let sqrtN = Math.sqrt(n);
    return sqrtN === Math.floor(sqrtN) ? Math.pow(sqrtN+1, 2) : -1;
}