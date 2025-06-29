function solution(s) {
    let arr = s.split(' ');
    console.log(arr);
    for (let i = 0; i < arr.length; i++){
        let word = arr[i];
        let newWord = '';
        console.log(word);
        for (let j = 0; j < word.length; j++){
            if (j % 2 === 0){
                newWord += word[j].toUpperCase();
            } else {
                newWord += word[j].toLowerCase();
            }
        }
        console.log(newWord);
        arr[i] = newWord;
    }
    let answer = arr.join(' ');
    return answer;
}