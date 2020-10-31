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
public class EkstrakStegfile {
    private BufferedImage stegFile;
    
    public EkstrakStegfile(BufferedImage stegFile){
        this.stegFile = stegFile;
        
    }
    
    public String ekstrakPesan(){
        String pesan = "";
        
        int panjang = this.stegFile.getHeight();
        int lebar = this.stegFile.getWidth();
        int piksel, nPesan;
        char temp;
        String nPesanBiner = "", pesanBiner = "";
        
        for(int x = 0 ; x < lebar ; x++){
            for(int y = 0 ; y < panjang ; y++){
                piksel = this.stegFile.getRGB(x, y);
                Integer alpha = (piksel >> 24) & 0xff;
                Integer merah = (piksel >> 16) & 0xff;
                Integer hijau = (piksel >> 8) & 0xff;
                Integer biru = (piksel) & 0xff;
                String bin_merah = Integer.toBinaryString(merah);
                    
                if(nPesanBiner.length() < 32){
                    temp = bin_merah.charAt(bin_merah.length()-1);
                    
                    nPesanBiner = nPesanBiner + temp;
                }   
            }
        }
        
        nPesan = Integer.parseInt(nPesanBiner, 2);
        
        for(int x = 0 ; x < lebar ; x++){
            for(int y = 0 ; y < panjang ; y++){
                piksel = this.stegFile.getRGB(x, y);
                Integer alpha = (piksel >> 24) & 0xff;
                Integer merah = (piksel >> 16) & 0xff;
                Integer hijau = (piksel >> 8) & 0xff;
                Integer biru = (piksel) & 0xff;
                String bin_biru = Integer.toBinaryString(biru);
                    
                if(pesanBiner.length() < nPesan){
                    temp = bin_biru.charAt(bin_biru.length()-1);
                    pesanBiner = pesanBiner + temp;
                }   
            }
        }
        
        
        for(int i = 0 ; i < nPesan ; i=i+8){
            String tempPesan = pesanBiner.substring(i, i+8);
            int tempChar = Integer.parseInt(tempPesan, 2);
            temp = (char) tempChar;
            pesan = pesan + temp;
        }
        
        return pesan;
    }
    
    public static void main(String[] args) throws IOException {
       BufferedImage stegFile = ImageIO.read(new File("Stegofile.bmp"));
       EkstrakStegfile x = new EkstrakStegfile(stegFile);
       
       String pesan = x.ekstrakPesan();
       //String pesan = "rohis";
        System.out.println("pesan: " + pesan);
    }
}
