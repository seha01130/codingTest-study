function solution(phone_number) {
    let len = phone_number.length;
    
    let answer = [...phone_number].map((e, i) => {
        if (i < len - 4){
            return e = '*';
        } else {
            return e;
        }
    });
    return answer.join('');
}