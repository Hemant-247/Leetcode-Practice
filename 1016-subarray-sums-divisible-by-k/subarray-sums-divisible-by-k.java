class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int[] freq = new int[k];
        freq[0] = 1;

        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            int rem = ((sum % k) + k) % k;

            count += freq[rem];
            freq[rem]++;
        }

        return count;
    }
}