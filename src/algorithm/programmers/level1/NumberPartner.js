function solution(X, Y) {
    let answer = '';
    const Xcount = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    const Ycount = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    for(let i = 0; i < X.length; i++) {
        Xcount[X[i]]++;
    }

    for(let j = 0; j < Y.length; j++) {
        Ycount[Y[j]]++;
    }

    for(let i = 9; i >= 0; i--) {
        answer += ('' + i).repeat(Math.min(Xcount[i], Ycount[i]));
    }
    
    if(answer == '') return '-1';
    if(answer[0] == '0') return '0';
    
    return answer;
}
