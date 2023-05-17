package squenceList;

public class LongestPalindromeSubstring {
    public static int longestPalindromeSubstring(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j]表示从索引i到索引j的子串是否为回文

        // 初始化单个字符为回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1; // 最长回文子串的长度
        int start = 0; // 最长回文子串的起始索引

        // 检查长度为2的子串是否为回文
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        // 检查长度大于2的子串是否为回文
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = len;
                    start = i;
                }
            }
        }

        // 输出最长回文子串
        String longestPalindrome = str.substring(start, start + maxLength);
        System.out.println("Longest palindrome substring: " + longestPalindrome);

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "aabcbadd";
        int length = longestPalindromeSubstring(str);
        System.out.println("Length of the longest palindrome substring: " + length);
    }
}
