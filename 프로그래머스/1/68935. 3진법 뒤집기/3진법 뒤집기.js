function solution(n) {
    // console.log([...n.toString(3)].reverse().join(''));
    return parseInt([...n.toString(3)].reverse().join(''), 3);
}