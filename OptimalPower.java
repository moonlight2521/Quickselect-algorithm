/**
 * Created by zunlin on 10/12/17.
 */
import java.util.Map;
import java.util.Scanner;
public class OptimalPower {

    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    //read in the number of the house
    System.out.println("Please Enter the number of houses: ");
    int n = in.nextInt();
    //read in the location of the house
    System.out.println("Please Enter the y coordinate of each house: ");
    int houseLocation[] = new int[n];
    //add the location to the array
    for(int i =0; i<n; i++){
        houseLocation[i] = in.nextInt();
    }

    int mid = n/2;
    int value = findMedian(houseLocation, 0, houseLocation.length-1, mid);
    //print out the houseLocation array
    for(int i =0; i<n; i++){
        System.out.println(houseLocation[i]);
    }
    System.out.println("the answer is " + value);

    }


    public static int findMedian(int [] arr, int left, int right, int mid){
            //If there is only one element in the array.
            if(left == right){
                return arr[left];
            }
            int pivotIndex = left + (int)(Math.random() % (right - left+ 1));
            pivotIndex = partition(arr, left, right, pivotIndex);
            if( mid == pivotIndex){
                return arr[mid];
            }
            else if(mid < pivotIndex){
                return findMedian(arr,left, pivotIndex -1, mid);
            }
            else return findMedian(arr, pivotIndex+1, right, mid);
    }

    public static int partition (int arr [], int left, int right, int pivot){
        int pivotValue = arr[pivot];
        swap(arr, pivot, right );  // move pivot to end
        int storeIndex = left ;
        for (int i = left; i < right; i++){
            if(arr[i] < pivotValue){
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);    // move pivot to its final place.
        return storeIndex;
    }
    // swap two element in the array.
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

