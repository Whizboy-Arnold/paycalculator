package com.gelostech.nssf.data;

public class Payment {

    private int basicpay;
    private int benefits;
    private boolean selfemployed;


    public Payment() {
    }

    public void setBenefits(int benefits) {
        this.benefits = benefits;
    }

    public void setBasicpay(int basicpay) {
        this.basicpay = basicpay;
    }

    int tire1;
    int tire2;

    public int getGrossPay(){
        if(benefits>3000){
            return basicpay+benefits-3000;
        }else{
            return basicpay;
        }
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
        if(getGrossPay() > 3000){
            if(getGrossPay()>=6000){
                pensionablelower = 6000;
            }else{
                pensionablelower = getGrossPay();
            }
        }else{//min out
            pensionablelower=3000;
        }
        tire1 = (int) ((pensionablelower / 1500) * 1500 * .06);
        deduction =tire1;
        System.out.println((pensionablelower / 1500) +" dd "+deduction);
        //upper tier
        if(getGrossPay() > 6000){
            int pensionablehigher;
            if(getGrossPay()>18000){//max out
                pensionablehigher = 18000 - 6000;
            }else{
                pensionablehigher = getGrossPay() - 6000;
            }
            tire2 = (int) ((pensionablehigher / 4000) * 4000 * .06);
            deduction += tire2;
        }
        System.out.println(" dd2 "+deduction);

        return deduction;
    }

    public int calculateNssftotal(){
        return this.calculateNSSFhalf()*2;
    }

    private int taxtire1;


    public int calculatePAYE(){
        int taxdeduction;
        int taxablelower;
        int remainder;


        if(getGrossPay()>=12298){
            taxablelower = 12298;
        }else{
            taxablelower = getGrossPay();
        }
        taxtire1 = (int) (taxablelower *.10);
        taxdeduction =tire1;

        remainder=getGrossPay()-12298;

        int count =1;
        while(remainder-11587>0 | count>4){
            if(remainder>=11587){
                if (4 == count) {
                    taxablelower=getGrossPay();//max over
                } else {
                    taxablelower =11587; //max out
                }
            }else{
                taxablelower = getGrossPay(); //min out
            }
            taxtire1 += (int) (taxablelower *(.10+count*.05));
            taxdeduction +=tire1;
            remainder-=11587;
            count++;
        }

        return taxdeduction;
    }


    public int calculateNHIF(){
        int nhifdeduction;

        if(!selfemployed) {
            if (getGrossPay() < 6000) {
                nhifdeduction = 150;
            } else if (getGrossPay() < 8000) {
                nhifdeduction = 300;
            } else if (getGrossPay() < 12000) {
                nhifdeduction = 400;
            } else if (getGrossPay() < 15000) {
                nhifdeduction = 500;
            } else if (getGrossPay() < 20000) {
                nhifdeduction = 600;
            } else if (getGrossPay() < 25000) {
                nhifdeduction = 750;
            } else if (getGrossPay() < 30000) {
                nhifdeduction = 850;
            } else if (getGrossPay() < 35000) {
                nhifdeduction = 900;
            } else if (getGrossPay() < 40000) {
                nhifdeduction = 950;

            } else if (getGrossPay() < 45000) {
                nhifdeduction = 1000;

            } else if (getGrossPay() < 50000) {
                nhifdeduction = 1100;

            } else if (getGrossPay() < 60000) {
                nhifdeduction = 1200;

            } else if (getGrossPay() < 70000) {
                nhifdeduction = 1300;

            } else if (getGrossPay() < 80000) {
                nhifdeduction = 1400;

            } else if (getGrossPay() < 90000) {
                nhifdeduction = 1500;
            } else if (getGrossPay() < 100000) {
                nhifdeduction = 1600;
            } else {
                nhifdeduction = 1700;
            }
            return nhifdeduction;
        }else{
            return 500;
        }
    }

    public int getBenefits() {
        return benefits;
    }


    public void setSelf(boolean selected) {
        this.selfemployed=selected;

    }

    public void setCover(int parseInt) {

    }

    public void setPension(int parseInt) {

    }
}
