function solution(numbers) {
    let allSum = 45;
    let sum = numbers.reduce((acc, cur) => acc + cur, 0);
    
    return allSum - sum;
}