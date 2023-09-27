/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package desktopfilter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author DeLL
 */
public class ImagePanel extends javax.swing.JPanel {
    static Graphics g;

    /**
     * Creates new form ImagePanel
     */
    public ImagePanel() {
        initComponents();
    }
    
    
    public void paint(Graphics g){
        
    }

    public void setG(Graphics g) {
        this.g = g;
    }
    
    
    public void drawImg(BufferedImage image){
        int h = image.getHeight()*900/image.getWidth();
        g.drawImage(image, 10, 60, 900, h, this);
    }
    public void test(BufferedImage image){
        int h = image.getHeight()*880/image.getWidth();
        g.drawImage(image, 100, 200, 880, h, this);
    }
    
    public BufferedImage ChannelChanger(BufferedImage img, int flag){
        if (flag==1){
            for(int x=0; x<img.getWidth()-1; x++){
                for(int y=0; y<img.getHeight()-1; y++){
                    int pixel = img.getRGB(x, y);
                    int red = (pixel >> 16) & 0x0ff;
                    int green = (pixel >> 8) & 0x0ff;
                    int blue = (pixel) & 0x0ff;
                    img.setRGB(x, y, new Color(red, green, blue).getRGB());
                }
            }
        }
        if (flag==2){
            for(int x=0; x<img.getWidth()-1; x++){
                for(int y=0; y<img.getHeight()-1; y++){
                    int pixel = img.getRGB(x, y);
                    int red = (pixel >> 16) & 0x0ff;
                    int green = (pixel >> 8) & 0x0ff;
                    int blue = (pixel) & 0x0ff;
                    img.setRGB(x, y, new Color(red, blue, green).getRGB());              
                }
            }
        }
        if (flag==3){
            for(int x=0; x<img.getWidth()-1; x++){
                for(int y=0; y<img.getHeight()-1; y++){
                    int pixel = img.getRGB(x, y);
                    int red = (pixel >> 16) & 0x0ff;
                    int green = (pixel >> 8) & 0x0ff;
                    int blue = (pixel) & 0x0ff;         
                    img.setRGB(x, y, new Color(green, red, blue).getRGB());
                }
            }
        }
        if (flag==4){
            for(int x=0; x<img.getWidth()-1; x++){
                for(int y=0; y<img.getHeight()-1; y++){
                    int pixel = img.getRGB(x, y);
                    int red = (pixel >> 16) & 0x0ff;
                    int green = (pixel >> 8) & 0x0ff;
                    int blue = (pixel) & 0x0ff;         
                    img.setRGB(x, y, new Color(green, blue, red).getRGB());
                }
            }
        }
        if (flag==5){
            for(int x=0; x<img.getWidth(); x++){
                for(int y=0; y<img.getHeight()-1; y++){
                    int pixel = img.getRGB(x, y);
                    int red = (pixel >> 16) & 0x0ff;
                    int green = (pixel >> 8) & 0x0ff;
                    int blue = (pixel) & 0x0ff;         
                    img.setRGB(x, y, new Color(blue, green, red).getRGB());
                }
            }
        }
        if (flag==6){
            for(int x=0; x<img.getWidth(); x++){
                for(int y=0; y<img.getHeight()-1; y++){
                    int pixel = img.getRGB(x, y);
                    int red = (pixel >> 16) & 0x0ff;
                    int green = (pixel >> 8) & 0x0ff;
                    int blue = (pixel) & 0x0ff;         
                    img.setRGB(x, y, new Color(blue, red, green).getRGB());
                }
            }
        }
        return img;
    }
    public void Channells(BufferedImage img, int R, int G, int B, int br){
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int pixel = img.getRGB(x, y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                double temp = (R>0) ? ((255-red)/100): red/100;
                double temp2 = (G>0) ? ((255-green)/100): green/100;
                double temp3 = (B>0) ? ((255-blue)/100): blue/100;
                red += (int)(R*temp);
                green += (int)(G*temp2);
                blue += (int)(B*temp3);
                red += br;
                green += br;
                blue += br;
                if(red > 255){red = 255;}
                else if(red<0){red = 0;}
                if(green > 255){green = 255;}
                else if(green<0){green = 0;}
                if(blue > 255){blue = 255;}
                else if(blue<0){blue = 0;}
                img.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
    }
    public BufferedImage Monochrom(BufferedImage img){
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight()-1; y++){
                int pixel = img.getRGB(x, y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                int col = (red+green+blue)/3;
                img.setRGB(x, y, new Color(col, col, col).getRGB());                
            }
        }
        return img;
    }
    public BufferedImage Horizontal(BufferedImage img){
        int filter[][] = {{1,1,1},{0,0,0},{-1,-1,-1}};
        int imgmatrix[][][] = new int[img.getWidth()+2][img.getHeight()+2][3];
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int pixel = img.getRGB(x, y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;  
                imgmatrix[x+1][y+1][0] = red;
                imgmatrix[x+1][y+1][1] = green;
                imgmatrix[x+1][y+1][2] = blue;
            }
        }
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int sumR = 0;
                int sumG = 0;
                int sumB = 0;
                int b1 = -1;
                int b2 = -1;
                for(int i=0; i<3; i++){
                    for(int k=0; k<3; k++){
                        sumR += imgmatrix[x+b1+1][y+b2+1][0] * filter[b2+1][b1+1];
                        sumG += imgmatrix[x+b1+1][y+b2+1][1] * filter[b2+1][b1+1];
                        sumB += imgmatrix[x+b1+1][y+b2+1][2] * filter[b2+1][b1+1];
                        b1++;
                    }
                    b1 = -1;
                    b2++;
                }
                if(sumR>255){sumR=255;}
                if(sumR<0){sumR=0;}
                if(sumG>255){sumG=255;}
                if(sumG<0){sumG=0;}
                if(sumB>255){sumB=255;}
                if(sumB<0){sumB=0;}
                img.setRGB(x, y, new Color(sumR, sumG, sumB).getRGB());
                
            }
        }
        return img;
    }
    public BufferedImage Vertical(BufferedImage img){
        int filter[][] = {{1,0,-1},{1,0,-1},{1,0,-1}};
        int imgmatrix[][][] = new int[img.getWidth()+2][img.getHeight()+2][3];
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int pixel = img.getRGB(x, y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;  
                imgmatrix[x+1][y+1][0] = red;
                imgmatrix[x+1][y+1][1] = green;
                imgmatrix[x+1][y+1][2] = blue;
            }
        }
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int sumR = 0;
                int sumG = 0;
                int sumB = 0;
                int b1 = -1;
                int b2 = -1;
                for(int i=0; i<3; i++){
                    for(int k=0; k<3; k++){
                        sumR += imgmatrix[x+b1+1][y+b2+1][0] * filter[b2+1][b1+1];
                        sumG += imgmatrix[x+b1+1][y+b2+1][1] * filter[b2+1][b1+1];
                        sumB += imgmatrix[x+b1+1][y+b2+1][2] * filter[b2+1][b1+1];
                        b1++;
                    }
                    b1 = -1;
                    b2++;
                }
                if(sumR>255){sumR=255;}
                if(sumR<0){sumR=0;}
                if(sumG>255){sumG=255;}
                if(sumG<0){sumG=0;}
                if(sumB>255){sumB=255;}
                if(sumB<0){sumB=0;}
                img.setRGB(x, y, new Color(sumR, sumG, sumB).getRGB());
                
            }
        }
        return img;        
    }
    public BufferedImage Blur(BufferedImage img){
        int filter[][] = {{1,4,7,4,1},{4,16,26,16,4},{7,26,41,26,7}, {4,16,26,16,4}, {1,4,7,4,1}};
        int imgmatrix[][][] = new int[img.getWidth()+4][img.getHeight()+4][3];
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int pixel = img.getRGB(x, y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;  
                imgmatrix[x+2][y+2][0] = red;
                imgmatrix[x+2][y+2][1] = green;
                imgmatrix[x+2][y+2][2] = blue;
            }
        }
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int sumR = 0;
                int sumG = 0;
                int sumB = 0;
                int b1 = -2;
                int b2 = -2;
                for(int i=0; i<5; i++){
                    for(int k=0; k<5; k++){
                        sumR += imgmatrix[x+b1+2][y+b2+2][0] * filter[b2+2][b1+2];
                        sumG += imgmatrix[x+b1+2][y+b2+2][1] * filter[b2+2][b1+2];
                        sumB += imgmatrix[x+b1+2][y+b2+2][2] * filter[b2+2][b1+2];
                        b1++;
                    }
                    b1 = -2;
                    b2++;
                }
                sumR /= 273;
                sumG /= 273;
                sumB /= 273;
                if(sumR>255){sumR=255;}
                if(sumR<0){sumR=0;}
                if(sumG>255){sumG=255;}
                if(sumG<0){sumG=0;}
                if(sumB>255){sumB=255;}
                if(sumB<0){sumB=0;}
                img.setRGB(x, y, new Color(sumR, sumG, sumB).getRGB());
                
            }
        }
        return img;
    }
    public BufferedImage Combo(BufferedImage img){
        int filter[][] = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
        int imgmatrix[][][] = new int[img.getWidth()+2][img.getHeight()+2][3];
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int pixel = img.getRGB(x, y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;  
                imgmatrix[x+1][y+1][0] = red;
                imgmatrix[x+1][y+1][1] = green;
                imgmatrix[x+1][y+1][2] = blue;
            }
        }
        for(int x=0; x<img.getWidth(); x++){
            for(int y=0; y<img.getHeight(); y++){
                int sumR = 0;
                int sumG = 0;
                int sumB = 0;
                int b1 = -1;
                int b2 = -1;
                for(int i=0; i<3; i++){
                    for(int k=0; k<3; k++){
                        sumR += imgmatrix[x+b1+1][y+b2+1][0] * filter[b2+1][b1+1];
                        sumG += imgmatrix[x+b1+1][y+b2+1][1] * filter[b2+1][b1+1];
                        sumB += imgmatrix[x+b1+1][y+b2+1][2] * filter[b2+1][b1+1];
                        b1++;
                    }
                    b1 = -1;
                    b2++;
                }
                if(sumR>255){sumR=255;}
                if(sumR<0){sumR=0;}
                if(sumG>255){sumG=255;}
                if(sumG<0){sumG=0;}
                if(sumB>255){sumB=255;}
                if(sumB<0){sumB=0;}
                img.setRGB(x, y, new Color(sumR, sumG, sumB).getRGB());
                
            }
        }
        return img;
    }
    public void Gradient(int xc, int yc, int width, int height, Graphics g, Color col1, Color col2){
        float R = col1.getRed();
        float G = col1.getGreen();
        float B = col1.getBlue();
        
        float ri = (float)(col2.getRed()-R)/height;
        float gi = (float)(col2.getGreen()-G)/height;
        float bi = (float)(col2.getBlue()-B)/height;
        
        for(int y=0; y<=height; y++){
            g.setColor(new Color((int)R, (int)G, (int)B, 128));
            for(int x=0; x<=width; x++){
                g.fillRect(x+xc, y+yc, 1, 1);
            }
            R += ri;
            G += gi;
            B += bi;
        }
    
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(900, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
