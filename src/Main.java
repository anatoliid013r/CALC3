public class Main {
    public static String calc(String input) {
        String[] leng = input.split(" ");
        if (leng.length > 3 ) try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("throws Exception ");
            return "//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        };
    String[] flags = (toInteger(input));
    flags = WhatASign(input, flags);
    String answer = "0";
    for (int i = 0; i < 2; i++) {
        flags = ToNum(flags, i);
    }
    if (flags[5] != "0" && flags[2] == flags[3]) {
    int abs=solve(flags);
    if (abs==256) try {
        throw new Exception();
    } catch (Exception e) {
        System.out.println("throws Exception  ");;
        return "//т.к. формат математической операции не удовлетворяет заданию - числа <=10 или >=1";
    }
    answer = Integer.toString(abs);
    if (abs<0 && flags[2]=="0") return "throws Exception";
    if (flags[2]=="0"){
        if (abs==0) try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("throws Exception  ");;
            return "//т.к. в арабской системе нет 0";
        }
        answer=toArab(abs);
    }


    return answer;
    } else  try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("throws Exception  ");;
            return "//т.к. формат математической операции не удовлетворяет заданию - числа <=10 или >=1";
        }
    }

    static String toArab(int num){

        String a="12";
        int temp1= num/10;
        int temp2= num%10;
        String ost=Arab(temp2);
        if (num==100) a= "C";
        if (temp1<1) a= ost;
        if (temp1==1) a= "X"+ost;
        if (temp1==2) a= "XX"+ost;
        if (temp1==3) a= "XXX"+ost;
        if (temp1==4) a= "XL"+ost;
        if (temp1==5) a= "L"+ost;
        if (temp1==6) a= "LX"+ost;
        if (temp1==7) a= "LXX"+ost;
        if (temp1==8) a= "LXXX"+ost;
        if (temp1==9) a= "XC"+ost;
        return a;
    }


    static String Arab(int num){
        String a ="";
        switch (num) {
            case 1:
                a = "I";
                break;
            case 2:
                a = "II";
                break;
            case 3:
                a = "III";
                break;
            case 4:
                a = "IV";
                break;
            case 5:
                a = "V";
                break;
            case 6:
                a = "VI";
                break;
            case 7:
                a = "VII";
                break;
            case 8:
                a = "VIII";
                break;
            case 9:
                a = "IX";
                break;
        }
        return a;

    }
    static String[] ToNum(String[] num,int i){
        switch(num[i]){
            case "I":
                num[i]="1";
                num[i+2]="0";
                break;
            case "II":
                num[i]="2";
                num[i+2]="0";
                break;
            case "III":
                num[i]="3";
                num[i+2]="0";
                break;
            case "IV":
                num[i]="4";
                num[i+2]="0";
                break;
            case "V":
                num[i]="5";
                num[i+2]="0";
                break;
            case "VI":
                num[i]="6";
                num[i+2]="0";
                break;
            case "VII":
                num[i]="7";
                num[i+2]="0";
                break;
            case "VIII":
                num[i]="8";
                num[i+2]="0";
                break;
            case "IX":
                num[i]="9";
                num[i+2]="0";
                break;
            case "X":
                num[i]="10";
                num[i+2]="0";
                break;
        }
        return num;
    }
    static String[] WhatASign(String math,String[] flags){      // Возвращает какой знак в выражении
        int index = IndexOfSign(math);
        if(index == 0){
            flags[5]="0";
        }
        flags[4]=math.substring(index,index+1);
        return flags;
    }
    static int IndexOfSign(String math){// Возвращает индекс знака в выражении
        int index = 0;
        if (math.indexOf("**")!=-1)
            return 0;
        if (math.indexOf("+")==-1)
            if (math.indexOf("-")==-1)
                if (math.indexOf("*")==-1)
                    index =math.indexOf("/");
                else index = math.indexOf("*") ;
            else index = math.indexOf("-");
        else index = math.indexOf("+");
        return index;
    }
    static String[] toInteger(String a){ // Возвращает либо первое либо второе число в выражении
        String[] flags = new String[6];
        flags[3]="1";
        flags[2]="1";
        String num1=null;
        for (int i = 0; i < 2; i++) {
            if (i == 0){
                int index = IndexOfSign(a);
                num1=a.substring(0, index);
                String[] num11=num1.split(" ");
                num1=num11[0];
                flags[0]=num1;
            }
            else if (i == 1){
                int index = IndexOfSign(a);
                num1=a.substring(index+1, a.length());
                String[] num11=num1.split(" ");
                num1=num11[1];
                flags[1]=num1;
            }
        }
        return flags;
    }
    static int solve(String[] flags){
        int answer=0;
        int Number1=Integer.parseInt(flags[0]);
        if (Number1 < 1 || Number1 > 10) return 256;
        int Number2=Integer.parseInt(flags[1]);
        if (Number2 < 1 || Number2 > 10) return 256;
        switch (flags[4]){
            case "+" : answer=Number1+Number2; break;
            case "-" : answer=Number1-Number2; break;
            case "*" : answer=Number1*Number2; break;
            case "/" : answer=Number1/Number2; break;
        }
        return answer;
    }
}
