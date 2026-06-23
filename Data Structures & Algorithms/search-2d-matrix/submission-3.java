class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int r = matrix.length;
        int c = matrix[0].length;
        int st=0;
        int ed=(r*c)-1;

        while(st<=ed)
        {
            int mid = (st+ed)/2;
            int cr = mid/c;
            int cc = mid%c;
            if(matrix[cr][cc] == target) return true;
            else if(matrix[cr][cc] < target) st = mid+1;
            else ed=mid-1;
        }
        return false;
    }
}
