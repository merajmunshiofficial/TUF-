import java.util.List;
import java.util.ArrayList;
import java.util.*;

class mergeSort {
    // Method to merge two sorted halves of the array
    void merge(int[] arr, int low, int mid, int high) {
        // Temporary array to store merged elements
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Loop until subarrays are exhausted
        while (left <= mid && right <= high) {
            // Compare left and right elements
            if (arr[left] <= arr[right]) {
                // Add left element to temp
                temp.add(arr[left]);
                // Move left pointer
                left++;
            } else {
                // Add right element to temp
                temp.add(arr[right]);
                // Move right pointer
                right++;
            }
        }

        // Adding the remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Adding the remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transferring the sorted elements to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    int[] mergeSort(int[] arr, int low, int high) {
        // Base case: if the array has only one element
        if (low >= high)
            return arr;
        // Find the middle index
        int mid = (low + high) / 2;
        // Recursively sort the left half
        mergeSort(arr, low, mid);
        // Recursively sort the right half
        mergeSort(arr, mid + 1, high);
        // Merge the sorted halves
        merge(arr, low, mid, high);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int n = arr.length;

        System.out.println("Before Sorting Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Create an instance of the mergeSort class
        mergeSort mergeSort = new mergeSort();
        // Function call to sort the array
        int[] sortedArr = mergeSort.mergeSort(arr, 0, n - 1);

        System.out.println("After Sorting Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sortedArr[i] + " ");
        }
        System.out.println();
    }
}
