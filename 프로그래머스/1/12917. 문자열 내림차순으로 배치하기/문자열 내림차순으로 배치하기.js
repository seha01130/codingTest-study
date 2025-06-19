function solution(s) {
    let result = [...s].sort().reverse().join('');
    console.log(result);
    return result;
}