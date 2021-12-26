package com.example.threefatftw;

// import org.json.simple.JSONObject;  
// import org.json.simple.JSONValue;  

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Main {
    @SuppressWarnings("unchecked")
    public static Double[] main(int initial, int result) {
		//System.out.println("zebi");
		String[] unitArray = {"USDBIF", "USDMWK", "USDBYR", "USDBYN", "USDHUF", "USDAOA", "USDJPY", "USDMNT", "USDPLN", "USDGBP", "USDSBD", "USDAWG", "USDKRW", "USDNPR", "USDINR", "USDYER", "USDAFN", "USDMVR", "USDKZT", "USDSRD", "USDSZL", "USDLTL", "USDSAR", "USDTTD", "USDBHD", "USDHTG", "USDANG", "USDPKR", "USDXCD", "USDLKR", "USDNGN", "USDCRC", "USDCZK", "USDZWL", "USDGIP", "USDRON", "USDMMK", "USDMUR", "USDNOK", "USDSYP", "USDIMP", "USDCAD", "USDBGN", "USDRSD", "USDDOP", "USDKMF", "USDCUP", "USDGMD", "USDTWD", "USDIQD", "USDSDG", "USDBSD", "USDSLL", "USDCUC", "USDZAR", "USDTND", "USDCLP", "USDHNL", "USDUGX", "USDMXN", "USDSTD", "USDLVL", "USDSCR", "USDCDF", "USDBBD", "USDGTQ", "USDFJD", "USDTMT", "USDCLF", "USDBRL", "USDPEN", "USDNZD", "USDWST", "USDNIO", "USDBAM", "USDEGP", "USDMOP", "USDNAD", "USDBZD", "USDMGA", "USDXDR", "USDCOP", "USDRUB", "USDPYG", "USDISK", "USDJMD", "USDLYD", "USDBMD", "USDKWD", "USDPHP", "USDBDT", "USDCNY", "USDTHB", "USDUZS", "USDXPF", "USDMRO", "USDIRR", "USDARS", "USDQAR", "USDGNF", "USDERN", "USDMZN", "USDSVC", "USDBTN", "USDUAH", "USDKES", "USDSEK", "USDCVE", "USDAZN", "USDTOP", "USDOMR", "USDPGK", "USDXOF", "USDGEL", "USDBTC", "USDUYU", "USDMAD", "USDFKP", "USDMYR", "USDEUR", "USDLSL", "USDDKK", "USDJOD", "USDHKD", "USDRWF", "USDAED", "USDBWP", "USDSHP", "USDTRY", "USDLBP", "USDTJS", "USDIDR", "USDKYD", "USDAMD", "USDGHS", "USDGYD", "USDKPW", "USDBOB", "USDKHR", "USDMDL", "USDAUD", "USDILS", "USDTZS", "USDVND", "USDXAU", "USDZMW", "USDLRD", "USDXAG", "USDALL", "USDCHF", "USDHRK", "USDDJF", "USDXAF", "USDKGS", "USDSOS", "USDVEF", "USDVUV", "USDLAK", "USDBND", "USDZMK", "USDETB", "USDJEP", "USDDZD", "USDPAB", "USDGGP", "USDSGD", "USDMKD", "USDUSD"};

		JSONParser jsonParser = new JSONParser();
		Double[] rates = new Double[2];
		try (FileReader reader = new FileReader("src/main/java/com/example/threefatftw/lastUpdatedValues.json")) {

			Object obj = jsonParser.parse(reader);
			String cc = obj.toString();



			JSONObject jobj = (JSONObject) obj;
			JSONObject quotes = (JSONObject) jobj.get("quotes");
			rates[0] = Double.parseDouble(String.valueOf( quotes.get(unitArray[initial])));
			rates[1] = Double.parseDouble(String.valueOf( quotes.get(unitArray[result])));

			//System.out.println(quotes.get(unitArray[result])+"/////\n\n"+unitArray[initial]+": "+rates[0]+"\n"+unitArray[result]+": "+rates[1]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//System.out.println(unitArray[initial]+": "+rates[0]+"\n"+unitArray[result]+": "+rates[1]);

		return rates;
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