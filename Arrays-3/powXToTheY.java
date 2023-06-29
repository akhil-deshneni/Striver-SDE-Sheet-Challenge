class powXToTheY{
    
    private int Brute_force(int x,int y){
        int ans = 1;
        while(y-- > 0){
            ans *= x;
        }
        return ans;
    }

    private int Binary_exponentiation(int x,int y){
        int ans = 1;
        while(y != 0){
            if(y % 2 == 0){
                x *= x;
                y /= 2;
            }else{
                ans = ans*x;
                y--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        powXToTheY pxy = new powXToTheY();
        int ans = 0;
        int x = 5, y = 3;
        // ans = pxy.Brute_force(x, y);
        ans = pxy.Binary_exponentiation(x, y);
        System.out.println(x+ " Power "+y+" is = "+ans);
    }
}