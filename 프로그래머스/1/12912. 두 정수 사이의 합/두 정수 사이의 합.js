function solution(a, b) {
    let s;
    let e;
    if (a >= b) {
        s = b;
        e = a;
    } else {
        s = a;
        e = b;
    }
    
    let sum = 0;
    for (let i = s; i <= e; i++){
        sum += i;
    }
    return sum;
}