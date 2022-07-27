
public class USACOCensoring {
	
	
	static void solve() {
		StringBuilder sb = new StringBuidlder();
		
		int len = t.length();
		for(int i= 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if(sb.length() >= len && sb.substring(sb.length() -len).equals(t)) {
				sb.delete(sb.length()-len,  sb.length()+1);
			}
		}
		
		out.println(sb.toString());
	}
}
