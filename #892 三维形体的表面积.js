/**
 * @param {number[][]} grid
 * @return {number}
 */
var surfaceArea = function(grid) {
    let number=0;
    const leni=grid.length;
    const lenj=grid[0].length;
    for(i=0;i<leni;i++) {
        for(j=0;j<lenj;j++) {
            if(grid[i][j]>0) {
                number+=2; // top and down surface
                if(i>0 && grid[i][j]-grid[i-1][j]>0) number+=grid[i][j]-grid[i-1][j];
                if(j>0 && grid[i][j]-grid[i][j-1]>0) number+=grid[i][j]-grid[i][j-1];
                if(i+1<leni && grid[i][j]-grid[i+1][j]>0) number+=grid[i][j]-grid[i+1][j];
                if(j+1<lenj && grid[i][j]-grid[i][j+1]>0) number+=grid[i][j]-grid[i][j+1];
                if(i===0) number+=grid[i][j];
                if(j===0) number+=grid[i][j];
                if(i+1===leni) number+=grid[i][j];
                if(j+1===lenj) number+=grid[i][j];
            }
        }
    }
    return number;
};