//Created by Catherine Markley

import java.awt.*;
import java.applet.*;

public class InheritAndComp extends Applet {
    
    public void paint(Graphics g)
    {
        TrainCar trainCar1 = new TrainCar(g,50,50);
        
        TrainCar trainCar2 = new TrainCar(g,75,75);
        
        BlueLocomotive blueLoco1 = new BlueLocomotive(g,100,100);
    }
}


class Wheel
{
    public Wheel(Graphics g,int x,int y)
    {
        drawWheel(g,x,y);
    }
    
    public static void drawWheel(Graphics g,int x,int y)
    {
        g.setColor(Color.black);
        g.fillOval(x,y,20,20);
    }
}

class Window
{
    public Window(Graphics g,int x,int y)
    {
        drawWindow(g,x,y);
    }
    
    public static void drawWindow(Graphics g, int x, int y)
    {
        g.setColor(Color.black);
        g.fillRect(x,y,30,30);
    }
}

class Funnel
{
    public Funnel(Graphics g, int TopLeftRectX,int TopLeftRectY)
    {
        drawFunnel(g,TopLeftRectX,TopLeftRectY);
    }
    
    public static void drawFunnel(Graphics g, int TopLeftRectX, int TopLeftRectY)
    {
        g.setColor(Color.black);
        g.fillRect(TopLeftRectX,TopLeftRectY,30,50);
        
        int PointA = TopLeftRectX - 50;
        int PointB = TopLeftRectY - 30;
        int PointA2 = TopLeftRectX + 80;
        int PointA3 = TopLeftRectX + 30;
        
        Polygon quad = new Polygon();
        quad.addPoint(PointA,PointB);
        quad.addPoint(PointA2,PointB);
        quad.addPoint(PointA3,TopLeftRectY);
        quad.addPoint(TopLeftRectX,TopLeftRectY);
        g.fillPolygon(quad);
        
        g.fillRect(PointA,PointB,130,20);
    }
}

class Scoop
{
    public Scoop(Graphics g,int BottomLeftCarX,int BottomLeftCarY)
    {
        drawScoop(g,BottomLeftCarX,BottomLeftCarY);
    }
    
    public static void drawScoop(Graphics g,int BottomLeftCarX,int BottomLeftCarY)
    {
        Polygon triangle = new Polygon();
        
        int PointA = BottomLeftCarY - 37;
        int PointB = BottomLeftCarX - 37;
        
        triangle.addPoint(BottomLeftCarX,PointA);
        triangle.addPoint(BottomLeftCarX,BottomLeftCarY);
        triangle.addPoint(PointB,BottomLeftCarY);
        
        g.setColor(Color.black);
        
        g.fillPolygon(triangle);
    }
}

class TrainCar
{
    public TrainCar(Graphics g,int x,int y)
    {
        drawTrainCar(g,x,y);
        drawWheels(g,x,y);
    }
    
    public static void drawTrainCar(Graphics g,int x,int y)
    {
        g.setColor(new Color(231,111,100));
        g.fillRect(x,y,150,75);
        drawWheels(g,x,y);
        
    }
    
    public static void drawWheels(Graphics g, int x, int y)
    {
        g.setColor(Color.black);
        
        int a = x + 15;
        int b = y + 65;
        
        Wheel wheel1 = new Wheel(g,a,b);
        
        int c = x + 115;
        int d = y + 65;
        
        Wheel wheel2 = new Wheel(g,c,d);
    }
}

class Locomotive extends TrainCar
{
    public Locomotive(Graphics g,int x,int y)
    {
        super(g,x,y);
        drawLocomotive(g,x,y);
    }
    
    public static void drawLocomotive(Graphics g,int x,int y)
    {
        TrainCar Loco = new TrainCar(g,x,y);
        
        Window window1 = new Window(g,20,20);
        
        Window window2 = new Window(g,80,20);
        
        Funnel funnel1 = new Funnel(g,50,50);
        
        Scoop scoop1 = new Scoop(g,50,150);
        
    }	
}

class BlueLocomotive extends Locomotive
{
    public BlueLocomotive(Graphics g,int x,int y)
    {
        super(g,x,y);
        
        g.setColor(Color.blue);
        
        Locomotive blue1 = new Locomotive(g,x,y);
    }
}