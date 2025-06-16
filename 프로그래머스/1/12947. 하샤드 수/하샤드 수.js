function solution(x) {
    let sumOfDigits = [...x.toString()].reduce((acc, cur) => acc + Number(cur), 0);
    console.log(sumOfDigits);
    
    return (x % sumOfDigits) === 0 ? true : false;
}