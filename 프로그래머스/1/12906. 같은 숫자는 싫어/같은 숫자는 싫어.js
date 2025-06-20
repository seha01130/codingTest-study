function solution(arr)
{
    var answer = [];
    
    // for (let i = 0; i < arr.length; i++){
    //     if (arr[i] !== arr[i - 1]){
    //         answer.push(arr[i]);
    //     }
    // }
        
    // return answer;
    
    return arr.filter((e, i) => e !== arr[i - 1]);
}