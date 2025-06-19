function solution(arr) {
    if (arr.length === 1){
        return [-1];
    }
    
//     1.    
//     let minIdx = arr.reduce((minIndex, cur, index, arr) => {
//         return cur < arr[minIndex] ? index : minIndex;
//     }, 0);
//     console.log(minIdx);
    
//     arr.splice(minIdx, 1);
//     return arr;
    
//     2. 
//     let min = Math.min(...arr);
//     let minIndex = arr.indexOf(min);
//     console.log(minIndex);
    
//     arr.splice(minIndex, 1);
//     return arr;
 
//     3. 
    let min = Math.min(...arr);
    let answer = arr.filter(e => e !== min);
    
    return answer;
}