function solution(num) {
    let count = 0;
    let flag = 0;
    while (num != 1){
        num % 2 === 0 ? num /= 2 : num = num * 3 + 1;
        console.log(num);
        count++;
        if (count === 500){
            flag = 1;
            break;
        }
    }
    return flag ? -1 : count;
}