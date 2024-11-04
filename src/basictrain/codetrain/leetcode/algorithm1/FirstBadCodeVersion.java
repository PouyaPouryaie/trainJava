package basictrain.codetrain.leetcode.algorithm1;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * example:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version
 */
public class FirstBadCodeVersion {

    public static void main(String[] args) {
        int n = 5;
        int lowNumber = 1;
        int maxNumber = n;
        while (lowNumber < maxNumber) {
            int mid = lowNumber + (maxNumber - lowNumber) / 2;
            boolean badCode = isBadCodeVersion(mid);
            if (badCode) {
                maxNumber = mid;
            } else {
                lowNumber = mid + 1;
            }
        }
        System.out.println("index " + lowNumber);
    }

    public static boolean isBadCodeVersion(int number) {
        if (number >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
