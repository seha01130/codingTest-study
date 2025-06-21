function solution(d, budget) {
//     let answer = 0;
    
//     d.sort((a,b) => a - b);
//     for (let i = 0; i < d.length; i++){
//         budget -= d[i];
        
//        if (budget < 0){
//            break;
//        } 
//         answer++;
//     }
    
//     return answer;
    
    // return d.sort((a,b) => a - b).reduce((acc, cur) => {
    //     if (budget - cur >= 0){
    //         budget -= cur;
    //         return acc + 1;
    //     } else {
    //         return acc;
    //     }
    // }, 0);
    
    return d.sort((a,b) => a - b).reduce((acc, cur) => {
        return (budget -= cur) >= 0 ? acc+1 : acc;
    }, 0)
}