function solution(s){
    let countP = s.split(/[pP]/).length - 1;
    let countY = s.split(/[yY]/).length - 1;
    
    console.log(countP);
    console.log(countY);
    
    return countP === countY ? true : false;
}