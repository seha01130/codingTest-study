function solution(n) {
    let str = n.toString();
    let arr = [...str];
    console.log(arr);
    arr.sort((a,b) => b - a);
    let answer = arr.join('');
    
    return Number(answer);
}