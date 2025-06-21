function solution(number) {
    var answer = 0;

    answer = pickThree(number, Array(3).fill(0), 0, 0, 0);
    
    return answer;
}

function pickThree(number, bucket, idx, bucketIdx, count){
    if (bucketIdx === 3){
        console.log(bucket);
        let sum = 0;
        for (let i = 0; i < 3; i++){
            sum += bucket[i];
        }
        if (sum === 0){
            console.log('찾았다');
            return count + 1;
        } else {
            return count;
        }
    }
    
    for (let i = idx; i < number.length; i++){
        bucket[bucketIdx] = number[i];
        count = pickThree(number, bucket, i + 1, bucketIdx + 1, count);
    }
    return count;
}