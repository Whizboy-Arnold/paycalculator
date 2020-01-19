package com.gelostech.nssf.data;

public class Payment {

    private final int grosspay;

    public Payment(int grosspay) {
        this.grosspay = grosspay;
    }

    int tire1;
    int tire2;

    public int getGrosspay() {
        return grosspay;
    }

    public int getTire1() {
        return tire1;
    }

    public int getTire2() {
        return tire2;
    }

    public int calculateNSSFhalf(){
        int deduction;
        //lower tier
        ///////add if sttmnt tomin out
        int pensionablelower;
        if(grosspay > 3000){
            if(grosspay>=6000){//max out
                pensionablelower = 6000;
            }else{
                pensionablelower = grosspay;
            }
        }else{//max out
            pensionablelower=3000;
        }
        tire1 = (int) ((pensionablelower / 1500) * 1500 * .06);
        deduction =tire1;
        System.out.println((pensionablelower / 1500) +" dd "+deduction);
        //upper tier
        if(grosspay > 6000){
            int pensionablehigher;
            if(grosspay>18000){//max out
                pensionablehigher = 18000 - 6000;
            }else{
                pensionablehigher = grosspay - 6000;
            }
            tire2 = (int) ((grosspay / 4000) * 4000 * .06);
            deduction += tire2;
        }
        System.out.println(" dd2 "+deduction);

        return deduction;
    }

    public int calculateNssftotal(){
        return this.calculateNSSFhalf()*2;
    }
}
