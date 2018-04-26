[Medium]Encode and Decode TinyURL
===

## Description
TinyURL is a URL shortening service where you enter a URL such as `https://leetcode.com/problems/design-tinyurl` and it returns a short URL such as `http://tinyurl.com/4e9iAk`.

Design the `encode` and `decode` methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

## Idea
This is an open problem so that there are variety of solutions. It is crucial how to design the hash function here. Besides, HashMap data structure should be used. The key is the longUrl and the value is its corresponding shortUrl.
