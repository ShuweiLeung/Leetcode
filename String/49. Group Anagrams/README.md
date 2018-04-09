[Medium]Group Anagrams
===

## Description
Given an array of strings, group anagrams together.

For example, given: `["eat", "tea", "tan", "ate", "nat", "bat"]`,
Return:

    [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

**Note**: All inputs will be in lower-case.

## Idea
Using `Hashtable` for frequency count of the same groups of anagrams. Here, `key` can be a sorted string according to the lexicographical order of letters in a given word and `value` is the frequency of occurrence of the same groups of anagrams.
