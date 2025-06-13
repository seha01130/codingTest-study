function solution(n)
{
    let str = n.toString();
    let arr = str.split('');
    let arr2 = arr.map(x => x*1);
    
    console.log(arr);
    
    let answer = arr2.reduce((acc, cur) => acc + cur, 0);
    // let answer = arr.reduce((acc, cur) => acc + Number(cur), 0);
    
    return answer;
}