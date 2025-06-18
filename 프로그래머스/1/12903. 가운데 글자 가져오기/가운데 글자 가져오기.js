function solution(s) {
    let len = s.length;
    let index;
    if (len % 2 === 0){
        index = len / 2 - 1;
        return s[index] + s[index + 1];
    } else {
        index = Math.floor(len / 2);
        return s[index];
    }
}