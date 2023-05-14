public class Fibonacci {
    static int Fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibo(n-1)+Fibo(n-2);
    }

    public static void main(String[] args) {
        int n =100000;

        int[] store = new int[n+1];
        store[0]=0;
        store[1]=1;
        for (int i = 2; i <= n; i++) {

                store[i] = (store[i - 1] + store[i - 2])%1234567;

        }
        int answer=store[n];
        System.out.println("answer = " + answer);


    }
}
