import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

class jsonObject{
	/*since Hashtable must have a type for key and value,
	 *creates a Hashtable for each json type (numbers,booleans,nulls all get converted to string)
	*/
	Hashtable<String,String> jStr = new Hashtable<String,String>();
	Hashtable<String,jsonArray> jArr = new Hashtable<String,jsonArray>();
	Hashtable<String,jsonObject> jObj = new Hashtable<String,jsonObject>();
	
	void put(String key,String s) {
		jStr.put(key, s);
	}String oGetStr(String key) {//get a string from a jObject
		return jStr.get(key);
	}
	void put(String key,jsonArray a) {
		jArr.put(key, a);
	}jsonArray oGetArr(String key) {//get a jArray from a jObject
		return jArr.get(key);
	}
	void put(String key,jsonObject o) {
		jObj.put(key, o);
	}jsonObject oGetObj(String key) {//get a jObject from a jObject
		return jObj.get(key);
	}
}
class jsonArray{
	/*since ArrayList must have a type for key and value,
	 *creates a Hashtable for each json type (numbers,booleans,nulls all get converted to string)
	*/
	ArrayList<String> aStr = new ArrayList<String>();
	ArrayList<jsonObject> aObj = new ArrayList<jsonObject>();
	
	void add(String s) {
		aStr.add(s);
	}String aGetStr(int index) {//get a string from a jArray
		return aStr.get(index);
	}
	void add(jsonObject o) {
		aObj.add(o);
	}jsonObject aGetObj(int index) {//get a jObject from a jArray
		return aObj.get(index);
	}
}
public class urlParser {
	
	//sends a url and returns the respnse as a string
	private final String USER_AGENT = "Mozilla/5.0";
	private String sendGet(String url) throws Exception { // HTTP GET request
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();//System.out.println(response.toString());
		return response.toString();
	}
	
	//takes in a (String)Json file and parses it into Hashtables, arrayLists, and Strings
	static int x;
	static jsonObject jsonObjParse(String s,int index) {
		jsonObject jo = new jsonObject();
		for(int i=index; i<s.length();) {
			if(s.charAt(i-1)=='}'){//if empty jsonObject {}
				x = i;
				return jo;
			}
			//grab key
			x=s.indexOf('\"',i);//key from i to x-1, inbetween ""
			String key = s.substring(i,x);//System.out.println(key);
//			System.out.println("key: "+key);
			x+=2;
			if (s.charAt(x)=='[') {//if value == array '['
				jsonArray aa = new jsonArray();
				x++;
				while(s.charAt(x)!=']') {
					if (s.charAt(x)=='{')
						aa.add(jsonObjParse(s,x+2));
					else if (s.charAt(x)=='\"') {
						i=++x;
						x = s.indexOf('\"',i);
						aa.add(s.substring(i,x));
						x++;
					}//current code does not check for array of numbers,booleans,or nulls
					if(s.charAt(x)==',')
						x++;
				}
				jo.put(key,aa);
				x++;
			}
			else if (s.charAt(x)=='{')//if value is an object '{'
				jo.put(key,jsonObjParse(s,x+2));
			else if (s.charAt(x)=='\"') {//if value is a string '\"'
				i=++x; //set x to char after first "; set i to x
				x=s.indexOf('\"',i);//set x to second ";
				String val = s.substring(i,x);
//				System.out.println("value: "+val+" "+i);
				jo.put(key,val);
				x++;
			}
			else {//if value == number,boolean,or null
				i=x++;
				while(s.charAt(x)!=',' && s.charAt(x)!='}') {
					x++;
				}
				String val = s.substring(i,x);
//				System.out.println("value: "+val);
				jo.put(key,val);
			}
			if (s.charAt(x)==',') //continue looping if ','
				x+=2;
			else if(s.charAt(x)=='}'){//return if '}'
				x++;
				return jo;
			}
			i=x;
		}
		return jo;//*note* code doesn't reach here
	}
	
	public static void main(String[] args) throws Exception {
		urlParser http = new urlParser();//<-NOTE: name of constructor is name of file(___.java / public class ___)
		String ss = http.sendGet("http://api.yummly.com/v1/api/recipe/Meatball-Parmesan-Casserole-2626493?_app_id=e6ee5f7d&_app_key=bcf55972e39b5e7f20d9b329569a0359"); //System.out.println(ss.length());
		jsonObject searchResults = jsonObjParse(ss,2);//0 is "{" and 1 is quote, so we skip 2
		//System.out.println("\n~~ "+ searchResults.oGetObj("attributes").oGetArr("course").aGetStr(0) );
	}
}