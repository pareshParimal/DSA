class Solution {
    public String encode(List<String> strs) {
        int len;
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int j = 0,i=0, len = 0;
        int length = str.length();
        while (i<length) {
            if (str.charAt(i) == '#') {
                len = Integer.parseInt(str.substring(j, i));
                String sub = str.substring(i+1, i+1+len);
                list.add(sub);
                i = i + 1 + len;
                j = i;
            }else{
                i++;
            }
        }
        return list;
    }
}
