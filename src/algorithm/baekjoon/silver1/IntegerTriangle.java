class IntegerTriangle {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] triangle = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        if (size > 1) {
            dp[1][0] = dp[0][0] + triangle[1][0];
            dp[1][1] = dp[0][0] + triangle[1][1];
        }
        for (int i = 2; i < size; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] =
                        Math.max(
                                (j - 1) < 0 ? 0 : dp[i - 1][j - 1] + triangle[i][j],
                                dp[i - 1][j] + triangle[i][j]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
