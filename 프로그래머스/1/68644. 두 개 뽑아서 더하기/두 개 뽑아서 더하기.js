function solution(numbers) {
    let arr = [];
    
    for (let i = 0; i < numbers.length - 1; i++){
        for (let j = i + 1; j < numbers.length; j++){
            let num = numbers[i] + numbers[j];
            if (!arr.includes(num)){
                arr.push(num);
            }
        }
    }
    
    arr.sort((a, b) => a - b);
    return arr;
}