function solution(t, p) {
    let len = p.length;
    let count = 0;
    
    for (let i = 0; i <= t.length - len; i++){
        let piece = [...t].slice(i, i + len).join('');
        if (Number.parseInt(piece) <= Number.parseInt(p)){
            count++;
        }
    }
    return count;
}