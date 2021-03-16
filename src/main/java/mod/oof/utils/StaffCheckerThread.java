package mod.oof.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class StaffCheckerThread implements Runnable {
    @Override
    public void run() {
        String url = "Custom Webserver URL";

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EntityUtils.toString(httpResponse.getEntity())));

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unable to make entity!");
        } catch (IOException e) {
            System.out.println("Unable to send request!");
        } catch (NullPointerException e) {
            System.out.println("Error");
        }
    }
}
