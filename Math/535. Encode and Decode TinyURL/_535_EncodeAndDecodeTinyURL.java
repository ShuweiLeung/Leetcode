/*
Note: This is a companion problem to the System Design problem: Design TinyURL.

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
 it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode 
algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be 
decoded to the original URL.
 */

package math.medium;

import java.util.HashMap;
import java.util.Map.Entry;

public class _535_EncodeAndDecodeTinyURL {
	HashMap<String, String> map = new HashMap<>();		//key为longUrl，value为shortUrl

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    		String shortUrl = hash(longUrl);
        map.put(longUrl, shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    		String longUrl = "";
        for(Entry<String, String> entry : map.entrySet()) {
        		if(entry.getValue().compareTo(shortUrl) == 0)
        			longUrl = entry.getKey();
        }
        return longUrl;
    }
    
    public String hash(String longUrl) {
    		int hash = 0;  
    		int i;  
    		for (i=0; i<longUrl.length(); ++i) hash = 33*hash + longUrl.charAt(i);  
    		return String.valueOf(hash);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
