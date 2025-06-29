/*  문자열의 각 값을 n 만큼 민걸 리턴하면 된다!
구현
문자열을 순회하면서 우선 아스키값으로 바꾸고 거기에 n을 더해주는데 소문자일때 z인 122 초과하면 26을 빼고,
대문자일때는 Z인 90을 초과하면 26를 뺀다.

*/

function solution(s, n) {
    var answer = '';
    
    return s.split(' ').map((e) => {
        let result = '';
        for (let i = 0; i < e.length; i++) {
            let code = e.charCodeAt(i) + n;
            
            if (e[i] === e[i].toUpperCase() && code > 90){
                code -= 26;
            } else if (e[i] === e[i].toLowerCase() && code > 122){
                code -= 26;
            }
            
            result += String.fromCharCode(code);
        }
        return result;
    }).join(' ');
    
//     for (let i = 0; i < s.length; i++){
//         if (s[i] )
//         let code = s.charCodeAt(i) + n;
//         answer += String.fromCharCode(code);
//     }
//     console.log('Z'.charCodeAt(0));
    
//     return answer;
}