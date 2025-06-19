function solution(left, right) {
    let result = 0;
    for(let i = left; i <= right; i++){
        numOfDiv(i) === true ? result += i : result -= i;
    }
    return result;
}

function numOfDiv(n) {
    let count = 1;
    for (let i = 2; i <= n ; i++) {
        if (n % i === 0){
            count++;
        }
    }
    if (count % 2 === 0) {
        return true;
    } else {
        return false;
    }
}