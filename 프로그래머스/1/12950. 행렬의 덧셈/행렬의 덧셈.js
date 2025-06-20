function solution(arr1, arr2) {
    let row = arr1.length;
    let col = arr1[0].length;
    let result = Array.from(Array(row), () => Array(col));
    for (let i = 0; i < row; i++)  {
        for (let j = 0; j < col; j++) {
            result[i][j] = (arr1[i][j] + arr2[i][j]);
        }
    }
    
    return result;
}