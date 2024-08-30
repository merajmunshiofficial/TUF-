import java.util.List;
import java.util.ArrayList;
import java.util.*;

class maxMeetings {
    // Comparator function to sort meetings based on end times
    static class MeetingComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            // Sort by end time in ascending order
            return Integer.compare(a[1], b[1]);
        }
    }

    // Function to find the maximum number of meetings that can be held
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        // List to store meetings
        List<int[]> meetings = new ArrayList<>();
        
        // Fill the meetings list with start and end times
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        // Sort the meetings based on the custom comparator
        Collections.sort(meetings, new MeetingComparator());

        // The end time of last selected meeting
        int limit = meetings.get(0)[1];
        // Initialize count
        int count = 1;

        /*Iterate through the meetings 
        to select the maximum number 
        of non-overlapping meetings*/
        for (int i = 1; i < n; i++) {
            /*If the current meeting starts 
            after the last selected meeting ends*/
            if (meetings.get(i)[0] > limit) {
                /*Update the limit to the end 
                time of the current meeting*/
                limit = meetings.get(i)[1];
                // Increment count
                count++;
            }
        }

        // Return count
        return count;
    }

    public static void main(String[] args) {
        maxMeetings obj = new maxMeetings();
        // Start and end times of the meetings
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        // Get the maximum number of meetings that can be held
        int maxMeetings = obj.maxMeetings(start, end);
        // Output the maximum number of meetings
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }
}
