class IP {
    public static String checkIPValidity(String addressIP) {
        String answer = "hello";
        if(addressIP.length() == 0) return "Neither";
        String[] address = addressIP.split("\\.",-1);
        if(address.length == 4){
            for (String num : address) {
                try {
                    if ((num.length() > 1 && num.startsWith("0")) || Integer.parseInt(num) > 255) {
                        return "INVALID";
                    }
                } catch (Exception e) {
                    return "INVALID";
                }
            }
            return "VALID";
        }
        answer = "INVALID";
        return answer;
    }
}