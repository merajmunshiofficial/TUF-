import java.util.*;

class candy {
    // To calculate the number of candies
    public int candy(int[] ratings) {
        // Size of the ratings array
        int n = ratings.length;
        
        // Initialize index variable
        int i = 1;
        
        /*Initialize the total number of candies,
        starting with one candy for the first child*/
        int sum = 1;
        
        // Loop the ratings array
        while (i < n) {
            
            /*Check if the current child's rating
            is equal to the previous one*/
            if (ratings[i] == ratings[i - 1]) {
                
               /* If so, give the current child one
                more candy than the previous one*/
                sum = sum + 1;
                
               /* Move to the next child*/
                i++;
                
                /*Skip the rest of the loop and
                move to the next iteration*/
                continue;
            }
            
           /* Initialize the candy count
            for increasing rating trend*/
            int peak = 1;
            
            // Loop through increasing ratings trend
            while (i < n && ratings[i] > ratings[i - 1]) {
                
                /*Increment candy count
                for increasing trend*/
                peak += 1;
                
                /*Update the total
                number of candies*/
                sum += peak;
                
                // Move to next
                i++;
            }
            
            /*Initialize the candy count
            for decreasing rating trend*/
            int down = 1;
            
            // Loop through decreasing ratings trend
            while (i < n && ratings[i] < ratings[i - 1]) {
                
                /*Update the total number of
                candies for decreasing trend*/
                sum += down;
                
                // Move to next
                i++;
                
                /*Increment the candy
                count for decreasing trend*/
                down++;
            }
            
            /*Check if the candy count for
            decreasing trend exceeds the peak*/
            if (down > peak) {
                /*Adjust the total number of
                candies to satisfy the condition*/
                sum += (down - peak);
            }
        }
        
        // Return total candies
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {0, 2, 4, 3, 2, 1, 1, 3, 4, 6, 4, 0, 0};
        System.out.print("Ratings of Children: ");
        for(int rating : ratings){
            System.out.print(rating + " ");
        }
        System.out.println();
        candy sol = new candy();
        int result = sol.candy(ratings);
        System.out.println("Minimum number of candies needed: " + result);
    }
}
