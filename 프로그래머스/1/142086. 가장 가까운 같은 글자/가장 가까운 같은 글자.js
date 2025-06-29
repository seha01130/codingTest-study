/* 처음 나온 알파벳이면 -1을, 아니면 몇 번째 전에 나왔는지를 배열에 저장
Map에다가 [알파벳, 나온 index] 를 갱신해야할듯. 이미 나온적있는지 검사하고 배열에 넣고나서 갱신!
*/

function solution(s) {
    let result = [];
    
    let map = new Map();
    
    [...s].forEach((e, i) => {
        if (map.get(e) !== undefined) {
            result.push(i - map.get(e));
            map.set(e, i);
            console.log("있");
        } else {
            result.push(-1);
            map.set(e, i);
            console.log("없");
        }
    });
    
    return result;
}