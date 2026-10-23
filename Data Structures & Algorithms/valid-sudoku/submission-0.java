class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.') {
                    if (set.contains(board[i][j] - '1')) {
                        return false;
                    } else {
                        set.add(board[i][j] - '1');
                    }
                }
            }
            set = new HashSet<>();
        }

        set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i]!='.') {
                    if (set.contains(board[j][i] - '1')) {
                        return false;
                    } else {
                        set.add(board[j][i] - '1');
                    }
                }
            }
            set = new HashSet<>();
        }

        set = new HashSet<>();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set = new HashSet<>();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[m + i][n + j]!='.') {
                            if (set.contains(board[m + i][n + j] - '1')) {
                                return false;
                            } else {
                                set.add(board[m + i][n + j] - '1');
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
