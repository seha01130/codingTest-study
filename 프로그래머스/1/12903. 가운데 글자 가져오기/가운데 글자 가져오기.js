function solution(s) {
    let len = s.length;
    let startIdx = Math.floor(len/2);
    return len % 2 === 0 ? s.slice(startIdx-1, startIdx+1) : s.slice(startIdx, startIdx+1);
}