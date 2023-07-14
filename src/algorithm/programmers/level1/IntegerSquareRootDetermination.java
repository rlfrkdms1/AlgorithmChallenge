class IntegerSquareRootDetermination {
    public long solution(long n) {
        return Math.sqrt(n)<Math.ceil(Math.sqrt(n)) ? -1 : (long)Math.pow((long)(Math.sqrt(n)+1),2);
    }
}
