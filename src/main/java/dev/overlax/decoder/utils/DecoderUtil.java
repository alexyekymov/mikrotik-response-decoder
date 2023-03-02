package dev.overlax.decoder.utils;

public class DecoderUtil {
    public static String decode(String msg) {
        msg = msg.replaceAll("\\s", "");
        StringBuilder result = new StringBuilder();
        int k = 0;
        for (int i = 4; i < msg.length(); i = i + 4) {
            int hexVal = Integer.parseInt(msg.substring(k, i), 16);
            result.append((char) hexVal);
            k += 4;
        }
        return result.toString();
    }
}
