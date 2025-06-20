function solution(n, m) {
    var answer = [0, n * m];
    
    //n이 큰수, m이 작은수라고 임의로 결정. -> 상관없음
    let tmp; //나머지 담는 곳
    while (m !== 0){
        tmp = n % m;
        n = m;
        m = tmp;
    }
    let gcd = n;
    // console.log(n);
    
    answer.splice(0, 1, gcd);
    answer.splice(1, 1, answer[1]/gcd);
    console.log(answer);
    
    return answer;
}