/**
 * @param {character[][]} board
 * @return {number}
 */
var numRookCaptures = function(board) {
    let number=0;
    const len=8;
    let ri=0;
    let rj=0;
    for(i=0;i<len;i++) {
        for(j=0;j<len;j++) {
            if(board[i][j]==="R") {
                ri=i;
                rj=j;
                break;
            }
        }
    }
    let posi,posj;
    posi=ri;
    posj=rj;
    while(posi>=0 && posi<len && posj>=0 && posj<len) {
        if(board[posi][posj]==="B") break;
        if(board[posi][posj]==="p") {
            number++;
            break;
        }
        posi--;
    }
    posi=ri;
    posj=rj;
    while(posi>=0 && posi<len && posj>=0 && posj<len) {
        if(board[posi][posj]==="B") break;
        if(board[posi][posj]==="p") {
            number++;
            break;
        }
        posi++;
    }
    posi=ri;
    posj=rj;
    while(posi>=0 && posi<len && posj>=0 && posj<len) {
        if(board[posi][posj]==="B") break;
        if(board[posi][posj]==="p") {
            number++;
            break;
        }
        posj--;
    }
    posi=ri;
    posj=rj;
    while(posi>=0 && posi<len && posj>=0 && posj<len) {
        if(board[posi][posj]==="B") break;
        if(board[posi][posj]==="p") {
            number++;
            break;
        }
        posj++;
    }
    return number;
};