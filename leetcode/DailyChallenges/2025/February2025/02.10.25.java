class Solution {
    public String removeOccurrences(String str, String part) {
        StringBuilder sb = new StringBuilder();
		char[] k = str.toCharArray();
		for (Character a : k) {
			sb.append(a);
			if (sb.length() >= part.length() && sb.substring(sb.length() - part.length()).equals(part)) {
				sb.replace(sb.length() - part.length(), sb.length(), "");
	}
		}
		return sb.substring(0);

        
    }
}
