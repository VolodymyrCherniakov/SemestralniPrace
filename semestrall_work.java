package semestral_work;
import java.util.Scanner;

	  
/** 
 * 1.The program finds 2 vectors with the largest scalar product among the given vectors.  
 * @author VolodymyrCherniakov
 * @version 26/12/2022 
 */  


public class SemestralProject {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean work = true;
        int choice;
        while (work) {
            System.out.println("\n\nEnter the choice:\n1 - Semestral Project\n2 - Christmas Project\n0 - Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    SemestralProject();
                    break;
                case 2:
                    snowman();
                    break;
                case 0:
                    work = false;
                    break;
                default:
                    System.out.println("Wrong choice, try again.");
                    break;
            }
        }   
    }
    
    /**
     * Main function of Semestral Project.
     */
    public static void SemestralProject() {
        
        int vectors;
        int length;
        double[][] arr;
        System.out.print("\nEnter the number of vectors(n): ");
        while ((vectors = scan.nextInt()) > 0) {
            System.out.print("Enter the length of vectors(k): ");
            length = scan.nextInt();
            if(length < 0){
                System.out.println("Incorrect input\n\n");
                break;
            }
            arr = createArray(vectors, length);
            printArray(arr);
            MaxScalarProduct(arr);
            System.out.print("\nEnter the number of vectors(n): ");
        }
    }
    
    /**
    * This method creates and fills 2D array.
    * The method creates a 2D array and fills it one by one with the numbers, which need to enter.
    * @param vectors amount of vectors
    * @param length length of vectors
    * @return 2D array with numbers
    */
    public static double[][] createArray(int vectors, int length) {
        double[][] arr = new double[vectors][length];
        System.out.println("Enter the vectors: ");
        for (int i = 0; i < vectors; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }
    
    /**
     * This method writes 2D array in the console.
     * The method goes through 2D array, which you enter, in two loops and writes out every i j element
     * @param arr 2D array 
     */
    public static void printArray(double[][] arr) {
        System.out.print("\nAll vectors:\n");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    
    /**
     * This method find the 2 vectors with the largest scalar product.
     * The method creates 2D array for the biggest vectors.Three cycles pass through the 2D field. 
     * The first goes through the first dimension of the array from 0 to the penultimate element (i).
     * The second one also passes through the first dimension of the array,
     * but from the element of the first loop (i) + 1 to the last element of the array (k) .
     * The third passes through the second dimension of the array from the beginning to the end (j).
     * In the third loop the sum of arr[i][j] and arr[k][j] is added every iteration. If temp is greater 
     * than the largest scalar product then 2 vectors are overwritten into the maxVec array.
     * After all, the printVectorsAndProduct() function is called.
     * @param arr 2D array, were placed all vectors. 
     */
    public static void MaxScalarProduct(double[][] arr) {
        double[][] maxVec = new double[2][arr.length];
        double scalProd = 0;
        double temp = 0;
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int k = i + 1; k < arr.length; k++) {
                for (int j = 0; j < arr[i].length; j++) {
                    temp += arr[i][j] * arr[k][j];
                }
                if (temp > scalProd) {
                        scalProd = temp;
                        maxVec[0] = arr[i];
                        maxVec[1] = arr[k];
                    }
                temp = 0;
            }
        }
        printVectorsAndProduct(maxVec, scalProd);
    }

    /**
     * This method writes in console 2 vectors with the biggest scalar product and their scalar product.
     * The first cycle passes through the first dimension ( i ). 
     * By the second cycle we pass through the second dimension ( j ).
     * With each iteration writes in console maxVec[i][j]
     * After it writes in console scalar product of these vectors.
     * @param maxVec 2D array with vectors, which have the biggest scalar product.
     * @param scalProd Maximum scalar product.
     */
    public static void printVectorsAndProduct(double[][] maxVec, double scalProd) {
        System.out.println("Vectors with maximum scalar product:");
        for (int i = 0; i < maxVec.length; i++) {
            System.out.print("(");
            for (int j = 0; j < maxVec[i].length; j++) {
                System.out.print(maxVec[i][j] + (j != (maxVec[i].length-1) ? "\t" : "" ));
            }
            System.out.println(")");
        }
        System.out.print("Scalar product of these vectors: " + scalProd);
    }

    /**
     * Main part of christmas project.
     */
    
    public static void snowman(){
        System.out.print("\n");
        System.out.println("Enter size of snowballs\nmin - 4\t\tmax - 10");
        int size = scan.nextInt();
        System.out.println("Enter amount of snowballs\nmin - 2\t\tmax - 5");
        int amount = scan.nextInt();
        boolean isBody = false;
        int field = size * 3;
        int stars = size;
        while (amount != 0) {
            if(isBody){
                stars = topHalfBody(size,field,stars);
                stars = bottomHalf(size, field, stars, isBody);
            
            }else{
                Hat(size, field, stars);
                stars = topHalfHead(size, field, stars);
                stars = bottomHalf(size, field, stars, isBody);
                isBody = true;
            }
            
            stars+=2;
            amount--;
            
        }
    }
    
    private static int topHalfBody(int size, int field, int stars) {
        for (int i = 0; i < size / 2; i++) {
                int spaces = (field - stars) / 2;
                for (int j = 0; j < spaces; j++) {
                    System.out.print("  ");
                }
                for (int k = 0; k < stars; k++) {
                    if(i == ((size/2)-1) && k == (stars/2)){
                        System.out.print("o ");
                    }else{
                    System.out.print("* ");
                    }
                }
                System.out.println();
                //spaces--;
                stars+=2;
        }
        return stars;
    }
    private static int bottomHalf(int size, int field, int stars, boolean isBody){
        for (int i = size / 2; i > 0; i--) {
                stars-=2;
                int spaces = (field - stars) / 2;
                for (int j = 0; j < spaces; j++) {
                    System.out.print("  ");
                }
                for (int k = 0; k < stars; k++) {
                    if(k == stars/2 &&  i == size/2 && !isBody){
                            System.out.print(" > ");
                    }else{
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
        return stars;
    }
    
    private static int topHalfHead(int size, int field, int stars) {
        for (int i = 0; i < size / 2; i++) {
                int spaces = (field - stars) / 2;
                for (int j = 0; j < spaces; j++) {
                    System.out.print("  ");
                }
                for (int k = 0; k < stars; k++) {
                    if(i == ((size/2)-1) && (k == (stars/2-1) || k == (stars/2+1)) ){
                        System.out.print("O ");
                    }else{
                        
                    System.out.print("* ");
                    }
                }
                System.out.println();
                //spaces--;
                stars+=2;
        }
        
        return stars;
    }
    
    private static void Hat(int size,int field, int stars) {
        stars/=2;
        for(int i = 0; i<size; i++){
            int spaces = (field-stars);
            for(int j = 0; j<spaces ;j++){
                    System.out.print(" ");
                }
           boolean flag = true;
                for(int k = 0; k<stars; k++){
                    if(i == 0){
                        System.out.print("__");
                    }else{
                        
                        if(k == (stars-1)){
                            System.out.print("_\\");
                        }else if(flag){
                            System.out.print("/_");
                            flag = false;
                        }else{
                            System.out.print("__");
                        }
                    }
               }
            stars++;
            System.out.println("");
        }
    }
}
