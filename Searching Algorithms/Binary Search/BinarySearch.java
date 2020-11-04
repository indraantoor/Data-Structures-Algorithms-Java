public class BinarySearch {
    public static int search(int arr[], int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = Math.floorDiv(left + right, 2);
            int midValue = arr[mid];
            if (target == midValue) {
                return mid;
            } else if (target > midValue) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] toBeSearchedArray = {1, 2, 3, 20, 21, 58, 61, 78, 88, 90, 104};
        int target = 58;

        System.out.println(search(toBeSearchedArray, target));
    }
}