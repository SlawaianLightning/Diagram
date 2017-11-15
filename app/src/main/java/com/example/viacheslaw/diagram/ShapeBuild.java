package com.example.viacheslaw.diagram;

import android.graphics.Path;

import com.mindfusion.diagramming.ElementTemplate;
import com.mindfusion.diagramming.LineTemplate;
import com.mindfusion.diagramming.Shape;
import com.mindfusion.drawing.Color;

public class ShapeBuild {
    public static final String ANTIHEVELKLEP="ANTIHEVELKLEP";
    public static final String BULKTANK="BULKTANK";
    public static final String CUSTOM_SHAPE="CUSTOM_SHAPE";
    public static final String LEDING="LEDING";
    public static final String VERTICALLEDING="VERTICALLEDING";
    public static final String MAGNEETAFSLUITER="MAGNEETAFSLUITER";
    public static final String TRIMPOMP="TRIMPOMP";
    public static final String MANOMETER="MANOMETER";
    public static final String DOORVOER="DOORVOER";
    public static final String FILTER="FILTER";
    public static final String HANDAFSLUITER="HANDAFSLUITER";
    public static final String DRIEWEGKRAAN="DRIEWEGKRAAN";
    public static final String DAGTANK="DAGTANK";
    public static final String FLEXIBEL="FLEXIBEL";

    public static Shape getCustomShape(){
        ElementTemplate[] lines=new LineTemplate[6];
        lines[0]=new LineTemplate(55,40,45,70);
        lines[1]=new LineTemplate(45,70,50,70);
        lines[1].setColor(Color.decode("#14ffffff"));
        lines[2]=new LineTemplate(50,70,60,40);
        lines[3]=new LineTemplate(60,40,50,70);
        lines[4]=new LineTemplate(50,70,45,70);
        lines[4].setColor(Color.decode("#14ffffff"));
        lines[5]=new LineTemplate(45,70,55,40);
        return new Shape(lines,Path.FillType.EVEN_ODD,CUSTOM_SHAPE);
    }

    public static Shape getMagneetafsluiter(){
        ElementTemplate[] lines=new LineTemplate[18];
        lines[0]=new LineTemplate(50,20,20,30);
        lines[1]=new LineTemplate(20,30,20,10);
        lines[2]=new LineTemplate(20,10,50,20);
        lines[3]=new LineTemplate(50,20,80,10);
        lines[4]=new LineTemplate(80,10,80,30);
        lines[5]=new LineTemplate(80,30,50,20);
        lines[6]=new LineTemplate(50,20,50,60);
        lines[7]=new LineTemplate(50,60,30,60);
        lines[8]=new LineTemplate(30,60,30,70);
        lines[9]=new LineTemplate(30,70,10,70);
        lines[10]=new LineTemplate(10,70,30,70);
        lines[11]=new LineTemplate(30,70,30,80);
        lines[12]=new LineTemplate(30,80,70,80);
        lines[13]=new LineTemplate(70,80,70,70);
        lines[14]=new LineTemplate(70,70,90,70);
        lines[15]=new LineTemplate(90,70,70,70);
        lines[16]=new LineTemplate(70,70,70,60);
        lines[17]=new LineTemplate(70,60,50,60);
        for(int i=0;i<17;i++){
            lines[i].setColor(Color.BLACK);
        }
        return new Shape(lines,Path.FillType.EVEN_ODD,MAGNEETAFSLUITER );
    }

    public static Shape getTrimpomp(){
        int radius=40;
        ElementTemplate[] lines=new LineTemplate[366];
        float[] x=new float[360];
        float[] y=new float[360];
        for(int i=0;i<360;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            //radius+7 depending size
            x[i]=(float)Math.cos(rad)*radius+radius+7;
            y[i]=(float)Math.sin(rad)*radius+radius+7;
        }
        for(int i=0,j=0;i<360;i++,j++){
            if(i!=359){
                lines[j]=new LineTemplate(x[i],y[i],x[i+1],y[i+1]);
            }else{
                lines[j]=new LineTemplate(x[i],y[i],x[0],y[0]);
            }
            if(j==225){
                lines[++j]=new LineTemplate(x[225],y[225],x[0],y[0]);
                lines[j].setColor(Color.BLACK);
                lines[++j]=new LineTemplate(x[0],y[0],x[135],y[135]);
                lines[j].setColor(Color.BLACK);
                lines[++j]=new LineTemplate(x[135],y[135],x[225],y[225]-0.1f);
                lines[j].setColor(Color.BLACK);
                lines[++j]=new LineTemplate(x[225],y[225]-0.1f,x[135],y[135]);
                lines[j].setColor(Color.BLACK);
                lines[++j]=new LineTemplate(x[135],y[135],x[0],y[0]);
                lines[j].setColor(Color.BLACK);
                lines[++j]=new LineTemplate(x[0],y[0],x[225],y[225]);
                lines[j].setColor(Color.BLACK);
            }
            lines[j].setColor(Color.BLACK);
        }
        return new Shape(lines,Path.FillType.EVEN_ODD,TRIMPOMP);
    }

    public static Shape getManometer(){
        int radius=10;
        ElementTemplate[] lines=new LineTemplate[364];
        float[] x=new float[360];
        float[] y=new float[360];
        for(int i=0;i<360;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            //radius+7 depending size
            x[i]=(float)Math.cos(rad)*radius+70;
            y[i]=(float)Math.sin(rad)*radius+50;
        }
        for(int i=0,j=0;i<360;i++,j++){
            if(i!=359){
                lines[j]=new LineTemplate(x[i],y[i],x[i+1],y[i+1]);
            }else{
                lines[j]=new LineTemplate(x[i],y[i],x[0],y[0]);
            }
            if(j==180){
                lines[++j]=new LineTemplate(x[i],y[i],x[i]-40,y[i]);
                lines[++j]=new LineTemplate(x[i]-40,y[i],x[i],y[i]);
            }
            if(j==315){
                lines[++j]=new LineTemplate(x[315],y[315],x[135],y[135]-0.1f);
                lines[j].setColor(Color.BLACK);
                lines[++j]=new LineTemplate(x[135],y[135]-0.1f,x[315],y[315]);
                lines[j].setColor(Color.BLACK);
            }
            lines[j].setColor(Color.BLACK);
        }
        return new Shape(lines,Path.FillType.EVEN_ODD,MANOMETER);
    }

    public static Shape getAntiHevelklep(){
        ElementTemplate[] lines=new LineTemplate[5];
        lines[0]=new LineTemplate(50,30,50,50);
        lines[1]=new LineTemplate(50,50,20,30);
        lines[2]=new LineTemplate(20,30,20,70);
        lines[3]=new LineTemplate(30,70,50,50);
        lines[4]=new LineTemplate(50,50,50,70);
        return new Shape(lines,Path.FillType.EVEN_ODD,ANTIHEVELKLEP );
    }

    public static Shape getLeding(){
        ElementTemplate[] lines=new LineTemplate[1];
        lines[0]=new LineTemplate(20,50,70,50);
        return new Shape(lines,Path.FillType.EVEN_ODD,LEDING);
    }

    public static Shape getVirticalLeding(){
        ElementTemplate[] lines=new LineTemplate[1];
        lines[0]=new LineTemplate(50,20,50,70);
        return new Shape(lines,Path.FillType.EVEN_ODD,VERTICALLEDING);
    }

    public static Shape getBulktank(){
        float radius=50;
        ElementTemplate[] lines=new LineTemplate[1080];
        float[] x=new float[360];
        float[] y=new float[360];
        for(int i=0;i<360;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*radius+radius;
            y[i]=(float)Math.sin(rad)*radius+radius;
        }
        for(int i=0,j=0;i<360;i++,j++){
            if(i!=359){
                lines[j]=new LineTemplate(x[i],y[i],x[i+1],y[i+1]-0.1f);
            }else{
                lines[j]=new LineTemplate(x[i],y[i],x[0],y[0]);
            }
            lines[j].setColor(Color.BLACK);
        }
        for(int i=0;i<360;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*(radius+1)+radius;
            y[i]=(float)Math.sin(rad)*(radius+1)+radius;
        }
        for(int i=360,j=360;i<720;i++,j++){
            if(i!=719){
                lines[j]=new LineTemplate(x[i-360],y[i-360],x[i-360+1],y[i-360+1]-0.1f);
            }else{
                lines[j]=new LineTemplate(x[i-360],y[i-360],x[0],y[0]);
            }
            lines[j].setColor(Color.BLACK);
        }
        for(int i=0;i<360;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*(radius-1)+radius;
            y[i]=(float)Math.sin(rad)*(radius-1)+radius;
        }
        for(int i=720,j=720;i<1080;i++,j++){
            if(i!=1079){
                lines[j]=new LineTemplate(x[i-720],y[i-720],x[i-720+1],y[i-720+1]-0.1f);
            }else{
                lines[j]=new LineTemplate(x[i-720],y[i-720],x[0],y[0]);
            }
            lines[j].setColor(Color.BLACK);
        }
        return new Shape(lines,Path.FillType.EVEN_ODD,BULKTANK);
    }

    public static Shape getDoorvoer(){
        ElementTemplate[] lines=new LineTemplate[6];
        lines[0]=new LineTemplate(55,40,45,70);
        lines[1]=new LineTemplate(45,70,50,70);
        lines[1].setColor(Color.decode("#14ffffff"));
        lines[2]=new LineTemplate(50,70,60,40);
        lines[3]=new LineTemplate(60,40,50,70);
        lines[4]=new LineTemplate(50,70,45,70);
        lines[4].setColor(Color.decode("#14ffffff"));
        lines[5]=new LineTemplate(45,70,55,40);
        return new Shape(lines,Path.FillType.EVEN_ODD,DOORVOER);
    }

    public static Shape getFilter(){
        ElementTemplate[] lines=new LineTemplate[4];
        lines[0]=new LineTemplate(50,30,80,50);
        lines[1]=new LineTemplate(80,50,50,70);
        lines[2]=new LineTemplate(50,70,20,50);
        lines[3]=new LineTemplate(20,50,50,30);
        return new Shape(lines,Path.FillType.EVEN_ODD,FILTER);
    }

    public static Shape getHandafsluiter(){
        ElementTemplate[] lines=new LineTemplate[10];
        lines[0]=new LineTemplate(50,60,70,50);
        lines[1]=new LineTemplate(70,50,70,70);
        lines[2]=new LineTemplate(70,70,50,60);
        lines[3]=new LineTemplate(50,60,30,50);
        lines[4]=new LineTemplate(30,50,30,70);
        lines[5]=new LineTemplate(30,70,50,60);
        lines[6]=new LineTemplate(50,60,50,30);
        lines[7]=new LineTemplate(50,30,70,30);
        lines[8]=new LineTemplate(70,30,30,30);
        lines[9]=new LineTemplate(70,30,50,30);
        return new Shape(lines,Path.FillType.EVEN_ODD,HANDAFSLUITER);
    }

    public static Shape getDriewegkraan(){
        ElementTemplate[] lines=new LineTemplate[13];
        lines[0]=new LineTemplate(50,60,70,50);
        lines[1]=new LineTemplate(70,50,70,70);
        lines[2]=new LineTemplate(70,70,50,60);
        lines[3]=new LineTemplate(50,60,30,50);
        lines[4]=new LineTemplate(30,50,30,70);
        lines[5]=new LineTemplate(30,70,50,60);
        lines[6]=new LineTemplate(50,60,60,80);
        lines[7]=new LineTemplate(60,80,40,80);
        lines[8]=new LineTemplate(40,80,50,60);
        lines[9]=new LineTemplate(50,60,50,30);
        lines[10]=new LineTemplate(50,30,70,30);
        lines[11]=new LineTemplate(70,30,30,30);
        lines[12]=new LineTemplate(70,30,50,30);
        return new Shape(lines,Path.FillType.EVEN_ODD,DRIEWEGKRAAN);
    }

    public static Shape getDagtank(){
        float  radius=10;
        ElementTemplate[] lines=new LineTemplate[364];
        lines[0]=new LineTemplate(80,35,80,65);
        float[] x=new float[360];
        float[] y=new float[360];
        for(int i=0;i<90;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*radius+70;
            y[i]=(float)Math.sin(rad)*radius+65;
            if(i==0){
                lines[i+1]=new LineTemplate(60,50,x[i],y[i]);
                continue;
            }
            lines[i+1]=new LineTemplate(x[i-1],y[i-1],x[i],y[i]);
        }
        lines[91]=new LineTemplate(x[89],y[89],x[89]-40,y[89]);
        for(int i=90;i<180;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*radius+30;
            y[i]=(float)Math.sin(rad)*radius+65;
            if(i==90){
                lines[i+2]=new LineTemplate(x[89]-60,y[89],x[i],y[i]);
                continue;
            }
            lines[i+2]=new LineTemplate(x[i-1],y[i-1],x[i],y[i]);
        }
        lines[182]=new LineTemplate(x[179],y[179],x[179],y[179]-30);
        for(int i=180;i<270;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*radius+30;
            y[i]=(float)Math.sin(rad)*radius+35;
            if(i==180){
                lines[i+3]=new LineTemplate(x[179],y[179]-30,x[i],y[i]);
                continue;
            }
            lines[i+3]=new LineTemplate(x[i-1],y[i-1],x[i],y[i]);
        }
        lines[273]=new LineTemplate(x[269],y[269],x[269]+40,y[269]);
        for(int i=270;i<360;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)Math.cos(rad)*radius+70;
            y[i]=(float)Math.sin(rad)*radius+35;
            if(i==270){
                lines[i+4]=new LineTemplate(x[269]+40,y[269],x[i],y[i]);
                continue;
            }
            lines[i+4]=new LineTemplate(x[i-1],y[i-1],x[i],y[i]);
        }
        return new Shape(lines,Path.FillType.EVEN_ODD,DAGTANK);
    }

    public static Shape getFlexibel(){
        float  radius=25;
        ElementTemplate[] lines=new LineTemplate[1440];
        float[] x=new float[720];
        float[] y=new float[720];
        for(int i=0;i<720;i++){
            float rad = (float) ((float)i / 180 * 3.14);
            x[i]=(float)i*0.1f+15;
            y[i]=(float)Math.sin(rad)*radius+48;
        }
        for(int i=0,j=0;i<720;i++,j++){
            if(i!=719){
                lines[j]=new LineTemplate(x[i],y[i],x[i+1],y[i+1]);
            }else{
                lines[j]=new LineTemplate(x[i],y[i],x[i-1],y[i-1]);
            }
        }for(int i=720,j=719;i<1440;i++,j--){
            if(i!=1439){
                lines[i]=new LineTemplate(x[j],y[j],x[j-1],y[j-1]);
            }else{
                lines[i]=new LineTemplate(x[j],y[j],x[0],y[0]);
            }
        }
        return new Shape(lines,Path.FillType.EVEN_ODD,FLEXIBEL);
    }
}
