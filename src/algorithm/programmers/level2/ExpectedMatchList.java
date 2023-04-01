class ExpectedMatchList
{
    /**
    놓친점이 두가지 있다.
    1. a와 b는 순서가 정해지지 않았다. 즉, a<b라는 조건이 없으므로 b가 선행될 수도 있다는 것이다. 
    따라서 while문이 break 되는 조건을 걸때 a-b==1이 되는 것이 아니라 abs를 사용해서 절대값을 이용해야 한다. 
    2. a와 b가 연달아 있어도 붙지 않을 수 있다. N이 4이고 각각 a=2, b=3이라면 둘은 1라운드에서 붙지 않는다. 
    따라서 while문의 break 조건에 a,b 둘 중 큰 값이 짝수이어야 함을 명시해주어야 한다.
    **/
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        while(true){
            if(Math.abs(a-b)==1 && Math.max(a,b)%2==0) break;
            a = (int) Math.ceil(a/(double)2);
            b = (int) Math.ceil(b/(double)2);
            answer++;
        }

        return answer;
    }
}
