class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String a = str1, b = str2;
        int n = a.length(), m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        // LCS tabulation
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS string reconstruction
        StringBuilder temp = new StringBuilder();
        int x = n, y = m;

        while (x > 0 && y > 0) {
            if (a.charAt(x - 1) == b.charAt(y - 1)) {
                temp.append(a.charAt(x - 1));
                x--;
                y--;
            } else if (dp[x - 1][y] >= dp[x][y - 1]) {
                x--;
            } else {
                y--;
            }
        }

        String lcs = temp.reverse().toString();

        // SCS using LCS
        StringBuilder scs = new StringBuilder();
        int i = 0, j = 0, k = 0;

        while (i < a.length() && j < b.length()
                && k < lcs.length()) {

            while (i < a.length() && a.charAt(i) != lcs.charAt(k)) {
                scs.append(a.charAt(i++));
            }

            while (j < b.length() && b.charAt(j) != lcs.charAt(k)) {
                scs.append(b.charAt(j++));
            }

            scs.append(lcs.charAt(k));
            i++;
            j++;
            k++;
        }

        while (i < a.length()) {
            scs.append(a.charAt(i++));
        }

        while (j < b.length()) {
            scs.append(b.charAt(j++));
        }

        return scs.toString();
    }
}