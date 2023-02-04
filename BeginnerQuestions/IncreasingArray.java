import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class IncreasingArray {

    /*
    dry run
    arr[] = {3,2,5,1,7}
    n = 5
    iteration - 1:
    arr[1] = 2
    arr[0] = 3

    arr[1] < arr[0] -> ans += 1(3-2)=1

    iteration-2:
    arr[2]=5
    arr[1] = 2
    arr[2] < arr[1] --> false

    iteration-3:

    arr[3] =1
    arr[2] = 5
    arr[3] < arr[2] -> ans += 4(5-1) = 5

    iteration 4

    arr[4] = 7
    arr[3] = 1
    arr[4] < arr[3] --> false

    loop ends and the final answer is 5
     */
    private static int increasingArray(int arr[],int n){
        int minOperations = 0;
        for(int i=1;i<n;i++){
            if(arr[i] < arr[i-1]){
                minOperations += (arr[i-1]-arr[i]);
                arr[i] = arr[i-1];
            }
        }
        return minOperations;
    }
    public static void main(String[] args) {
        // System.in and System.out are input and output streams, respectively.
        InputStream inputStream = System.in;

        InputReader in = new InputReader(inputStream);

        // Read the number of test cases.
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        //function to calculate the increasing array
        int minOp = increasingArray(arr,n);
        System.out.println("Minimum numbers of operations required: "+minOp);
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }


    }
}
