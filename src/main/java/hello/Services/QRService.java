
package hello.Services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import hello.ServerCommunication.QRCommunicator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;

@Service
public class QRService {
    public String getQRCodeUrl(String name, String description, String id) throws IOException {
        BufferedImage buffImage = generateQRCode(name, description, id);
        Base64.Encoder encoder = Base64.getEncoder();
        ImageIO.write(buffImage, "png", new File(".tmp."+"png"));
        String base64Str = "data:image/"+"png"+";base64,"+ encoder.encode(Files.readAllBytes(Paths.get(".tmp."+"png")));
        return base64Str;
    }
    
    private BufferedImage generateQRCode(String name, String descrtiption, String id) {
        String code;
        BufferedImage img = null; 
        code = QRCommunicator.generateCode(name, descrtiption, id);
        
        try {
            img = generateQRCodeImage(code, 500, 500, name);
        } catch (WriterException ex) {
            Logger.getLogger(QRService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QRService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return img;
    }
    
    private BufferedImage generateQRCodeImage(String text, int width, int height, String name)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Ico\\Desktop\\QRCodes\\"+ name +".png");
         MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return image;
    }
    
}
