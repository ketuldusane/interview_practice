package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Encode and Decode TinyURL
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
 * returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
 * algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 */

public class EncodeAndDecodeTinyURL {
  private Map<String, String> encodedUrl = new HashMap<>();
  private Map<String, String> decodedUrl = new HashMap<>();

  private final static String domain = "https://tinyurl.com/";

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    if (encodedUrl.containsKey(longUrl)) {
      return domain + encodedUrl.get(longUrl);
    } else {
      String hash = generateHash(longUrl);
      if (decodedUrl.containsKey(hash)) {
        hash = hash + ".";
      }
      encodedUrl.put(longUrl, hash);
      decodedUrl.put(hash, longUrl);
      return domain + hash;
    }
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String hash = shortUrl.substring(domain.length(), shortUrl.length());
    return decodedUrl.get(hash);
  }

  private String generateHash(String url) {
    long h = url.hashCode() ^ 31;
    return String.valueOf(h);
  }

  // Your Codec object will be instantiated and called as such:
  // Codec codec = new Codec();
  // codec.decode(codec.encode(url));
}
