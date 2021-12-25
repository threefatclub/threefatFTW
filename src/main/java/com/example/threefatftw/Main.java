package com.example.threefatftw;

// import org.json.simple.JSONObject;  
// import org.json.simple.JSONValue;  

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Main {
    @SuppressWarnings("unchecked")
    public static void main() {
        //System.out.println("zebi");       
        
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("src/main/java/com/example/threefatftw/lastUpdatedValues.json")) {
        	
        	Object obj = jsonParser.parse(reader);
            String cc = obj.toString();

            String subcc = cc.substring(cc.indexOf("quotes")+9,cc.lastIndexOf("}")-1);
            System.out.println("subcc:"+subcc);
            
            JSONObject quotes= (JSONObject) obj;
            JSONObject currencyRate= (JSONObject) quotes.get("quotes");            
            
            System.out.println(currencyRate.get("USDTND")); 
            
    		Quotes[] curr;
    		curr= new Quotes[168];
    		//System.out.println(curr[0].ref+"/"+curr[0].val);
    		
    		for (int a = 0; subcc.length() > 11;a++) {
        		curr[a]= new Quotes(
        				subcc.substring(1, 7),
        				Double.parseDouble( subcc.substring(subcc.indexOf(":")+1,subcc.indexOf(",") )
        						)
        				);
        		subcc =subcc.substring(subcc.indexOf(",")+1);
    		}
    		for (int a=0; a<166;a++) {
    			for(int b=0;b<166;b++) {
    				if (curr[a].ref.equals("USDTND") && curr[b].ref.equals("USDEUR")) {
    					System.out.println("EURUSD:"+1/curr[b].val+"///"+curr[b].val);
    					System.out.println("USDTND:"+curr[a].val+"///"+1/curr[a].val);
    					
    					System.out.println("EURTND:"+curr[a].val/curr[b].val+"///"+curr[b].val/curr[a].val);
    				}
    			}
    		}
    		//System.out.println("class Quotes{");
    		//for (int a = 0; subcc.length()>4 ;a++) {
    		//	System.out.println("	public double "+subcc.substring(1, 7)+" = "+subcc.substring(subcc.indexOf(":")+1,subcc.indexOf(",") )+";");
    		//	subcc =subcc.substring(subcc.indexOf(",")+1);
    		//}
    		//System.out.println("}");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
class Quotes{
	String ref;
	double val;
	public Quotes(String ref, double val) {
		this.ref= ref;
		this.val= val;
	}
}