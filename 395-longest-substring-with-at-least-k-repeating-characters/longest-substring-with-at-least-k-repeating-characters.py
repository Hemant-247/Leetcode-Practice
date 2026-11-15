class Solution:
    def longestSubstring(self, s, k):
        n = len(s)
        ans = 0

        for target in range(1, 27):
            freq = [0] * 26
            left = 0
            right = 0
            unique = 0
            count = 0

            while right < n:
                idx = ord(s[right]) - ord('a')

                if freq[idx] == 0:
                    unique += 1

                freq[idx] += 1

                if freq[idx] == k:
                    count += 1

                right += 1

                while unique > target:
                    idx = ord(s[left]) - ord('a')

                    if freq[idx] == k:
                        count -= 1

                    freq[idx] -= 1

                    if freq[idx] == 0:
                        unique -= 1

                    left += 1

                if unique == target and unique == count:
                    ans = max(ans, right - left)

        return ans