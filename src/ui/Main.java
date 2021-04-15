
package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static String FINALMESSAGE="";
    public static int AUX1;
    public static int AUX2;
    public static int AUX3;
    public static int DISK;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        
        String lineCases=br.readLine();
        int numberOfCasesLine=Integer.parseInt(lineCases);
        int[] maxCases = new int[numberOfCasesLine];
        
        if(numberOfCasesLine>0){
            for(int i=0;i<maxCases.length;i++){
                String amountOfDisk=br.readLine();
                maxCases[i]=DISK=Integer.parseInt(amountOfDisk);
            }
        }
        organiceHanoiCases(maxCases);
        bw.write(FINALMESSAGE);
        br.close();
        bw.close();
    }
    
    public static void organiceHanoiCases(int[] cases){
        FINALMESSAGE+="\n";
        for(int i=0;i<cases.length;i++){
            AUX1=cases[i];
            FINALMESSAGE+=AUX1+" "+AUX2+" "+AUX3+"\n";
            hanoiTowers(cases[i],1,2,3);
            FINALMESSAGE+="\n";
            AUX1 = 0;
            AUX2 = 0;
            AUX3 = 0;
        }
    }
    
    public static void hanoiTowers(int disks,int startingTower, int temporalTower, int finalTower){
        if (disks == 1) {
            moveDiskThroughTowers(startingTower,finalTower);
            FINALMESSAGE +=AUX1+" "+AUX2+" "+AUX3+"\n";
            return;
        } 
        else {
            hanoiTowers(disks - 1,startingTower,finalTower,temporalTower);
            moveDiskThroughTowers(startingTower,finalTower);
            FINALMESSAGE +=AUX1+" "+AUX2+" "+AUX3+"\n";
            hanoiTowers(disks - 1, temporalTower,startingTower,finalTower);
            return;
        }
    }
    
    public static void moveDiskThroughTowers(int startingTower, int finalTower) {
        switch (startingTower) {
            case 1:
                AUX1--;
                break;
            case 2:
                AUX2--;
                break;
            default:
                AUX3--;
                break;
        }

        switch (finalTower) {
            case 1:
                AUX1++;
                break;
            case 2:
                AUX2++;
                break;
            default:
                AUX3++;
                break;
        }
    }
}
