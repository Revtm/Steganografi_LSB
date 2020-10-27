/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.to.pkgbyte.array;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author revtm
 */


public class ImageToByteArray {
    public BufferedImage bImage;

    public void extractBiner() throws IOException{
        bImage = ImageIO.read(new File("sample.bmp"));
        int w_img = bImage.getWidth();
        int h_img = bImage.getHeight();
        int piksel;
        String pesan = "111111111111";
        int pjg_pesan = 0;
        
        for(int h = 0 ; h < h_img ; h++){
            for(int w = 0 ; w < w_img; w++){
                piksel = bImage.getRGB(h, w);
                Integer alpha = (piksel >> 24) & 0xff;
                Integer merah = (piksel >> 16) & 0xff;
                Integer hijau = (piksel >> 8) & 0xff;
                Integer biru = (piksel) & 0xff;
                String bin_merah = Integer.toBinaryString(merah);
                String bin_hijau = Integer.toBinaryString(hijau);
                String bin_biru = Integer.toBinaryString(biru);
                System.out.print(biru + "(" + bin_biru +") ");
                if(pjg_pesan < pesan.length()){
                    String bin_temp = bin_biru.substring(0, bin_biru.length()-1)+pesan.charAt(pjg_pesan);
                    biru = Integer.parseInt(bin_temp,2);
                    piksel = (alpha << 24) | (merah << 16) | (hijau << 8) | (biru);
                    bImage.setRGB(h, w, piksel);
                    pjg_pesan++;
                }
            }
            System.out.println("");
        }
      
    }
    
    public void imageToBiner() throws IOException{
        int w_img = bImage.getWidth();
        int h_img = bImage.getHeight();
        int piksel;
        
        for(int h = 0 ; h < h_img ; h++){
            for(int w = 0 ; w < w_img; w++){
                piksel = bImage.getRGB(h, w);
                Integer alpha = (piksel >> 24) & 0xff;
                Integer merah = (piksel >> 16) & 0xff;
                Integer hijau = (piksel >> 8) & 0xff;
                Integer biru = (piksel) & 0xff;
                String bin_merah = Integer.toBinaryString(merah);
                String bin_hijau = Integer.toBinaryString(hijau);
                String bin_biru = Integer.toBinaryString(biru);
                System.out.print(biru + "(" + bin_biru +") ");
            }
            System.out.println("");
        }
      
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        ImageToByteArray I = new ImageToByteArray();
//        I.extractBiner();
//        System.out.println("=======");
//        I.imageToBiner();
            System.out.println(Integer.toBinaryString(555));
        
    }
    
}
