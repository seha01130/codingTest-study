function solution(left, right) {
    let result = 0;
    for(let i = left; i <= right; i++){
        Number.isInteger(Math.sqrt(i)) === true ? result -= i : result += i;
    }
    return result;
}