/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
public class XImage {
    public static Image getAppIcon(){
       URL url = XImage.class.getResource("/icons/8666686_github.png");
       return new ImageIcon(url).getImage();
    }
    public static Image getImageICon(){
       URL url = XImage.class.getResource("/icons/imgicon.png");
       return new ImageIcon(url).getImage();
    }
}
