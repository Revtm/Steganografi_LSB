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
public class BuatStegfile {
    private BufferedImage cover;
    
    public BuatStegfile(BufferedImage cover){
        this.cover = cover;
    }
    
    public String konvPesan(String pesan){
        int sPesan = pesan.length();
        String konversi = "";
        String charKonversi;
        int temp;
        for(int i = 0 ; i < sPesan ; i++){
            temp = pesan.charAt(i);
            charKonversi = Integer.toBinaryString(temp);
            while(charKonversi.length() < 8){
                charKonversi = "0" + charKonversi;
            }
            konversi = konversi + charKonversi;
        }
        return konversi;
    }
    
    public boolean sisipPesan(String pesan) throws IOException{
        
        String kPesan = this.konvPesan(pesan);
        int nPesan = kPesan.length();
        String nPesanBiner = Integer.toBinaryString(nPesan);
        
        int panjang = this.cover.getHeight();
        int lebar = this.cover.getWidth();
        int n = 0, m = 0;
        int piksel;
        
        while(nPesanBiner.length() < 32){
            nPesanBiner = '0' + nPesanBiner;
        }
        
        if(nPesan < (panjang * lebar)){
            for(int x = 0 ; x < lebar ; x++ ){
                for(int y = 0 ; y < panjang ; y++){
                    piksel = this.cover.getRGB(x, y);
                    Integer alpha = (piksel >> 24) & 0xff;
                    Integer merah = (piksel >> 16) & 0xff;
                    Integer hijau = (piksel >> 8) & 0xff;
                    Integer biru = (piksel) & 0xff;
                    String bin_merah = Integer.toBinaryString(merah);
                    String bin_hijau = Integer.toBinaryString(hijau);
                    String bin_biru = Integer.toBinaryString(biru);

                    if(n < nPesanBiner.length()){
                        String bin_temp = bin_merah.substring(0, bin_merah.length()-1)+nPesanBiner.charAt(n);
                        merah = Integer.parseInt(bin_temp,2);
                        n++;
                    }

                    if(m < nPesan){
                        String bin_temp = bin_biru.substring(0, bin_biru.length()-1)+kPesan.charAt(m);
                        biru = Integer.parseInt(bin_temp,2);
                        m++;
                    }

                    piksel = (alpha << 24) | (merah << 16) | (hijau << 8) | (biru);
                    this.cover.setRGB(x, y, piksel);
                }
            }
            
            File f = new File("Stegofile.bmp"); 
            ImageIO.write(this.cover, "bmp", f); 
            
            return true;
        }else{
            System.out.println("pesan melebihi " + ((int)((panjang*lebar)/8)) + " karakter");
            return false;
        }      
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedImage cover = ImageIO.read(new File("suvafoto.jpeg"));
        BuatStegfile buat = new BuatStegfile(cover);
        boolean b = buat.sisipPesan("Aku anak ROHIS, Selalu Optimis...");
    }
}
